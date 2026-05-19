/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class NumberPanel {
	private GridBagConstraints gridConstraint;
	private JPanel numberPanel;
	private ImageIcon clearIcon;
	private String buttonColor;
	private String buttonFontColor;
	private String operatorButtonColor;
	private Font buttonFont;
	private ArrayList<JButton> listAllButton;

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
			"Ans", "AC", clearIcon, "÷", //U+00F7 = /
			"1", "2", "3", "×",
			"4", "5", "6", "-",
			"7", "8", "9", "+",
			"%", "0", ".", "="
		};

		// All of button in right side saved in listAllButton
		listAllButton = new ArrayList<JButton>();

		Map<Object, Boolean> greenButtonMap = new HashMap<>();
		
		Object[] greenButtons = {
			"Ans", "AC", clearIcon, "÷", "×", "-", "+", "="
		};

		for(int i = 0; i < greenButtons.length; i++) {
			greenButtonMap.put(greenButtons[i], true);
		}

		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i] instanceof String) {
				String buttonName = (String) buttons[i];
				
				if(greenButtonMap.containsKey(buttonName)) {
					listAllButton.add(new Button(buttonName, operatorButtonColor, buttonFontColor, buttonFont).getButton());
				} else {
					listAllButton.add(new Button(buttonName, buttonColor, buttonFontColor, buttonFont).getButton());
				}
			} else {
				ImageIcon iconName = (ImageIcon) buttons[i];
				if(greenButtonMap.containsKey(iconName)) {
					listAllButton.add(new Button(iconName, operatorButtonColor).getButton());
					if(iconName == clearIcon) {
						listAllButton.get(i).setActionCommand("BACKSPACE");
					}
				} else {
					listAllButton.add(new Button(iconName, buttonColor).getButton());
				}
			}

			numberPanel.add(listAllButton.get(i), gridConstraint);
		}
	}

	public ArrayList<JButton> getNumberButton() {
		return listAllButton;
	}
	
	public JPanel getPanel() {
		return numberPanel;
	}
}
