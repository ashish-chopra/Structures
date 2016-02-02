package com.sorting;

import junit.framework.TestCase;

public class QuickSortTest extends TestCase {
	

	public void testSortWithString() {

		String[] actual = { "F", "M", "B", "Z", "Q", "A" };
		String[] expected = { "A", "B", "F", "M", "Q", "Z" };
		Quick.sort(actual);
		assertEquals(expected[2], actual[2]);

	}
	
	public void testSortWithIntegers() {

		Integer[] actual = { 9, 4, 3, 6, 5, 2 };
		Integer[] expected = { 2, 3, 4, 5, 6, 9 };
		Quick.sort(actual);
		assertEquals(expected[4], actual[4]);

	}

}
