/**
 * File: Shell.java
 * Author: Ashish Chopra
 * Date: 6 March, 2017
 * -------------------------------------------------------------------------
 * Sorting is the process of re-arranging a sequence of objects so as to put them in
 * some logical order. Shell sort is an improvement over insertion sort that sorts the 
 * given input array in multiple sort sequences.
 * 
 * Insertion sort is slow for large arrays because it only exchanges the adjacent entries which is time
 * consuming if smallest item is placed at extreme right. Shell sort is a simple extension of insertion sort
 * that exchange the enteries that are situated far apart to partially sort the array which is eventually sorted
 * by insertion sort.
 * 
 * 
 */
package com.sorting;

public class Shell {

    /*
    private constructor
    */
    private Shell() {
    }

    /**
     * rearranges the array in ascending order, 
     * using the natural order.
     * @param array the array to be sorted
     * 
     */
    public static void sort(Comparable[] array) {
        if (array == null)
            throw new NullPointerException();

        int N = array.length;
        int h = 1;

        // calculate the increment sequence to be used.
        // 1, 4, 13, 40, 121, 364, 1093 and so on.
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exch(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /*
     * checks if v is smaller than w.
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /*
     * swaps the ith and jth entries in the given array.
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
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