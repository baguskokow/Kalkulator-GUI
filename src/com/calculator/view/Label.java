/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Label {
	private JLabel screenLabel;
	private String text;
	private String textColor;
	private String backgroundColor;
	private final Font labelFont = new CalculatorFont("Inter", 1, 24).getFont();

	public Label(Font font, String textColor, String backgroundColor) {
		this.textColor = textColor;
		this.backgroundColor = backgroundColor;

		screenLabel = new JLabel(text);
		screenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		screenLabel.setFont(labelFont);
		screenLabel.setOpaque(true);
		screenLabel.setBackground(Color.decode(backgroundColor));
		screenLabel.setForeground(Color.decode(textColor));
		screenLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	public JLabel getLabel() {
		return screenLabel;
	}
}


