/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NumberPanel {
	private GridBagConstraints gridConstraint;
	private JPanel numberPanel;
	private ImageIcon clearIcon;
	private String buttonColor;
	private String buttonFontColor;
	private String operatorButtonColor;
	private Font buttonFont;

	public NumberPanel(String buttonColor, String operatorButtonColor,String buttonFontColor, Font buttonFont) {
		this.buttonColor = buttonColor;
		this.buttonFontColor = buttonFontColor;
		this.buttonFont = buttonFont;
		this.operatorButtonColor = operatorButtonColor;
		
		numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(5, 4, 10, 10)); // 5 row, 4 coloumn, 10px distance per button
		numberPanel.setBackground(Color.decode("#16181D"));
		numberPanel.setPreferredSize(new Dimension(240, 400));
		numberPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		ImageHelper helperIcon = new ImageHelper("src/com/calculator/images/clearIcon.png", 20, 20);
		clearIcon = helperIcon.getImageIcon();
		
		Object[] buttons = {
			"Ans", "AC", clearIcon, "/",
			"1", "2", "3", "X",
			"4", "5", "6", "-",
			"7", "8", "9", "+",
			"%", "0", ".", "="
		};

		String[] greenButton = {
			"Ans", "AC", "/", "X", "-", "+", "="};


		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i] instanceof String) {
				String buttonName = (String) buttons[i];
				numberPanel.add(new Button(buttonName, buttonColor, buttonFontColor, buttonFont).getButton(), gridConstraint);
			} else {
				ImageIcon iconName = (ImageIcon) buttons[i];
				numberPanel.add(new Button(iconName, buttonColor).getButton(), gridConstraint);
			}
		}
	}
	
	public JPanel getPanel() {
		return numberPanel;
	}
}
