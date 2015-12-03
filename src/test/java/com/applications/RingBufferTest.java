package com.applications;

import java.util.NoSuchElementException;
import junit.framework.TestCase;


public class RingBufferTest extends TestCase {

	public void testBasicOperations() {
		
		RingBuffer rb = new RingBuffer(10);
		assertEquals(0, rb.size());
		assertEquals(true, rb.isEmpty());
		assertEquals(false, rb.isFull());
		try {
			rb.dequeue();
		} catch (NoSuchElementException e) {
			assertNotNull(e);
		} catch (Exception ex) {
			assertNull(ex);
		}
	}
	
	public void testCreationMethod() {
		try {
			RingBuffer rb = new RingBuffer(0);
		} catch (IllegalArgumentException e) {
			assertNotNull(e);
		} catch (Exception ex) {
			assertNull(ex);
		}
	}
	
	public void testEnqueue() {
		
		// testing enqueue operation
		RingBuffer rb = new RingBuffer(4);
		assertEquals(0, rb.size());
		
		rb.enqueue("a");
		rb.enqueue("b");
		assertEquals(2, rb.size());
		
		rb.enqueue("c");
		rb.enqueue("d");
		assertEquals(4, rb.size());
		
		try {
			rb.enqueue("f");
		} catch (RuntimeException ex) {
			assertNotNull(ex);
		} catch (Exception e) {
			assertNull(e);
		}
		
	}
	
	public void testDequeue() {
		
		RingBuffer rb = new RingBuffer(4);	
		rb.enqueue("a");
		rb.enqueue("b");	
		rb.enqueue("c");
		rb.enqueue("d");
		
		String item = rb.dequeue();
		assertEquals(true, item.equals("a"));
		
		item = rb.dequeue();
		assertEquals(true,item.equals("b"));
		assertEquals(false, rb.isFull());
		
		item = rb.dequeue();
		rb.enqueue("f");
		assertEquals(false, rb.isFull());
		assertEquals(3, rb.size());
		rb.enqueue("g");
		assertEquals(4, rb.size());
		item = rb.dequeue();
		assertEquals(true, item.equals("d"));
	}
}
