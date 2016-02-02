package com.list;

import com.stacks.Stack;

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
		
		assertEquals(8,list.size());		
		assertEquals(true,  list.remove(2));		
		
		
	}

}
