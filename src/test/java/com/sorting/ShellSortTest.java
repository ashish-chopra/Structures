package com.sorting;

import junit.framework.TestCase;



public class ShellSortTest extends TestCase {

	public void testSortWithString() {

		String[] actual = { "F", "M", "B", "Z", "Q", "D", "L", "X", "K", "P", "R", "C" };
		String[] expected = { "B", "C","D", "F", "K", "L", "M", "P", "Q", "R", "X", "Z" };
		Shell.sort(actual);
        Shell.show(actual);
		assertEquals(expected[2], actual[2]);

	}

	public void testSortWithIntegers() {

		Integer[] actual = { 9, 4, 3, 6, 5, 2 };
		Integer[] expected = { 2, 3, 4, 5, 6, 9 };
		Shell.sort(actual);
        Shell.show(actual);
		assertEquals(expected[4], actual[4]);

	}

	

	public void testException() {

		Integer[] l1 = null;
		try {
			Shell.sort(l1);
		} catch (Exception e) {
			assertNotNull(e);
		}

	}
}
