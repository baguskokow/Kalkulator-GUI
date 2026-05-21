/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

class ButtonController implements ActionListener {
	private JButton button;
	private JLabel screenLabel;
	private ArrayList<JButton> listAllButton;
	private Arithmetic arithmetic;
	private Trigonometri trigonometri;
	private String rawText = "0";
	private boolean isCalculated = false;
	String functionType = "";																		

	public ButtonController(ArrayList<JButton> listAllButton, JLabel screen) {
		this.button = button;
		this.screenLabel = screen;
		this.listAllButton = listAllButton;
		this.screenLabel.setFont(new Font("Inter", Font.PLAIN, 24));

		for(int i = 0; i < listAllButton.size(); i++) {
			listAllButton.get(i).addActionListener(this);
		}
		updateLatexScreen(rawText);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		String textTombol = action.getActionCommand();
		System.out.println(textTombol); // Logger
																
		
		if(textTombol.equals("+") || textTombol.equals("-") || textTombol.equals("÷") || textTombol.equals("×")) {
			isCalculated = false;
		}


		if(textTombol.equals("=")) {
			if(rawText.contains("ln")) {
				int startIndex = rawText.indexOf("ln") + 2;
				int endIndex;
				
				if(rawText.contains(")")) {
					endIndex = rawText.indexOf(")");
				} else {
					endIndex = rawText.length() ;
				}

				if(endIndex > startIndex) {
					String operand = rawText.substring(startIndex, endIndex);
					
					LogarithmFunction logarithm = new LogarithmFunction(operand);
					String result = logarithm.getResult();

					//System.out.println("Cek logic : " + result); // debugging
					if(rawText.contains(")")) {
						rawText = rawText.replace("ln" + operand + ")", result);
					} else {
						rawText = rawText.replace("ln" + operand, result);
					}
				}
			}

			if(rawText.contains("log")) {
				int startIndex = rawText.indexOf("log") + 3;
				int endIndex;
				
				if(rawText.contains(")")) {
					endIndex = rawText.indexOf(")");
				} else {
					endIndex = rawText.length() ;
				}

				if(endIndex > startIndex) {
					String operand = rawText.substring(startIndex, endIndex);
					
					LogarithmFunction logarithm = new LogarithmFunction(operand);
					String result = logarithm.getResult();

					//System.out.println("Cek logic : " + result); // debugging
					if(rawText.contains(")")) {
						rawText = rawText.replace("log" + operand + ")", result);
					} else {
						rawText = rawText.replace("log" + operand, result);
					}
				}
			}

			trigonometry();


			arithmetic = new Arithmetic(rawText);
			String result = arithmetic.getResult();
			rawText = result;
			System.out.println("Cek logic ke-2 : " + rawText);
			updateLatexScreen(rawText);
			isCalculated = true;
			return;
		}
		
		if(textTombol.equals("AC")) {
			rawText = "0";
			updateLatexScreen(rawText);
			isCalculated = false;
			return;
		}

		if(textTombol.equals("BACKSPACE")) {
			if(rawText.length() > 0) {
				String newText = rawText.substring(0, rawText.length() - 1);
				rawText = newText;
				updateLatexScreen(rawText);
			}
		} else if(textTombol.equals("ln")) {
			if(rawText.equals("0") || isCalculated) {
				rawText = "ln";
			} else {
				rawText += "ln";
			}
			isCalculated = false;
			updateLatexScreen(rawText);
			return;
		} else if(textTombol.equals("log")) {
			if(rawText.equals("0") || isCalculated) {
				rawText = "log";
			} else {
				rawText += "log";
			}
			isCalculated = false;
			updateLatexScreen(rawText);
			return;
		} else if(textTombol != null && textTombol.isEmpty() != true) {
			boolean isOperator = textTombol.equals("+") || textTombol.equals("-") || textTombol.equals("÷") || textTombol.equals("×");
			if(isCalculated == true) {
				if (isOperator == true) {
					rawText += textTombol;
				} else {
					rawText = textTombol;
				}
				isCalculated = false;
			} else {
				if(rawText.equals("0")) {
					rawText = textTombol;
				} else {
					rawText += textTombol;
				}
			}

			updateLatexScreen(rawText);
		}
	}


	private void trigonometry() {
			// Set function type
			if(rawText.contains("sin")) {
				functionType = "sin";
			} else if(rawText.contains("cos")) {
				functionType = "cos";
			} else if(rawText.contains("tan")) {
				functionType = "tan";
			}


			if(rawText.contains("sin") || rawText.contains("cos") || rawText.contains("tan")) {
				int startIndex;
				int endIndex;
				
				if(rawText.contains("sin")) {
					startIndex = rawText.indexOf("sin") + 3;
				} else if(rawText.contains("cos")) {
					startIndex = rawText.indexOf("cos") + 3;
				} else {
					startIndex = rawText.indexOf("tan") + 3;
				}

				if(rawText.contains(")")) {
					endIndex = rawText.indexOf(")");
				} else {
					endIndex = rawText.length();
				}

				if(endIndex > startIndex) {
					String operand = rawText.substring(startIndex, endIndex);
					String type = rawText.substring(0, 3);
					String result = "";

					trigonometri = new Trigonometri(operand, functionType);
					result = trigonometri.getResult();
						
					if(rawText.contains(")")) {
						rawText = rawText.replace(functionType + operand + ")", result);
					} else {
						rawText = rawText.replace(functionType + operand, result);
					}
				}
			}
	}

	private String formatToLatex(String plainText) {
		String formatted;
		if(plainText.isEmpty() || plainText.equals("0")) {
			return "0";
		}

		if(plainText.contains("PI")) {
			formatted = plainText.replace("PI", "\\pi");
		}else if(plainText.contains("ln")) {
			formatted = plainText.replace("ln", "\\ln(");
		} else if(plainText.contains("log")) {
			formatted = plainText.replace("log", "\\log(");
		} else if(plainText.contains("sin")) {
			formatted = plainText.replace("sin", "\\sin(");
		} else if(plainText.contains("cos")) {
			formatted = plainText.replace("cos", "\\cos(");
		} else if(plainText.contains("tan")) {
			formatted = plainText.replace("tan", "\\tan(");
		} else {
			formatted = plainText;
		}

		return formatted;
	}

	private void updateLatexScreen(String textToRender) {
		try {
			String latexFormula = formatToLatex(textToRender);

			//System.out.println("Sebelum : " + latexFormula); // for debugging
			TeXFormula formula = new TeXFormula(latexFormula);
			TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 24);
			//System.out.println("Sesudah " + latexFormula); // for debugging

			screenLabel.setIcon(icon);

		} catch(Exception e) {
			screenLabel.setText(null);
			screenLabel.setText(textToRender);
			System.out.println("Ada error nihh!");
		}
	}
}
