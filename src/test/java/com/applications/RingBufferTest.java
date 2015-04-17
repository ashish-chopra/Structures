package com.applications;

import java.util.NoSuchElementException;

import com.Test;

public class RingBufferTest implements Test{

	public void run() {
		
		RingBuffer rb = new RingBuffer(10);
		assert (rb.size() == 0);
		assert (rb.isEmpty());
		assert (rb.isFull() == false);
		try {
			rb.dequeue();
		} catch (NoSuchElementException e) {
			assert true;
		} catch (Exception ex) {
			assert false;
		}
		
		try {
			rb = new RingBuffer(0);
		} catch (IllegalArgumentException e) {
			assert true;
		} catch (Exception ex) {
			assert false;
		}
		
		// testing enqueue operation
		rb = new RingBuffer(4);
		assert (rb.size() == 0);
		
		rb.enqueue("a");
		rb.enqueue("b");
		assert (rb.size() == 2);
		
		rb.enqueue("c");
		rb.enqueue("d");
		assert (rb.size() == 4);
		
		try {
			rb.enqueue("f");
		} catch (RuntimeException ex) {
			assert (rb.isFull());
		} catch (Exception e) {
			assert false;
		}
		
		String item = rb.dequeue();
		assert (item.equals("a"));
		
		item = rb.dequeue();
		assert(item.equals("b"));
		assert (rb.isFull() == false);
		
		item = rb.dequeue();
		rb.enqueue("f");
		assert (rb.isFull() == false);
		assert (rb.size() == 3);
		rb.enqueue("g");
		assert (rb.size() == 4);
		item = rb.dequeue();
		assert (item.equals("d"));
	}
}
