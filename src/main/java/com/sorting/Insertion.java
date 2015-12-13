/*
 * File: Insertion.java
 * Date: 13 Dec, 2015
 * Author: Tarun Jain
 * -----------------------------------------------
 * Sorting is the process of rearranging a sequence of objects so as to put them in
 * some logical order. The insertion sort algorithm sorts an array by comparing the 
 * value at any index from all the prior index values starting from first until the
 * lesser value is found. Then we place the value at the index before which there are
 * no lesser values found and rearrange rest of the values till the index of the value 
 * is compared. By doing this iteratively to the last index, we have a sorted array of 
 * integers. 
 * 
 * 
 * 
 *  *  Features:
 *  
 *  1. Insertion Sort is implemented as an array of Comparable Objects and sorts them
 *     based on their natural order defined by Comparable interface.
 *  2. In case if client wants to sort the objects in some other order than the natural
 *     order of objects, then client can call the overloaded method 
 *     Insertion.sort(array, comparator) and pass the comparator object which gives the 
 *     customized ordering   
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
		int len = array.length;
		for (int i = 0; i < len; i++) {
			for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
				exch(array, j - 1, j);
			}
		}
	}
	
	
	/**
	 * Rearranges the subarray a[lo....hi] in ascending order, 
	 * using the natural order.
	 * @param array the array to be sorted
	 * @param lo left endpoint
	 * @param hi right endpoint
	 */
	public static void sort(Comparable[] array, int lo, int hi) {
		if(array == null)
			throw new NullPointerException();
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && less(array[j], array[j - 1]); j--) {
				exch(array, j, j - 1);
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
	 * check is v is less than w ?
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	
	/*
	 * check is v is less than w ?
	 */
	private static boolean less(Object v, Object w, Comparator c) {
		return c.compare(v, w) < 0;
	}
	
	/*
	 * swap a[i] and a[j]
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
