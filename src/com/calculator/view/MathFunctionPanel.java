/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MathFunctionPanel {
	private GridBagConstraints gridConstraint;
	private JPanel mathFunctionPanel;
	private String buttonColor;
	private String buttonFontColor;
	private String operatorButtonColor;
	private Font FONT;
	private int buttonFontSize;

	private ArrayList<JButton> listAllButton;

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

		Map<Object, Boolean> iconButton = new HashMap<>();

		Object[] iconButtons = {
			undoIcon, redoIcon, PI_Icon, squareIcon, sqrtIcon, cubeIcon,
			cubeRootIcon, exponenIcon, rootNIcon, sepuluhPangkatNIcon
		};

		Map<Object, Boolean> operatorButtonMap = new HashMap<>(); // For green button
		for(int i = 0; i < iconButtons.length; i++) {
			operatorButtonMap.put(iconButtons[i], true);
		}

		listAllButton = new ArrayList<JButton>();

		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i] instanceof String) {
				String buttonName = (String) buttons[i];
				if(buttonName.equals("Rad")) {
					listAllButton.add(new Button(buttonName, operatorButtonColor, buttonFontColor, FONT).getButton());
				} else {
					listAllButton.add(new Button(buttonName, buttonColor, buttonFontColor, FONT).getButton());
				}
			} else {
				ImageIcon iconName = (ImageIcon) buttons[i];
				if(operatorButtonMap.containsKey(iconName)) {
					listAllButton.add(new Button(iconName, buttonColor).getButton());
					if(iconName == undoIcon) {
						listAllButton.get(i).setActionCommand("UNDO");
					}
				} else {
					listAllButton.add(new Button(iconName, buttonColor).getButton());
				}
			}

			mathFunctionPanel.add(listAllButton.get(i), gridConstraint);
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

	public ArrayList<JButton> getMathFunctionButton() {
		return listAllButton;
	}
	
	public JPanel getPanel() {
		return mathFunctionPanel;
	}
}
