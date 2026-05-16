/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScreenPanel {
	private JPanel screenPanel;
	private String backgroundColor;

	public ScreenPanel(String backgroundColor, JLabel screenLabel) {
		this.backgroundColor = backgroundColor;
		
		screenPanel = new JPanel();
		screenPanel.setLayout(new GridLayout());
		screenPanel.setBackground(Color.decode(backgroundColor));
		screenPanel.add(screenLabel, BorderLayout.CENTER);
		screenPanel.setPreferredSize(new Dimension(240, 150)); //panjang, tinggi
		screenPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	}
	
	public JPanel getPanel() {
		return screenPanel;
	}
}
