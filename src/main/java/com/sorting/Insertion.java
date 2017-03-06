/*
 * File: Insertion.java
 * Date: 13 Dec, 2015
 * Author: Tarun Jain
 * Modified: 5 March, 2017
 * -----------------------------------------------
 * Sorting is the process of re-arranging a sequence of objects so as to put them in
 * some logical order. Insertion sort works as follows:
 * The sorting starts from left side of the array and ends up at the right hand side with a sorted array in the left.
 * During a pass the item at current index is placed in the sorted array by finding its
 * correct position and moving other elements towards right.
 * 
 * 
 * Features:
 *  
 * 	1. Unlike selection sort, insertion sort is sensitive to input. If array is large and 
 *     items are already sorted, then insertion sort runs faster than if the enteries are 
 *     randomly ordered.
 *  1. Insertion Sort is implemented as an array of Comparable Objects and sorts them
 *     based on their natural order defined by Comparable interface.
 *  2. In case if client wants to sort the objects in some other order than the natural
 *     order of objects, then client can call the overloaded method 
 *     Insertion.sort(array, comparator) and pass the comparator object which gives the 
 *     customized ordering strategy.
 *  3. It is a generic implementation which can take any type of array of objects.   
 *  4. The implementation is based on array based data structure.
 *  5. The running time complexity of each operation is constant, O(1/2 N^2).
 *  
 */
package com.sorting;

import java.util.Comparator;

public class Insertion {

	/*
	 *  private constructor prevents the
	 *  instantiation of the class.
	 */
	private Insertion() {
	}

	/**
	 * rearranges the array in ascending order, 
	 * using the natural order.
	 * @param array the array to be sorted
	 * 
	 */
	public static void sort(Comparable[] array) {
		if(array == null)
			throw new NullPointerException();
		int N = array.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
				exch(array, j - 1, j);
			}
		}
	}
	
	/**
	 * Rearranges the array in ascending order, using a comparator.
	 * @param array the array to be sorted
	 * @param com the comparator specifying the order
	 */
	public static void sort(Object[] array, Comparator com) {
		if(array == null)
			throw new NullPointerException();
		int n = array.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0 && less(array[j], array[j - 1], com); j--) {
				exch(array, j, j - 1);

			}
		}
	}


	/*
	 * checks to see if v is less than w.
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	
	/*
	 * checks to see if v is less than w.
	 */
	private static boolean less(Object v, Object w, Comparator c) {
		return c.compare(v, w) < 0;
	}
	
	/*
	 * swaps a[i] and a[j]
	 */
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
     * prints sequence of Objects to standard output. 
     * @param array the array to be printed
     */
	public static void show(Object[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++)
			System.out.print(array[i] + ",");
	}
}
