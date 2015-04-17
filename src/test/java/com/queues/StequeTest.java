package com.queues;

import junit.framework.TestCase;

public class StequeTest extends TestCase {

	public void testSteque() {
		Steque<Integer> st = new Steque<Integer>();
		
		assertEquals(0, st.size());
		assertEquals(true, st.isEmpty());
		
		st.push(10);
		st.push(15);
		st.push(40);
		assertEquals(3, st.size());
		assertEquals(false, st.isEmpty());
		
		st.pop();
		st.push(33);
		st.push(2);
		int c = st.pop();
		assertEquals(2, c);
		assertEquals(3, st.size());

		st.enqueue(11);
		st.enqueue(12);
		st.enqueue(13);
		st.enqueue(16);
		assertEquals(7, st.size());
		
		st.pop();
		c = st.pop();
		assertEquals(15, c);
		assertEquals(5, st.size());
	}

}
