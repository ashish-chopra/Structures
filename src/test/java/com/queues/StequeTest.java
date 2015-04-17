package com.queues;

import com.Test;

public class StequeTest implements Test {

	public void run() {
		Steque<Integer> st = new Steque<Integer>();
		
		assert (st.size() == 0);
		assert (st.isEmpty());
		
		st.push(10);
		st.push(15);
		st.push(40);
		assert (st.size() == 3);
		assert (!st.isEmpty());
		
		st.pop();
		st.push(33);
		st.push(2);
		int c = st.pop();
		assert (c == 2);
		assert (st.size() == 3);

		st.enqueue(11);
		st.enqueue(12);
		st.enqueue(13);
		st.enqueue(16);
		assert (st.size() == 7);
		
		st.pop();
		c = st.pop();
		assert (c == 15);
		assert (st.size() == 5);
	}

}
