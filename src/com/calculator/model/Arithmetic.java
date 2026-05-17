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
	ArrayList<String> stringNumbers; 
	ArrayList<Character> operatorCharacter = new ArrayList<Character>();
	double result;

	public Arithmetic(String argument) {
		String[] temp = argument.split("[X\\-\\+\\/]");
		this.stringNumbers = new ArrayList<String>(Arrays.asList(temp));
		
		for(char c : argument.toCharArray()) {
			if((c == '+' || c == '-' || c == '/' || c == 'X')) {
				operatorCharacter.add(c);
			}
		}

		result = Double.parseDouble(stringNumbers.get(0));
		division();
		multiplication();
		addition();
		substraction();
	}

	public String getResult() {
		return String.valueOf(result).replaceAll("\\.0", "");
	}

	public void addition() {
		for(int i = 0; i < operatorCharacter.size(); i++) {
			char tempOperator = operatorCharacter.get(i);

			if(tempOperator == '+') {
				result += Double.parseDouble(stringNumbers.get(i + 1));
			}
		}
	}
	
	public void substraction() {
		for(int i = 0; i < operatorCharacter.size(); i++) {
			char tempOperator = operatorCharacter.get(i);

			if(tempOperator == '-') {
				result -= Double.parseDouble(stringNumbers.get(i + 1));
			}
		}
	}

	public void division() {
		int indexOperator;
		for(int i = 0; i < operatorCharacter.size(); i++) {
			char tempOperator = operatorCharacter.get(i);

			if(tempOperator == '/') {
				double leftNumber = Double.parseDouble(stringNumbers.get(i));
				double rightNumber = Double.parseDouble(stringNumbers.get(i+1));
				result = leftNumber / rightNumber;

				stringNumbers.remove(i + 1);
				operatorCharacter.remove(i);
				i--;
			}
		}
	}

	public void multiplication() {
		int indexOperator;
		for(int i = 0; i < operatorCharacter.size(); i++) {
			char tempOperator = operatorCharacter.get(i);

			if(tempOperator == 'X') {
				double leftNumber = Double.parseDouble(stringNumbers.get(i));
				double rightNumber = Double.parseDouble(stringNumbers.get(i+1));
				double resultKali = leftNumber * rightNumber;
				stringNumbers.set(i, String.valueOf(resultKali));
				stringNumbers.remove(i + 1);
				operatorCharacter.remove(i);
				this.result = resultKali;
				i--;
			}
		}
	}
}
