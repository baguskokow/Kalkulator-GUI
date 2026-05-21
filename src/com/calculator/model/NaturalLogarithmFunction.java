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
	double result;
	char[] operand;

	public NaturalLogarithmFunction(String argument) {
		double temp = Double.parseDouble(argument);
		
		result = Math.log(temp);

	}

	public String getResult() {
		if(result == (int) result) {
			return String.valueOf(result).replaceAll("\\.0", "");
		}
		
		return String.valueOf(result);
	}
}
