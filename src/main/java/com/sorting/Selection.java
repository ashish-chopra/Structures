/*
 * File: Selection.java
 * Date: 10 Dec, 2015
 * Author: Tarun Jain
 * Modified: 3 March, 2017
 * -----------------------------------------------
 * Sorting is the process of re-arranging a sequence of objects so as to put them 
 * in some logical order. The selection sort algorithm works as follows:
 * First find the smallest item (assuming sort in ascending order) in the array 
 * and exchange it with the first entry, and then find the next smallest item from 
 * unsorted array and exchange it with the second position. 
 * Continue this way, until the entire array is sorted.
 * 
 *  Features:
 *  
 * 1. Selection sort is insensitive to input. It will take same amount of time for 
 *    sorting a randomly ordered array or an already sorted array.
 * 2. Each pass in the selection sort does not provide any help to find next smallest
 *    item in the list.
 * 3. The sorting algorithms are generally analyzed by number of compares and exchanges it performs.
 * 4. It makes only N exchanges for an array of size N. That is the data movement is minimal.
 *    And this one of the strong point of selection sort that the number of exchanges is the linear
 *    function of array size.
 * 5. It uses ~(N^2)/2 compares and N exchanges to sort an array of length N. 
 * 6. Selection Sort is implemented as an array of Comparable Objects and sorts them
 *     based on their natural order defined by Comparable interface.
 * 7. In case if client wants to sort the objects in some other order than the natural
 *     order of objects, then client can call the overloaded method 
 *     Selection.sort(array, comparator) and pass the comparator object which gives the 
 *     customized ordering.
 * 8. Running time complexity of selection sort is T(N) ~N^2/2, i.e. O(N^2).
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
	 * @param array input array to be sorted
	 * @param c the comparator specifying the ordering sequence
	 */

	public static void sort(Object[] array, Comparator c) {
		
		if(array == null)
			throw new NullPointerException();
		
		int size = array.length;
		int min;
		for (int i = 0; i < size; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (less(c, array[j], array[min]))
					min = j;
			}
			exchange(array, i, min);
		}
	}


	/*
	 * checks if v is smaller than w.
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/*
	 * checks if v is smaller than w using comparator
	 */
	private static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}

	/*
	 * swaps the ith and jth entries in the given array.
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
