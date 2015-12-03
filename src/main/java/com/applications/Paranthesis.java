/*
 * 
 *  File: Paranthesis.java
 *  Author: Ashish Chopra
 *  Date: 19 May, 2015
 *  ----------------------------------------------
 *  Calculates the maximum depth of paranthesis without using
 *  stacks. it is the Iterative solution which computes the depth
 *  in O(n) time complexity and O(1) auxillary space complexity.
 * 
 * 
 */
package com.applications;

/**
 * 
 * Paranthesis computes the maximum depth of paranthesis in
 * given aithemtic expression as String.
 * @author Ashish Chopra
 *
 */
public class Paranthesis {

	/**
	 * returns the maximum depth of an expression given as <code>String</code>.
	 * If the expression is not balanced then returns <code>-1</code>.
	 * 
	 * @param expression as <code>String</code>. 
	 * @return depth as <code>int</code>.
	 */
	private int maximumDepth(String expression) {
		if (expression == null) 
			return -1;
		char[] characters = expression.toCharArray();
		int current_max = 0, max = 0;
		
		int i = 0;
		while(i < characters.length) {
			if (characters[i] == '(') {
				current_max++;
				if (current_max > max) 
					max = current_max;
			} else if (characters[i] == ')') {
				current_max--;
			}
			i++;
		}
		
		if (current_max != 0)
			return -1;
		
		return max;
	}
	public static void main(String[] args) {
		
		String exp = "((((a)(b)c)d))";
		Paranthesis pr = new Paranthesis();
		System.out.println(pr.maximumDepth(exp));
		
		exp = "((a)b))))";
		System.out.println(pr.maximumDepth(exp));
		
		exp = " b) (c) d)";
		System.out.println(pr.maximumDepth(exp));
		
		exp = "( p((q)) ((s)t) )";
		System.out.println(pr.maximumDepth(exp));
		
		exp = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
		System.out.println(pr.maximumDepth(exp));
		
	}
}
