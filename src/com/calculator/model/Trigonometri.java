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
		String parsed = argument.replace("e", String.valueOf(Math.E)).replace("PI", String.valueOf(Math.PI));
		double temp = Double.parseDouble(parsed);

		if(type.equals("sin")) {
			result = Math.sin(temp);
		} else if(type.equals("cos")) {
			result = Math.cos(temp);
		} else if(type.equals("tan")) {
			result = Math.tan(temp);
		}
	}

	public String getResult() {
		double rounded = Math.round(result * 1e10) / 1e10;
    
		if(rounded == (int) rounded) {
        String val = String.valueOf((int) rounded);
        return val;
    }

    return String.valueOf(rounded);
	}
	
}
