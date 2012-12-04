/*
 *  File: InfixExpression.java
 *  Author: Ashish Chopra
 *  Date: 1 Dec, 2012
 *  ----------------------------------------------------
 *  InfixExpression is an application of stack. An input is given
 *  as an infix expression with left paranthesis removed. We are asked
 *  to write a program which accepts this input and produce a well 
 *  paranthesized infix expression as output to the user.
 *  
 */
package com.applications;

import com.queues.Queue;
import com.stacks.Stack;

public class InfixExpression {

	public static void main(String[] args) {
		InfixExpression ie = new InfixExpression();
		ie.toInfix(null);
	}
	
	private String toInfix(Queue<String> expression) {
		Stack<String> operators = new Stack<String>();
		Stack<String> operands = new Stack<String>();
		
		if (expression == null)
			throw new NullPointerException("The expression is null");
		
		for (String s : expression) {
			if (isOperator(s))
				operators.push(s);
			else if (isOperand(s))
				operands.push(s);
			else if (isRightParanthesis(s)) {
				String result = evaluate(operands.pop(), operands.pop(), operators.pop());
				operands.push(result);
			} else 
				throw new RuntimeException("Input contains illegal characters.");
		}
		
		return operands.pop();
	}
	
	private boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
	
	private boolean isOperand(String s) {
		return s.matches("\\^[0-9]+$\\");
	}
	
	private boolean isRightParanthesis(String s) {
		return s.equals(")");
	}
	
	private String evaluate(String b, String a, String operator) {
		return "(" + a + operator + b + ")";
	}
}

