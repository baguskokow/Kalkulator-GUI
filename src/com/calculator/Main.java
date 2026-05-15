/*
 * Dibuat oleh Kelompok 9
 * 
 */


package com.calculator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			App calculator = new App("Calculator");
			//ActionListener action = new AnActionListener();
			//calculator.setButtonAction("Haloooooo");
			calculator.show();
		});
	}
}
