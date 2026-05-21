/*
 * Dibuat oleh Kelompok 9
 * 
 */

package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.lang.Math;

public class Trigonometri {
	double result;
	char[] operand;

	public Trigonometri(String argument, String type) {
		double temp = Double.parseDouble(argument);
		double radians = Math.toRadians(temp);

		if(type.equals("sin")) {
			result = Math.sin(radians);
		} else if(type.equals("cos")) {
			result = Math.cos(radians);
		} else if(type.equals("tan")) {
			result = Math.cos(radians);
		}
	}

	public String getResult() {
		if(result == (int) result) {
			return String.valueOf(result).replaceAll("\\.0", "");
		}

		return String.valueOf(result);
	}
	
}
