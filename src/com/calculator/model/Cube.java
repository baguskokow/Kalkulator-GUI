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

public class Cube {
	static double result;
	static char[] operand;

	public static String getResult(String operand) {
		double temp = Double.parseDouble(operand);
		result = Math.pow(temp, 3);

		if(result == (int) result) {
			return String.valueOf(result).replaceAll("\\.0", "");
		} 
	
		return String.valueOf(result);
	}

}

