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

class LogarithmFunction {
	double result;
	char[] operand;

	public LogarithmFunction(String argument) {
		double temp = Double.parseDouble(argument);
		
		if(argument.contains("ln")) {
			result = Math.log(temp);
		} else if(argument.contains("log")) {
			result = Math.log10(temp);
		}

	}

	public String getResult() {
		if(result == (int) result) {
			return String.valueOf(result).replaceAll("\\.0", "");
		}
		
		return String.valueOf(result);
	}
}
