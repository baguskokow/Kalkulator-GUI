/*
 * Dibuat oleh Kelompok 9
 * 
 */


package com.belajar;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.*;

public class Launcher {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Belajar belajar = new Belajar();
			belajar.show();
		});
	}
}
