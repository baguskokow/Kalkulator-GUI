/*
 * Dibuat oleh Kelompok 9
 *
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

public class App {
	private final int WIDTH_FRAME = 500;
	private final int HEIGHT_FRAME = 500;

	private JFrame frame;
	private JTextField textField;
	private JPanel screenPanel;
	private JPanel mathFunctionPanel;
	private JPanel numberPanel;
	private JLabel XLabel;
	private JLabel YLabel;
	private JButton Button_0;
	private JButton Button_1;
	private JButton Button_2;
	private JButton Button_3;
	private JButton Button_4;
	private JButton Button_5;
	private JButton Button_6;
	private JButton Button_7;
	private JButton Button_8;
	private JButton Button_9;
	private JButton Button_Kali;
	private JButton Button_Bagi;
	private JButton Button_Tambah;
	private JButton Button_Kurang;
	private JButton Button_SamaDengan;
	private JButton Button_Cancel;
	private JButton Button_AC;
	private JButton Button_Ans;
	private JButton Button_Persentase;
	private JButton Button_Titik;
	private GridBagConstraints gridPosition;
	private ImageIcon cancelIcon;
	private Font buttonFont;
	
	public App(String appName) {
		frame = new JFrame(appName);
		GridBagConstraints gridConstraint = new GridBagConstraints();
		gridConstraint.fill = GridBagConstraints.BOTH;
		gridConstraint.weightx = 1.0;
		gridConstraint.weighty = 1.0;
	
		cancelIcon = new ImageIcon("./cancel.png");
		buttonFont = new Font("Consolas", Font.BOLD, 14);

		// TextField Area
		textField = new JTextField(100);
		textField.setPreferredSize(new Dimension(75, 75));
		textField.setBackground(Color.decode("#282A2F"));
		
		screenPanel = new JPanel();
		screenPanel.setBackground(Color.decode("#16181D"));
		screenPanel.setPreferredSize(new Dimension(0, 200));

		JPanel container = new JPanel();
		container.setLayout(new GridLayout(1, 2, 0, 50));

		mathFunctionPanel = new JPanel();
		mathFunctionPanel.setBackground(Color.decode("#16181D"));

		numberPanel = new JPanel();
		numberPanel.setBackground(Color.decode("#16181D"));
		numberPanel.setLayout(new GridLayout(5, 4, 5, 5));
		numberPanel.setPreferredSize(new Dimension(240, 400));
		numberPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Button Number or Left Area

		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		Button_Ans = new JButton("Ans");
		Button_Ans.setPreferredSize(new Dimension(10, 2));
		Button_Ans.setBackground(Color.decode("#24D366"));
		Button_Ans.setForeground(Color.WHITE);
		Button_Ans.setFont(new Font("Inter", Font.BOLD, 14));
		//Button_Ans.setMargin(new Insets(10, 20, 10, 20));

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 0;
		Button_AC = new JButton("AC");
		Button_AC.setPreferredSize(new Dimension(10, 2));
		Button_AC.setBackground(Color.decode("#24D366"));
		Button_AC.setForeground(Color.WHITE);
		Button_AC.setFont(new Font("Inter", Font.BOLD, 14));
		
		gridConstraint.gridx = 2;
		gridConstraint.gridy = 0;
		Button_Cancel = new JButton(cancelIcon);
		Button_Cancel.setPreferredSize(new Dimension(10, 2));
		Button_Cancel.setBackground(Color.decode("#24D366"));
		Button_Cancel.setForeground(Color.WHITE);
		Button_Cancel.setFont(new Font("Inter", Font.BOLD, 14));

		gridConstraint.gridx = 3;
		gridConstraint.gridy = 0;
		Button_Bagi = new JButton("/");
		Button_Bagi.setPreferredSize(new Dimension(10, 2));
		Button_Bagi.setBackground(Color.decode("#24D366"));
		Button_Bagi.setForeground(Color.WHITE);
		Button_Bagi.setFont(new Font("Inter", Font.BOLD, 14));

		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		Button_1 = new JButton("1");
		Button_1.setPreferredSize(new Dimension(10, 2));
		Button_1.setBackground(Color.decode("#282A2F"));
		Button_1.setForeground(Color.WHITE);

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 1;
		Button_2 = new JButton("2");
		Button_2.setPreferredSize(new Dimension(10, 2));
		Button_2.setBackground(Color.decode("#282A2F"));
		Button_2.setForeground(Color.WHITE);
		
		gridConstraint.gridx = 2;
		gridConstraint.gridy = 1;
		Button_3 = new JButton("3");
		Button_3.setPreferredSize(new Dimension(10, 2));
		Button_3.setBackground(Color.decode("#282A2F"));
		Button_3.setForeground(Color.WHITE);
		
		gridConstraint.gridx = 3;
		gridConstraint.gridy = 1;
		Button_Kali = new JButton("X");
		Button_Kali.setPreferredSize(new Dimension(10, 2));
		Button_Kali.setBackground(Color.decode("#24D366"));
		Button_Kali.setForeground(Color.WHITE);
		Button_Kali.setFont(new Font("Inter", Font.BOLD, 14));

		gridConstraint.gridx = 0;
		gridConstraint.gridy = 2;
		Button_4 = new JButton("4");
		Button_4.setPreferredSize(new Dimension(10, 2));
		Button_4.setBackground(Color.decode("#282A2F"));
		Button_4.setForeground(Color.WHITE);
		
		gridConstraint.gridx = 1;
		gridConstraint.gridy = 2;
		Button_5 = new JButton("5");
		Button_5.setPreferredSize(new Dimension(10, 2));
		Button_5.setBackground(Color.decode("#282A2F"));
		Button_5.setForeground(Color.WHITE);
	
		gridConstraint.gridx = 2;
		gridConstraint.gridy = 2;
		Button_6 = new JButton("6");
		Button_6.setPreferredSize(new Dimension(10, 2));
		Button_6.setBackground(Color.decode("#282A2F"));
		Button_6.setForeground(Color.WHITE);
		
		gridConstraint.gridx = 3;
		gridConstraint.gridy = 2;
		Button_Kurang = new JButton("-");
		Button_Kurang.setPreferredSize(new Dimension(10, 2));
		Button_Kurang.setBackground(Color.decode("#24D366"));
		Button_Kurang.setForeground(Color.WHITE);
		Button_Kurang.setFont(new Font("Inter", Font.BOLD, 14));
		
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 3;
		Button_7 = new JButton("7");
		Button_7.setPreferredSize(new Dimension(10, 2));
		Button_7.setBackground(Color.decode("#282A2F"));
		Button_7.setForeground(Color.WHITE);

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 3;
		Button_8 = new JButton("8");
		Button_8.setPreferredSize(new Dimension(10, 2));
		Button_8.setBackground(Color.decode("#282A2F"));
		Button_8.setForeground(Color.WHITE);

		gridConstraint.gridx = 2;
		gridConstraint.gridy = 3;
		Button_9 = new JButton("9");
		Button_9.setPreferredSize(new Dimension(10, 2));
		Button_9.setBackground(Color.decode("#282A2F"));
		Button_9.setForeground(Color.WHITE);

		gridConstraint.gridx = 3;
		gridConstraint.gridy = 3;
		Button_Tambah = new JButton("+");
		Button_Tambah.setPreferredSize(new Dimension(10, 2));
		Button_Tambah.setBackground(Color.decode("#24D366"));
		Button_Tambah.setForeground(Color.WHITE);
		Button_Tambah.setFont(new Font("Inter", Font.BOLD, 14));

		gridConstraint.gridx = 0;
		gridConstraint.gridy = 4;
		Button_Persentase = new JButton("%");
		Button_Persentase.setPreferredSize(new Dimension(10, 2));
		Button_Persentase.setBackground(Color.decode("#282A2F"));
		Button_Persentase.setForeground(Color.WHITE);

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 4;
		Button_0 = new JButton("0");
		Button_0.setPreferredSize(new Dimension(10, 2));
		Button_0.setBackground(Color.decode("#282A2F"));
		Button_0.setForeground(Color.WHITE);

		gridConstraint.gridx = 2;
		gridConstraint.gridy = 4;
		Button_Titik = new JButton(".");
		Button_Titik.setPreferredSize(new Dimension(10, 2));
		Button_Titik.setBackground(Color.decode("#282A2F"));
		Button_Titik.setForeground(Color.WHITE);

		gridConstraint.gridx = 3;
		gridConstraint.gridy = 4;
		Button_SamaDengan = new JButton("=");
		Button_SamaDengan.setPreferredSize(new Dimension(10, 2));
		Button_SamaDengan.setBackground(Color.decode("#24D366"));
		Button_SamaDengan.setForeground(Color.WHITE);
		Button_SamaDengan.setFont(new Font("Inter", Font.BOLD, 14));

		// Baris ke-1
		numberPanel.add(Button_Ans, gridConstraint);
		numberPanel.add(Button_AC, gridConstraint);
		numberPanel.add(Button_Cancel, gridConstraint);
		numberPanel.add(Button_Bagi, gridConstraint);
		
		// Baris ke-2
		numberPanel.add(Button_1, gridConstraint);
		numberPanel.add(Button_2, gridConstraint);
		numberPanel.add(Button_3, gridConstraint);
		numberPanel.add(Button_Kali, gridConstraint);
		
		// Baris ke-3
		numberPanel.add(Button_4, gridConstraint);
		numberPanel.add(Button_5, gridConstraint);
		numberPanel.add(Button_6, gridConstraint);
		numberPanel.add(Button_Kurang, gridConstraint);
		
		// Baris ke-4
		numberPanel.add(Button_7, gridConstraint);
		numberPanel.add(Button_8, gridConstraint);
		numberPanel.add(Button_9, gridConstraint);
		numberPanel.add(Button_Tambah, gridConstraint);
		
		// Baris ke-5
		numberPanel.add(Button_Persentase, gridConstraint);
		numberPanel.add(Button_0, gridConstraint);
		numberPanel.add(Button_Titik, gridConstraint);
		numberPanel.add(Button_SamaDengan, gridConstraint);

		screenPanel.add(textField, gridConstraint);
		screenPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));

		container.add(mathFunctionPanel);
		container.add(numberPanel);
		
		frame.setSize(900, 600);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout(0, 5));
		frame.getContentPane().setBackground(Color.decode("#1C1E23"));
		frame.setLocationRelativeTo(null);
		frame.add(screenPanel, BorderLayout.NORTH);
		frame.add(container, BorderLayout.CENTER);
	}

	public void show() {
		frame.setVisible(true);
	}
	
	public void setButtonAction(String text) {
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent action) {
				textField.setText(text);
			}	
		};

		//button.addActionListener(buttonListener);
	}
}

