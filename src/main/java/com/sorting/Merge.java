/*
 * File: Merge.java
 * Date: 22 Dec, 2015
 * Author: Tarun Jain
 * -----------------------------------------------
 * Sorting is the process of rearranging a sequence of objects so as to put them 
 * in some logical order. Merge sort uses divide and conquer algorithm. 
 * Divide and conquer algorithms divide the original data into smaller sets of data 
 * to solve the problem. Merge sort divide the unsorted array into n partitions, each 
 * partition contains one element considered as sorted and recursively sort and merge 
 * partitioned units to produce new sublists repeatedly until there is only one sublist 
 * remaining. 
 *
 * 
 *  *  Features:
 *  
 *  1. Merge Sort is implemented as an array of Comparable Objects and sorts them
 *     based on their natural order defined by Comparable interface.
 *  2. In case if client wants to sort the objects in some other order than the natural
 *     order of objects, then client can call the overloaded method 
 *     Merge.sort(array, comparator) and pass the comparator object which gives the 
 *     customized ordering   
 *  3. It is a generic implementation which can take any type of array of objects.   
 *  4. The implementation is based on array based data structure.
 *  5. The running time complexity of each operation is constant, O(n*log(n)).
 *  6. It requires additional scratch space proportional to the size of the input array.
 *  
 */
package com.sorting;

import java.util.Comparator;

public class Merge {

	/*
	 * private constructor prevents the instantiation of the class.
	 */
	private Merge() {
	}

	/**
	 * rearranges the array in ascending order, using the natural order.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public static void sort(Comparable[] array) {
		if(array == null)
			throw new NullPointerException();
		Comparable[] aux = new Comparable[array.length];
		sort(array, aux, 0, array.length - 1);
	}

	/**
	 * Rearranges the array in ascending order, using a comparator.
	 * 
	 * @param array
	 *            the array to be sorted
	 * @param com
	 *            the comparator specifying the order
	 */
	public static void sort(Object[] array, Comparator com) {
		if(array == null)
			throw new NullPointerException();
		Comparable[] aux = new Comparable[array.length];
		sort(array, aux, com, 0, array.length - 1);
	}

	/*
	 * divide and merge array a[lo..hi] using auxiliary array aux[lo..hi]
	 */
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	/*
	 * divide and merge array a[lo..hi] using auxiliary array aux[lo..hi]
	 */
	private static void sort(Object[] a, Object[] aux, Comparator com, int lo,
			int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, com, lo, mid);
		sort(a, aux, com, mid + 1, hi);
		merge(a, aux, com, lo, mid, hi);
	}

	/*
	 * merge array a[lo...mid] with array a[mid+1..hi] using auxiliary
	 * array[lo..hi]
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int lo,
			int mid, int hi) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	/*
	 * merge array a[lo...mid] with array a[mid+1..hi] using auxiliary
	 * array[lo..hi] and compare using Comparator
	 */
	private static void merge(Object[] a, Object[] aux, Comparator com, int lo,
			int mid, int hi) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(com, aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
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
	private static void exch(Object[] a, int i, int j) {
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
		int n = array.length;
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + ",");
		}
	}

}
