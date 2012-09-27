package com.queues;

import com.Test;

public class DequeTest implements Test {

	public void run() {

		// test empty deque
		Deque<String> que = new Deque<String>();
		assert (que.size() == 0);
		assert (que.isEmpty());
	}

}
