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

		result = Math.log(temp);
	}

	public String getResult() {
		DecimalFormat df = new DecimalFormat("#.#####");
		return df.format(result);


		// Fix decimal format!
	}
}
