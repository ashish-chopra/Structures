/*
 * File: Quick.java
 * Date: 2 Feb, 2016
 * Author: Tarun Jain
 * -----------------------------------------------
 * Sorting is the process of rearranging a sequence of objects so as to put them 
 * in some logical order. The Quick sort algorithm is based on divide and conquer strategy. 
 * Quick sort first divides a large list into two smaller sub-lists: the low elements and 
 * the high elements. Quick sort can then recursively sort the sub-lists. 
 *  *  Features:
 *  
 *  1. Quick Sort is implemented as an array of Comparable Objects and sorts them
 *     based on their natural order defined by Comparable interface.
 *  2. In case if client wants to sort the objects in some other order than the natural
 *     order of objects, then client can call the overloaded method 
 *     Quick.sort(array, comparator) and pass the comparator object which gives the 
 *     customized ordering   
 *  3. It is a generic implementation which can take any type of array of objects.   
 *  4. The implementation is based on array based data structure.
 *  5. The running time complexity of each operation in average case is constant, O(N log N), 
 *     but in worst case it is O(N2).
 *  
 */

package com.sorting;

public class Quick {

	/*
	 * private constructor prevents the instantiation of the class.
	 */
	private Quick() {
	}

	/**
	 * rearranges the array in ascending order, using the natural order.
	 * 
	 * @param array
	 *            array to be sorted
	 * 
	 */
	public static void sort(Comparable[] array) {
		sort(array, 0, array.length - 1);
	}

	/*
	 * sort the subarray array[lo..hi] so that array[lo..hi] <= array[mid]
	 * <= array[j+1..hi] and return the index j-1.
	 */
	private static void sort(Comparable[] array, int lo, int hi) {
		if (hi <= lo)
			return;

		int i = lo;
		int j = hi;
		int mid = lo + (hi - lo) / 2;
		Comparable pivot = array[lo + (hi - lo) / 2];
		while (i <= j) {

			while (less(array[i], pivot)) {
				i++;
			}

			while (less(pivot, array[j])) {
				j--;
			}

			if (i <= j) {
				exchange(array, i, j);
				i++;
				j--;
			}

			if (j < i)
				break;

			show(array);

		}
		if (lo < j)
			sort(array, lo, j);
		if (i < hi)
			sort(array, i, hi);
	}

	/*
	 * check is v is less than w ?
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/*
	 * swap a[i] and a[j]
	 */
	private static void exchange(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * prints sequence of Objects to standard output.
	 * 
	 * @param array
	 *            the array to be printed
	 */
	public static void show(Comparable[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}

	

}
