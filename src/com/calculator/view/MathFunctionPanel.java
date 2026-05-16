/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MathFunctionPanel {
	private GridBagConstraints gridConstraint;
	private JPanel mathFunctionPanel;
	private String buttonColor;
	private String buttonFontColor;
	private String operatorButtonColor;
	private Font FONT;
	private int buttonFontSize;

	// Image Icon
	private ImageIcon undoIcon;
	private ImageIcon redoIcon;
	private ImageIcon PI_Icon;
	private ImageIcon sqrtIcon;
	private ImageIcon rootNIcon;
	private ImageIcon cubeRootIcon;
	private ImageIcon squareIcon;
	private ImageIcon cubeIcon;
	private ImageIcon exponenIcon;
	private ImageIcon sepuluhPangkatNIcon;

	public MathFunctionPanel(String buttonColor, String operatorButtonColor,String buttonFontColor, Font FONT) {
		this.buttonColor = buttonColor;
		this.buttonFontColor = buttonFontColor;
		this.FONT = FONT;
		this.buttonFontSize = buttonFontSize;
		this.operatorButtonColor = operatorButtonColor;
		
		mathFunctionPanel = new JPanel();
		mathFunctionPanel.setLayout(new GridLayout(5, 4, 10, 10)); // 5 row, 4 coloumn, 10px distance per button
		mathFunctionPanel.setBackground(Color.decode("#16181D"));
		mathFunctionPanel.setPreferredSize(new Dimension(240, 400));
		mathFunctionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		setupImageIcon();

		Object[] buttons = {
			"Rad", "Deg", undoIcon, redoIcon,
			"(", ")", "ln", "e",
			PI_Icon, "log", squareIcon, sqrtIcon,
			cubeIcon, cubeRootIcon, exponenIcon, rootNIcon,
			"sin", "cos", "tan", sepuluhPangkatNIcon
		};

		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i] instanceof String) {
				String buttonName = (String) buttons[i];
				mathFunctionPanel.add(new Button(buttonName, buttonColor, buttonFontColor, FONT).getButton(), gridConstraint);
			} else {
				ImageIcon iconName = (ImageIcon) buttons[i];
				mathFunctionPanel.add(new Button(iconName, buttonColor).getButton(), gridConstraint);
			}
		}
	}

	private void setupImageIcon() {
		this.undoIcon = new ImageHelper("src/com/calculator/images/undoIcon.png", 20, 20).getImageIcon();
		this.redoIcon = new ImageHelper("src/com/calculator/images/redoIcon.png", 20, 20).getImageIcon();
		this.PI_Icon = new ImageHelper("src/com/calculator/images/piIcon.png", 20, 20).getImageIcon();
		this.sqrtIcon = new ImageHelper("src/com/calculator/images/sqrtIcon.png", 20, 20).getImageIcon();
		this.rootNIcon = new ImageHelper("src/com/calculator/images/rootN.png", 20, 20).getImageIcon();
		this.cubeRootIcon = new ImageHelper("src/com/calculator/images/cubeRoot.png", 20, 20).getImageIcon();
		this.squareIcon = new ImageHelper("src/com/calculator/images/squareIcon.png", 20, 20).getImageIcon();
		this.cubeIcon = new ImageHelper("src/com/calculator/images/cubeIcon.png", 20, 20).getImageIcon();
		this.exponenIcon = new ImageHelper("src/com/calculator/images/exponenIcon.png", 20, 20).getImageIcon();
		this.sepuluhPangkatNIcon = new ImageHelper("src/com/calculator/images/sepuluhPangkatNIcon.png", 20, 20).getImageIcon();
	}
	
	public JPanel getPanel() {
		return mathFunctionPanel;
	}
}
