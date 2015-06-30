package com.tables;

import junit.framework.TestCase;

public class UnorderedSTTest extends TestCase {

	public void testOperations() {
		
		UnorderedST<Integer, String> table = new UnorderedST<Integer, String>();
		
		assertEquals(true, table.isEmpty());
		assertEquals(0, table.size());
		assertEquals(false, table.contains(5));
		
		table.put(1, "test data 1");
		table.put(2, "test data 2");
		table.put(3, "test data 3");
		table.put(4, "test data 4");
		table.put(5, "test data 5");
		
		assertEquals(5, table.size());
		assertEquals(true, table.contains(4));
		assertEquals(false, table.contains(8));
		
		assertEquals("test data 3", table.get(3));
		assertEquals(null, table.get(7));
		
		table.put(6, "test data 6");
		table.put(7, "test data 7");
		
		table.put(3, null);
		assertEquals(null, table.get(3));
	}
}
