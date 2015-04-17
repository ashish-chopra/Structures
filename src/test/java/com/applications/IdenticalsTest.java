package com.applications;

import junit.framework.TestCase;


public class IdenticalsTest extends TestCase {

	public void testIdenticals() {
		int[] a = new int[] {1,2,3,4,5};
		int[] b = new int[] {3,7,8,10,18};
		Identicals identicals = new Identicals(a, b);
		assertEquals("[3,]", identicals.printIdenticals());
		
		a = new int[] {1,2,3,4,5, 8, 10,22,56};
		b = new int[] {3,7,8,10,18, 20, 22, 56};
		identicals = new Identicals(a, b);
		assertEquals("[3,8,10,22,56,]", identicals.printIdenticals());
		
		a = new int[] {1,2,3,4,5, 8, 10,11,56};
		b = new int[] {3,7,8,10,18, 20, 22, 56};
		identicals = new Identicals(a, b);
		assertEquals("[3,8,10,56,]", identicals.printIdenticals());
		
		a = new int[] {1,2,3,4,5, 8, 10,11,56};
		b = new int[] {4,5,8,10,17, 20,22,76};
		identicals = new Identicals(a, b);
		assertEquals("[4,5,8,10,]", identicals.printIdenticals());
		
		a = new int[] {1,2,3,4,5, 8, 10,11,90};
		b = new int[] {6,7,8,10,18, 20, 22, 56};
		identicals = new Identicals(a, b);
		assertEquals("[8,10,]", identicals.printIdenticals());
		
		a = new int[] {1,2,3,4,5, 8, 10,11,56};
		b = new int[] {57,89,90,92,99,100, 101, 102};
		identicals = new Identicals(a, b);
		assertEquals("[]", identicals.printIdenticals());
		
	}
	
	
}