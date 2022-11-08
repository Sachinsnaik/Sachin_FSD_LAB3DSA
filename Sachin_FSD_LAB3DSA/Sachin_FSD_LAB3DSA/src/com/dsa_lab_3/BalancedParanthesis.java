package com.dsa_lab_3;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {

	private static Scanner sc;

	public static void main(String[] args) {

		System.out.println("Enter The String of Brackets That Needs To Be Checked:");
		sc = new Scanner(System.in);
		

		String input = sc.nextLine();
		String brackets = input.replaceAll(" ", "");
		
		boolean result = areBracketsBalanced(brackets);

		if (result) {
			System.out.println("The Entered String Has Balanced Brackets -> (BALANCED STRING)");
		} else {
			System.out.println("The Entered String Do Not Contain Balanced Brackets -> (UNBALANCED STRING)");
		}
	}

	private static boolean areBracketsBalanced(String input) {
		
		Stack<Character> stack = new Stack<Character>();
		
		char[] inputArray = input.toCharArray();

		for (int i = 0; i < inputArray.length; i++) {
			
			if (inputArray[i] == '(' || inputArray[i] == '[' || inputArray[i] == '{') {
				stack.push(inputArray[i]);
				
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char check;

			switch (inputArray[i]) {

			case ')':
				check = stack.pop();
				if (check == '[' || check == '{') {
					return false;
				}
				break;
			case ']':
				check = stack.pop();
				if (check == '(' || check == '{') {
					return false;
				}
				break;
			case '}':
				check = stack.pop();
				if (check == '[' || check == '(') {
					return false;
				}
				break;
			}
		}

		if (stack.isEmpty()) {
			
			return true;
		} else {
			return false;
		}
	}
}