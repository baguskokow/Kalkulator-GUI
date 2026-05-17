/*
 * Dibuat oleh Kelompok 9
 *
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//import org.scilab.forge.jlatexmath.TeXFormula;
//import org.scilab.forge.jlatexmath.TeXIcon;
//import org.scilab.forge.jlatexmath.TeXConstants;

public class App {
	private final int WIDTH_FRAME = 900;
	private final int HEIGHT_FRAME = 600;
	private final Font buttonFont = new CalculatorFont("Inter", 1, 18).getFont();
	private final Font screenFont = new CalculatorFont("Inter", 1, 24).getFont();
	private final String operatorButtonColor = "#24D366";
	private final String buttonColor = "#282A2F";
	private final String labelColor = "#282A2F";
	private final String buttonFontColor = "#ffffff";
	private final String fontColor = "#d4d0c5";
	private final int buttonFontSize = 14;

	private ArrayList<JButton> listOfButtonNumber;
	private ArrayList<JButton> listOfMathFunctionButton;
	private ArrayList<JButton> listAllButtons = new ArrayList<JButton>();

	private ButtonController buttonController;

	private JFrame frame;
	private JPanel screenPanel;
	private JPanel mathFunctionPanel;
	private JPanel numberPanel;
	
	private JLabel screenLabel;

	public App(String appName) {
		frame = new JFrame(appName);
		GridBagConstraints gridConstraint = new GridBagConstraints();
		gridConstraint.fill = GridBagConstraints.BOTH;
		gridConstraint.weightx = 1.0;
		gridConstraint.weighty = 1.0;

		// Define Label
		screenLabel = new Label(screenFont, fontColor, labelColor).getLabel();

		// Define Panel
		NumberPanel numberPanel = new NumberPanel(buttonColor, operatorButtonColor, buttonFontColor, buttonFont);
		numberPanel.getPanel();
		
		MathFunctionPanel mathFunctionPanel = new MathFunctionPanel(buttonColor, operatorButtonColor, buttonFontColor, buttonFont);
		mathFunctionPanel.getPanel();

		ScreenPanel screenPanel = new ScreenPanel("#16181D", screenLabel);
		screenPanel.getPanel();


		// Get Button
		listOfButtonNumber = numberPanel.getNumberButton();
		listOfMathFunctionButton = mathFunctionPanel.getMathFunctionButton();
		combineButton(listOfButtonNumber, listOfMathFunctionButton); // Menggabungkan numberButton dan juga mathFunctionButton
		
		// Container
		JPanel containerAtas = new JPanel();
		containerAtas.setLayout(new BorderLayout());
		containerAtas.setBackground(Color.decode("#16181D"));
		
		JPanel containerBawah = new JPanel();
		containerBawah.setLayout(new GridLayout(1, 2, 0, 50));

		containerAtas.add(screenPanel.getPanel(), BorderLayout.CENTER);
		
		containerBawah.add(mathFunctionPanel.getPanel());
		containerBawah.add(numberPanel.getPanel());

		addEvent();
		
		frame.setSize(WIDTH_FRAME, HEIGHT_FRAME);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout(0, 5));
		frame.getContentPane().setBackground(Color.decode("#1C1E23"));
		frame.setLocationRelativeTo(null);
		frame.add(containerAtas, BorderLayout.NORTH);
		frame.add(containerBawah, BorderLayout.CENTER);
	}

	public void addEvent() {
		buttonController = new ButtonController(listAllButtons, screenLabel);
	}

	public void show() {
		frame.setVisible(true);
	}

	public void combineButton(ArrayList<JButton> buttonNumber, ArrayList<JButton> mathFunctionButton) {
		for(int i = 0; i < buttonNumber.size(); i++) {
			listAllButtons.add(buttonNumber.get(i));		
		}
		
		for(int i = 0; i < mathFunctionButton.size(); i++) {
			listAllButtons.add(mathFunctionButton.get(i));			
		}
	}

	private ImageIcon resizeIcon(ImageIcon img, int width, int height) {
		Image temp = img.getImage();

		Image resizedTemp = temp.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(resizedTemp);

		return result;
	}
}

