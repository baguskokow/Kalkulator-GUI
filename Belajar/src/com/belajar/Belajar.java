package com.belajar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class Belajar implements ActionListener{
	private JFrame frame;
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private JPanel panel;
	private String rawText = "10^{x^{2}}";

	public Belajar() {
		initialized();
	}

	private void initialized() {
		frame = new JFrame();
		frame.setTitle("Belajar");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 500);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);

		panel = new JPanel();
		label = new JLabel();
		label.setPreferredSize(new Dimension(200, 100));
		textField = new JTextField(20);
		button = new JButton("Save");

		button.addActionListener(this);
		updateScreen(rawText);

		panel.add(label);
		panel.add(textField);
		panel.add(button);

		frame.add(panel);
	}


	public void show() {
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		System.out.println("Halo");
	}

	public String formatToLatex(String plainText) {
		String formatted = plainText;

		return formatted;
	}

	public void updateScreen(String textToRender) {
		TeXFormula formula = new TeXFormula(textToRender);
		TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 18);

		label.setText(null);
		label.setIcon(icon);

		panel.revalidate();
		panel.repaint();
	}

}
