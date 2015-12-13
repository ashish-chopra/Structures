package com.sorting;

import junit.framework.TestCase;



public class InsertionSortTest extends TestCase {

	public void testSortWithString() {

		String[] actual = { "F", "M", "B", "Z", "Q", "A" };
		String[] expected = { "A", "B", "F", "M", "Q", "Z" };
		Insertion.sort(actual);
		assertEquals(expected[2], actual[2]);

	}

	public void testSortWithIntegers() {

		Integer[] actual = { 9, 4, 3, 6, 5, 2 };
		Integer[] expected = { 2, 3, 4, 5, 6, 9 };
		Insertion.sort(actual);
		assertEquals(expected[4], actual[4]);

	}

	

	public void testException() {

		Integer[] l1 = null;
		try {
			Insertion.sort(l1);
		} catch (Exception e) {
			assertNotNull(e);
		}

	}

	

}
