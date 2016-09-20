package com.lists;

import java.util.NoSuchElementException;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

	public void testList() {

		LinkedList<String> list = new LinkedList<String>();
		list.add("quick");
		list.add("brown");
		list.add("fox");
		list.add("jumped");
		list.add("over");
		list.add("little");
		list.add("lazy");
		list.add("dog");

		assertEquals(8, list.size());
		assertEquals(true, list.remove(2));

	}
	
	public void testListByAddAtIndex() {

		LinkedList<String> list = new LinkedList<String>();
		list.add("quick");
		list.add("brown");
		list.add("fox");
		list.add("lazy");
		list.add("little",2);
		assertEquals("little", list.get(2));
		assertEquals("brown", list.get(3));

	}

	public void testIteratorHasNext() {

		LinkedList<String> list1 = new LinkedList<String>();

		assertEquals(false, list1.iterator().hasNext());

	}

	public void testIeratorThrowsNoSuchElementException() {
		LinkedList<String> list1 = new LinkedList<String>();
		boolean thrown = false;
		try {
			list1.iterator().next();
		} catch (NoSuchElementException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	public void testIeratorUnsupportedOperationException() {
		LinkedList<String> list1 = new LinkedList<String>();
		boolean thrown = false;
		try {
			list1.iterator().remove();
		} catch (UnsupportedOperationException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

}
