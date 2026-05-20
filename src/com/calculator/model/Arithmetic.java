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

class Arithmetic {
	ArrayList<Double> operand = new ArrayList<Double>(); 
	ArrayList<Character> operatorCharacter = new ArrayList<Character>();
	double result;

	public Arithmetic(String argument) {
		String tempNumbers = "";
		for(int i = 0; i < argument.length(); i++) {
			char temp = argument.charAt(i);
			
			if(Character.isDigit(temp) || temp == '.') {
				tempNumbers += temp;
			} else if(temp == '+' || temp == '-' || temp == '÷' || temp == '×') {
				operatorCharacter.add(temp);
			}
		}

		if(tempNumbers.isEmpty() != true) {
			operand.add(Double.parseDouble(tempNumbers));
		}

		calculated();
		result = operand.get(0);
		counting();
	}

	public String getResult() {
		if(result == (int) result) {
			return String.valueOf(result).replaceAll("\\.0", "");	
		}
		return String.valueOf(result);
	}

	public void counting() {
		for(int i = 0; i < operatorCharacter.size(); i++) {
			if(operatorCharacter.get(i) == '+') {
				result += operand.get(i + 1);
			} else if(operatorCharacter.get(i) == '-'){
				result -= operand.get(i + 1);
			}
		}
	}
	
	public void calculated() {
		for(int i = 0; i < operatorCharacter.size(); i++) {
			char tempOperator = operatorCharacter.get(i);
			double tempResult = 0;

			if(tempOperator == '÷' || tempOperator == '×') {
				double leftNumber = operand.get(i);
				double rightNumber = operand.get(i+1);

				if(tempOperator == '÷') {
					tempResult = leftNumber / rightNumber;
				} else if(tempOperator == '×') {
					tempResult = leftNumber * rightNumber;
				}

				operand.set(i, tempResult);
				operand.remove(i + 1);
				operatorCharacter.remove(i);
				i--;
			} 

		}
	}
}
