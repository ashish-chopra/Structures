/*
 * File: Heap.java
 * Date: 26 Fev, 2017
 * Author: Stephane Miguel KAKANAKOU
 * ---------------------------------------
 * Sorting is the process of rearranging a sequence of objects so as to put them 
 * in some logical order. Heapsort can be thought of as an improved selection sort: like 
 * that algorithm, it divides its input into a sorted and an unsorted region, and it 
 * iteratively shrinks the unsorted region by extracting the largest element and moving 
 * that to the sorted region. The improvement consists of the use of a heap data structure 
 * rather than a linear-time search to find the maximum. Heapsort is an in-place algorithm, 
 * but it is not a stable sort
 * 
 * 
 *  *  Features:
 * 
 *  1. Heap Sort is implemented as an array of Comparable Objects and sorts them
 *     based on their natural order defined by Comparable interface.
 *  2. In case if client wants to sort the objects in some other order than the natural
 *     order of objects, then client can call the overloaded method 
 *     Heap.sort(array, comparator) and pass the comparator object which gives the 
 *     customized ordering   
 *  3. It is a generic implementation which can take any type of array of objects.   
 *  4. The implementation is based on array based data structure.
 *  5. The running time complexity of each operation is constant, O(n*log(n)).
 */
package com.sorting;

import java.util.Comparator;

public class Heap {

    /*
     * private constructor prevents the instantiation of the class.
     */
    private Heap() {
    }

    /**
     * rearranges the array in ascending order, using the natural order.
     * 
     * @param array
     *            the array to be sorted
     */
    public static void sort(Comparable[] array) {
        if (array == null)
            throw new NullPointerException();
        heapify(array);
        for (int k = array.length; k >= 1; k--) {
            exch(array, 1, k);
            sink(array, 1, k - 1);
        }
    }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * 
     * @param array
     *            the array to be sorted
     * @param c
     *            the comparator specifying the order
     */
    public static void sort(Comparable[] array, Comparator c) {
        if (array == null)
            throw new NullPointerException();
        heapify(array, c);
        for (int k = array.length; k >= 1; k--) {
            exch(array, 1, k);
            sink(array, 1, k - 1, c);
        }
    }

    /*
     * transform array in heap
     */
    private static void heapify(Comparable[] A) {
        for (int k = A.length / 2; k >= 1; k--)
            sink(A, k, A.length);
    }

    /*
     * transform array in heap using a comparator.
     */
    private static void heapify(Comparable[] A, Comparator c) {
        for (int k = A.length / 2; k >= 1; k--)
            sink(A, k, A.length, c);
    }

    /*
     * eliminate the violation in the heap in case when a parent key becomes
     * smaller than one or both of is children's.
     */
    private static void sink(Comparable[] A, int indice, int len) {
        int j;
        while (indice <= len / 2) {
            j = 2 * indice;
            if ((j < len) && (less(A, j, j + 1, null)))
                j++;
            if (!less(A, indice, j, null))
                break;
            exch(A, indice, j);
            indice = j;
        }
    }

    /*
     * eliminate the violation in the heap in case when a parent key becomes
     * smaller than one or both of is children's using a comparator.
     */
    private static void sink(Comparable[] A, int indice, int len, Comparator c) {
        int j;
        while (indice <= len / 2) {
            j = 2 * indice;
            if ((j < len) && (less(A, j, j + 1, c)))
                j++;
            if (!less(A, indice, j, c))
                break;
            exch(A, indice, j);
            indice = j;
        }
    }

    /*
     * swap A[i] and A[j]
     */
    private static void exch(Object[] A, int i, int j) {
        i = getArrayIndex(i);
        j = getArrayIndex(j);
        Object k = A[i];
        A[i] = A[j];
        A[j] = k;
    }

    /*
     * check is A[i] is less than A[j] ?
     */
    private static boolean less(Comparable[] A, int i, int j, Comparator c) {
        i = getArrayIndex(i);
        j = getArrayIndex(j);
        int compareValue;
        if (c == null)
            compareValue = A[i].compareTo(A[j]);
        else
            compareValue = c.compare(A[i], A[j]);
        if (compareValue < 0)
            return true;
        return false;
    }

    /*
     * the array index begin by 0 and the heap index begin by 1. So this
     * function convert a given heap index into the array index
     */
    private static int getArrayIndex(int indice) {
        return --indice;
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
