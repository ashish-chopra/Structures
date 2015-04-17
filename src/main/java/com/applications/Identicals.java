/*
 *  File: Identicals.java
 *  Author: Ashish Chopra
 *  Date: 9 Apr, 2015
 *  --------------------------------------
 *  Identicals is an implementation of an algorithm to print 
 *  identical integers in the given two sorted arrays of integers of size N.
 *  
 *  You are given two sorted arrays of integers, you need to print the 
 *  integer present in both the arrays, in sorted order.
 *  
 *  The expectation is to perform this task at T(N) ~ N for worst case.
 *  
 */
package com.applications;


public class Identicals {

	private int[] first;   // first array to hold N integers
	private int[] second;  // second array to hold N integers
	
	Identicals(int[] arr1, int[] arr2) {
		this.first = arr1;
		this.second = arr2;
	}
	
	/**
	 * returns the identical numbers found in
	 * both the sorted array of N integers in running
	 * time of T(N) ~ N for worst case.
	 * 
	 */
	public String printIdenticals() { 
		// instead of printing, we return the list 
		// to compare with expected values
		String list = "[";	
		int i = 0, j = 0;
		while (i < first.length && j < second.length) {
			int result = compare(first[i], second[j]);
			if (result == 0) {
				list += first[i] + ",";
				i++; j++;
			} else if (result == -1) 
				j++;
			else 
				i++;
		}
		list +=  "]";
		System.out.println(list);
		return list;
	}
	
	/**
	 * compares the two integers a and b
	 * @param a Integer at first position
	 * @param b Integer at second position
	 * @return <code>0</code> when a and b are equal,
	 *         <code>1</code> when b is greater than a,
	 *         <code>-1</code> when a is greater than b
	 */
	private int compare(int a, int b) {
		if (a == b) return 0;
		return a < b ? 1 : -1;
	}
}
