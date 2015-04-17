package com.queues;

import junit.framework.TestCase;

public class RandomizedQueueTest extends TestCase {

	public void testRandomQueue() {
		
		//test empty queue
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		assertEquals(0, rq.size());
		assertEquals(true, rq.isEmpty());
		
		// test enqueue operation
		rq.enqueue(10);
		rq.enqueue(5);
		rq.enqueue(100);
		rq.enqueue(2);
		assertEquals(false, rq.isEmpty());
		assertEquals(4, rq.size());
		
		//test dequeue
		rq.dequeue();
		rq.dequeue();
		assertEquals(2, rq.size());
		
		// test sample
		rq.sample();
		rq.sample();
		assertEquals(2, rq.size());
		
		//test dequeue
		rq.dequeue();
		rq.dequeue();
		assertEquals(0, rq.size());
	}

}
