/*
 * File: Selection.java
 * Date: 10 Dec, 2015
 * Author: Tarun Jain
 * -----------------------------------------------
 * Sorting is the process of rearranging a sequence of objects so as to put them 
 * in some logical order. The selection sort algorithm sorts an array by repeatedly 
 * finding the minimum element (considering ascending order) from unsorted part and 
 * putting it at the beginning. It exchange one for every pass through the list. 
 * 
 *  *  Features:
 *  
 *  1. Selection Sort is implemented as an array of Comparable Objects and sorts them
 *     based on their natural order defined by Comparable interface.
 *  2. In case if client wants to sort the objects in some other order than the natural
 *     order of objects, then client can call the overloaded method 
 *     Selection.sort(array, comparator) and pass the comparator object which gives the 
 *     customized ordering   
 *  3. It is a generic implementation which can take any type of array of objects.   
 *  4. The implementation is based on array based data structure.
 *  5. The running time complexity of each operation is constant, O(N2).
 *  
 */
package com.sorting;

import java.util.Comparator;

public class Selection {
	
	
	/*
	 *  private constructor prevents the
	 *  instantiation of the class.
	 */
	private Selection() {
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
		int size = array.length;
		int min;
		for (int i = 0; i < size; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (less(array[j], array[min]))
					min = j;
			}
			exchange(array, i, min);
		
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
		
		int size = array.length;
		int min;
		for (int i = 0; i < size; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (less(com, array[j], array[min]))
					min = j;
			}
			exchange(array, i, min);

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
	private static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}

	/*
	 * swap a[i] and a[j]
	 */
	private static void exchange(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
     * prints sequence of Objects to standard output. 
     * @param array the array to be printed
     */

	public static void show(Comparable[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + ",");
		}
	}

	

}
