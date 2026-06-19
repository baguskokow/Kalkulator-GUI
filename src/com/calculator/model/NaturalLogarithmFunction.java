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

class NaturalLogarithmFunction {
	static double result;
	static char[] operand;

	public static String getResult(String operand) {
		String parsed = operand.replace("e", String.valueOf(Math.E)).replace("PI", String.valueOf(Math.PI));
		
		double temp = Double.parseDouble(parsed);
		result = Math.log(temp);

		if(result == (int) result) {
			return String.valueOf(result).replaceAll("\\.0", "");
		}
		
		return String.valueOf(result);
	}
}
