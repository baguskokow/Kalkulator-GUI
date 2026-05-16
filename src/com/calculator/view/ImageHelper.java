/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;

class ImageHelper {
	private ImageIcon icon;

	public ImageHelper(String path, int width, int height) {
		ImageIcon rawIcon = new ImageIcon(path);
		Image temp = rawIcon.getImage();
		Image resizedTemp = temp.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		this.icon = new ImageIcon(resizedTemp);
	}

	public ImageIcon getImageIcon() {
		return icon;
	}
}
