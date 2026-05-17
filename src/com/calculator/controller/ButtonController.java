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
	private String rawText = "0";
	private boolean isCalculated = false;

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
		
		if(textTombol.equals("+") || textTombol.equals("-") || textTombol.equals("/") || textTombol.equals("X")) {
			isCalculated = false;
		}

		if(textTombol.equals("=")) {
			arithmetic = new Arithmetic(rawText);
			String result = arithmetic.getResult();
			rawText = result;
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
		} else if(textTombol != null && textTombol.isEmpty() != true) {
			boolean isOperator = textTombol.equals("+") || textTombol.equals("-") || textTombol.equals("/") || textTombol.equals("X");
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

	private String formatToLatex(String plainText) {
		if(plainText.isEmpty() || plainText.equals("0")) {
			return "0";
		}

		String formatted = plainText;

		return formatted;
	}

	private void updateLatexScreen(String textToRender) {
		try {
			String latexFormula = formatToLatex(textToRender);

			TeXFormula formula = new TeXFormula(latexFormula);
			TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 24);

			//screenLabel.setText("");
			screenLabel.setIcon(icon);

		} catch(Exception e) {
			screenLabel.setText(null);
			screenLabel.setText(textToRender);
			System.out.println("Ada error nihh!");
		}
	}
}
