/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class CalculatorFont {
	private Font fontType;
	private String fontName;
	private int fontStyle; // 0 = PLAIN, 1 = BOLD, 2 = ITALIC
	private int sizeFont;

	public CalculatorFont(String fontName, int fontStyle, int sizeFont) {
		this.fontName = fontName;
		this.fontStyle = fontStyle;
		this.sizeFont = sizeFont;
		fontType = new Font(fontName, fontStyle, sizeFont);
	}

	public Font getFont() {
		return fontType;
	}
}
