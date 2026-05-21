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
	double result;
	char[] operand;


	public Cube(String argument) {
		double temp = Double.parseDouble(argument);
		
		result = Math.pow(temp, 3);
	}

	public String getResult() {
		if(result == (int) result) {
			return String.valueOf(result).replaceAll("\\.0", "");
		} 
	
		return String.valueOf(result);
	}

}

