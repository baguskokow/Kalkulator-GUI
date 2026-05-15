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

	// Button at Left Side
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

	// Button at Right Side
	private JButton Button_Rad;
	private JButton Button_Deg;
	private JButton Button_Undo;
	private JButton Button_Redo;
	private JButton Button_KurungBuka;
	private JButton Button_KurungTutup;
	private JButton Button_Ln;
	private JButton Button_Euler;
	private JButton Button_PI;
	private JButton Button_Log;
	private JButton Button_Kuadrat;
	private JButton Button_Akar;
	private JButton Button_Cube;
	private JButton Button_AkarPangkatTiga;
	private JButton Button_Exponen;
	private JButton Button_AkarPangkatN;
	private JButton Button_Sin;
	private JButton Button_Cos;
	private JButton Button_Tan;
	private JButton Button_SepuluhPangkatN;
	
	private GridBagConstraints gridPosition;
	private ImageIcon clearIcon;
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
	
	private Font textFieldFont;

	public App(String appName) {
		frame = new JFrame(appName);
		GridBagConstraints gridConstraint = new GridBagConstraints();
		gridConstraint.fill = GridBagConstraints.BOTH;
		gridConstraint.weightx = 1.0;
		gridConstraint.weighty = 1.0;

		ImageIcon rawClearIcon = new ImageIcon("src/com/calculator/images/clearIcon.png");
		ImageIcon rawUndoIcon = new ImageIcon("src/com/calculator/images/undoIcon.png"); 
		ImageIcon rawRedoIcon = new ImageIcon("src/com/calculator/images/redoIcon.png"); 
		ImageIcon rawPI_Icon = new ImageIcon("src/com/calculator/images/piIcon.png"); 
		ImageIcon rawSqrtIcon = new ImageIcon("src/com/calculator/images/sqrtIcon.png"); 
		ImageIcon rawRootNIcon = new ImageIcon("src/com/calculator/images/rootN.png"); 
		ImageIcon rawCubeRootIcon = new ImageIcon("src/com/calculator/images/cubeRoot.png"); 
		ImageIcon rawSquareIcon = new ImageIcon("src/com/calculator/images/squareIcon.png"); 
		ImageIcon rawCubeIcon = new ImageIcon("src/com/calculator/images/cubeIcon.png"); 
		ImageIcon rawExponenIcon = new ImageIcon("src/com/calculator/images/exponenIcon.png"); 
		ImageIcon rawSepuluhPangkatNIcon = new ImageIcon("src/com/calculator/images/sepuluhPangkatNIcon.png"); 
		
		clearIcon = resizeIcon(rawClearIcon, 20, 20);
		undoIcon = resizeIcon(rawUndoIcon, 20, 20);
		redoIcon = resizeIcon(rawRedoIcon, 20, 20);
		PI_Icon = resizeIcon(rawPI_Icon, 20, 20);
		sqrtIcon = resizeIcon(rawSqrtIcon, 20, 20);
		rootNIcon = resizeIcon(rawRootNIcon, 20, 20);
		cubeRootIcon = resizeIcon(rawCubeRootIcon, 20, 20);
		squareIcon = resizeIcon(rawSquareIcon, 20, 20);
		cubeIcon = resizeIcon(rawCubeIcon, 20, 20);
		exponenIcon = resizeIcon(rawExponenIcon, 20, 20);
		sepuluhPangkatNIcon = resizeIcon(rawSepuluhPangkatNIcon, 20, 20);

		textFieldFont = new Font("Inter", Font.BOLD, 28);

		// TextField Area
		textField = new JTextField("Haloo Teman-Teman!");
		textField.setPreferredSize(new Dimension(900, 75)); // Lebar TextField adalah 75
		textField.setHorizontalAlignment(JTextField.RIGHT); // Agar inputnya dari kanan -> kiri
		textField.setBackground(Color.decode("#282A2F"));
		textField.setForeground(Color.WHITE);
		textField.setFont(textFieldFont);
		textField.setBorder(new javax.swing.border.LineBorder(Color.decode("#282A2F"), 2, true));
		
		// Container
		JPanel containerAtas = new JPanel();
		containerAtas.setLayout(new FlowLayout());
		containerAtas.setBackground(Color.decode("#16181D"));
		
		JPanel containerBawah = new JPanel();
		containerBawah.setLayout(new GridLayout(1, 2, 0, 50));

		screenPanel = new JPanel(new FlowLayout());
		screenPanel.setBackground(Color.decode("#16181D"));
		//screenPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		screenPanel.add(textField, BorderLayout.CENTER);
		containerAtas.add(screenPanel, BorderLayout.CENTER);
		


		// Math Functions Panel
		mathFunctionPanel = new JPanel();
		mathFunctionPanel.setLayout(new GridLayout(5, 4, 5, 5));
		mathFunctionPanel.setBackground(Color.decode("#16181D"));
		mathFunctionPanel.setPreferredSize(new Dimension(240, 400));
		mathFunctionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Number Panel
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

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 0;
		Button_AC = new JButton("AC");
		Button_AC.setPreferredSize(new Dimension(10, 2));
		Button_AC.setBackground(Color.decode("#24D366"));
		Button_AC.setForeground(Color.WHITE);
		Button_AC.setFont(new Font("Inter", Font.BOLD, 14));
		
		gridConstraint.gridx = 2;
		gridConstraint.gridy = 0;
		Button_Cancel = new JButton(clearIcon);
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
		
		// Math Function Grid
		gridConstraint.gridx = 0;
		gridConstraint.gridy = 0;
		Button_Rad = new JButton("Rad");
		Button_Rad.setPreferredSize(new Dimension(10, 2));
		Button_Rad.setBackground(Color.decode("#24D366"));
		Button_Rad.setForeground(Color.WHITE);
		Button_Rad.setFont(new Font("Inter", Font.BOLD, 14));
		
		gridConstraint.gridx = 1;
		gridConstraint.gridy = 0;
		Button_Deg = new JButton("Deg");
		Button_Deg.setPreferredSize(new Dimension(10, 2));
		Button_Deg.setBackground(Color.decode("#282A2F"));
		Button_Deg.setForeground(Color.decode("#A0A0A0"));

		gridConstraint.gridx = 2;
		gridConstraint.gridy = 0;
		Button_Undo = new JButton(undoIcon);
		Button_Undo.setPreferredSize(new Dimension(10, 2));
		Button_Undo.setBackground(Color.decode("#282A2F"));
		Button_Undo.setForeground(Color.WHITE);

		gridConstraint.gridx = 3;
		gridConstraint.gridy = 0;
		Button_Redo = new JButton(redoIcon);
		Button_Redo.setPreferredSize(new Dimension(10, 2));
		Button_Redo.setBackground(Color.decode("#282A2F"));
		Button_Redo.setForeground(Color.WHITE);

		gridConstraint.gridx = 0;
		gridConstraint.gridy = 1;
		Button_KurungBuka = new JButton("(");
		Button_KurungBuka.setPreferredSize(new Dimension(10, 2));
		Button_KurungBuka.setBackground(Color.decode("#282A2F"));
		Button_KurungBuka.setForeground(Color.WHITE);

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 1;
		Button_KurungTutup = new JButton(")");
		Button_KurungTutup.setPreferredSize(new Dimension(10, 2));
		Button_KurungTutup.setBackground(Color.decode("#282A2F"));
		Button_KurungTutup.setForeground(Color.WHITE);

		gridConstraint.gridx = 2;
		gridConstraint.gridy = 1;
		Button_Ln = new JButton("ln");
		Button_Ln.setPreferredSize(new Dimension(10, 2));
		Button_Ln.setBackground(Color.decode("#282A2F"));
		Button_Ln.setForeground(Color.WHITE);

		gridConstraint.gridx = 3;
		gridConstraint.gridy = 1;
		Button_Euler = new JButton("e");
		Button_Euler.setPreferredSize(new Dimension(10, 2));
		Button_Euler.setBackground(Color.decode("#282A2F"));
		Button_Euler.setForeground(Color.WHITE);

		gridConstraint.gridx = 0;
		gridConstraint.gridy = 2;
		Button_PI = new JButton(PI_Icon);
		Button_PI.setPreferredSize(new Dimension(10, 2));
		Button_PI.setBackground(Color.decode("#282A2F"));
		Button_PI.setForeground(Color.WHITE);

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 2;
		Button_Log = new JButton("log");
		Button_Log.setPreferredSize(new Dimension(10, 2));
		Button_Log.setBackground(Color.decode("#282A2F"));
		Button_Log.setForeground(Color.WHITE);

		gridConstraint.gridx = 2;
		gridConstraint.gridy = 2;
		Button_Kuadrat = new JButton(squareIcon);
		Button_Kuadrat.setPreferredSize(new Dimension(10, 2));
		Button_Kuadrat.setBackground(Color.decode("#282A2F"));
		Button_Kuadrat.setForeground(Color.WHITE);

		gridConstraint.gridx = 3;
		gridConstraint.gridy = 2;
		Button_Akar = new JButton(sqrtIcon);
		Button_Akar.setPreferredSize(new Dimension(10, 2));
		Button_Akar.setBackground(Color.decode("#282A2F"));
		Button_Akar.setForeground(Color.WHITE);

		gridConstraint.gridx = 0;
		gridConstraint.gridy = 3;
		Button_Cube = new JButton(cubeIcon);
		Button_Cube.setPreferredSize(new Dimension(10, 2));
		Button_Cube.setBackground(Color.decode("#282A2F"));
		Button_Cube.setForeground(Color.WHITE);

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 3;
		Button_AkarPangkatTiga = new JButton(cubeRootIcon);
		Button_AkarPangkatTiga.setPreferredSize(new Dimension(10, 2));
		Button_AkarPangkatTiga.setBackground(Color.decode("#282A2F"));
		Button_AkarPangkatTiga.setForeground(Color.WHITE);

		gridConstraint.gridx = 2;
		gridConstraint.gridy = 3;
		Button_Exponen = new JButton(exponenIcon);
		Button_Exponen.setPreferredSize(new Dimension(10, 2));
		Button_Exponen.setBackground(Color.decode("#282A2F"));
		Button_Exponen.setForeground(Color.WHITE);

		gridConstraint.gridx = 3;
		gridConstraint.gridy = 3;
		Button_AkarPangkatN = new JButton(rootNIcon);
		Button_AkarPangkatN.setPreferredSize(new Dimension(10, 2));
		Button_AkarPangkatN.setBackground(Color.decode("#282A2F"));
		Button_AkarPangkatN.setForeground(Color.WHITE);

		gridConstraint.gridx = 0;
		gridConstraint.gridy = 4;
		Button_Sin = new JButton("sin");
		Button_Sin.setPreferredSize(new Dimension(10, 2));
		Button_Sin.setBackground(Color.decode("#282A2F"));
		Button_Sin.setForeground(Color.WHITE);

		gridConstraint.gridx = 1;
		gridConstraint.gridy = 4;
		Button_Cos = new JButton("cos");
		Button_Cos.setPreferredSize(new Dimension(10, 2));
		Button_Cos.setBackground(Color.decode("#282A2F"));
		Button_Cos.setForeground(Color.WHITE);

		gridConstraint.gridx = 2;
		gridConstraint.gridy = 4;
		Button_Tan = new JButton("tan");
		Button_Tan.setPreferredSize(new Dimension(10, 2));
		Button_Tan.setBackground(Color.decode("#282A2F"));
		Button_Tan.setForeground(Color.WHITE);

		gridConstraint.gridx = 3;
		gridConstraint.gridy = 4;
		Button_SepuluhPangkatN = new JButton(sepuluhPangkatNIcon);
		Button_SepuluhPangkatN.setPreferredSize(new Dimension(10, 2));
		Button_SepuluhPangkatN.setBackground(Color.decode("#282A2F"));
		Button_SepuluhPangkatN.setForeground(Color.WHITE);

		// Baris ke-1
		mathFunctionPanel.add(Button_Rad, gridConstraint);
		mathFunctionPanel.add(Button_Deg, gridConstraint);
		mathFunctionPanel.add(Button_Undo, gridConstraint);
		mathFunctionPanel.add(Button_Redo, gridConstraint);
		
		// Baris ke-2
		mathFunctionPanel.add(Button_KurungBuka, gridConstraint);
		mathFunctionPanel.add(Button_KurungTutup, gridConstraint);
		mathFunctionPanel.add(Button_Ln, gridConstraint);
		mathFunctionPanel.add(Button_Euler, gridConstraint);
		
		// Baris ke-3
		mathFunctionPanel.add(Button_PI, gridConstraint);
		mathFunctionPanel.add(Button_Log, gridConstraint);
		mathFunctionPanel.add(Button_Kuadrat, gridConstraint);
		mathFunctionPanel.add(Button_Akar, gridConstraint);
		
		// Baris ke-4
		mathFunctionPanel.add(Button_Cube, gridConstraint);
		mathFunctionPanel.add(Button_AkarPangkatTiga, gridConstraint);
		mathFunctionPanel.add(Button_Exponen, gridConstraint);
		mathFunctionPanel.add(Button_AkarPangkatN, gridConstraint);
		
		// Baris ke-5
		mathFunctionPanel.add(Button_Sin, gridConstraint);
		mathFunctionPanel.add(Button_Cos, gridConstraint);
		mathFunctionPanel.add(Button_Tan, gridConstraint);
		mathFunctionPanel.add(Button_SepuluhPangkatN, gridConstraint);

		screenPanel.add(textField, gridConstraint);
		screenPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));

		containerBawah.add(mathFunctionPanel);
		containerBawah.add(numberPanel);
		
		frame.setSize(900, 600);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout(0, 5));
		frame.getContentPane().setBackground(Color.decode("#1C1E23"));
		frame.setLocationRelativeTo(null);
		frame.add(containerAtas, BorderLayout.NORTH);
		frame.add(containerBawah, BorderLayout.CENTER);
	}

	public void show() {
		frame.setVisible(true);
	}

	private ImageIcon resizeIcon(ImageIcon img, int width, int height) {
		Image temp = img.getImage();

		Image resizedTemp = temp.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon result = new ImageIcon(resizedTemp);

		return result;
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

