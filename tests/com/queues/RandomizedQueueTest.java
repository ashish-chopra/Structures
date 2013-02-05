package com.queues;

import com.Test;

public class RandomizedQueueTest implements Test {

	public void run() {
		
		//test empty queue
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		assert (rq.size() == 0);
		assert (rq.isEmpty());
		
		// test enqueue operation
		rq.enqueue(10);
		rq.enqueue(5);
		rq.enqueue(100);
		rq.enqueue(2);
		assert (!rq.isEmpty());
		assert (rq.size() == 4);
		
		//test dequeue
		rq.dequeue();
		rq.dequeue();
		assert (rq.size() == 2);
		
		// test sample
		rq.sample();
		rq.sample();
		assert (rq.size() == 2);
		
		//test dequeue
		rq.dequeue();
		rq.dequeue();
		assert (rq.size() == 0);
	}

}
