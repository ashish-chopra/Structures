package com.queues;

import java.util.NoSuchElementException;

import junit.framework.TestCase;

import com.Test;

public class DequeTest extends TestCase {

	public void testEmpty() {
		
		// test empty deque
		Deque<String> que = new Deque<String>();
		assertEquals(0, que.size());
		assertEquals(true, que.isEmpty());
	}
	
	public void testInsertDeleteOperations() {
		
		Deque<String> que = new Deque<String>();
		assertEquals(0, que.size());
		
		// test add front 
		que.addFirst("quick");
		que.addFirst("brown");
		que.addFirst("fox");
		que.addFirst("jumps");
		assertEquals(4, que.size());
		assertEquals(false, que.isEmpty());
		
		//check null condition in addFront
		try {
			que.addFirst(null);
		} catch (NullPointerException e) {
			assertNotNull(e);;
		} catch (Exception e) {
			assertNull(e);
		}
	
		// test remove front
		assertEquals("jumps", que.removeFirst());
		assertEquals("fox", que.removeFirst());
		assertEquals("brown", que.removeFirst());
		assertEquals(1, que.size());
		assertEquals("quick", que.removeFirst());
		assertEquals(true, que.isEmpty());
		
		// check underflow condition
		try {
			que.removeFirst();
		}  catch (NoSuchElementException e) {
			assertNotNull(e);
		} catch (Throwable e) {
			assertNull(e);;
		}
		
		que.addFirst("incredible");
		que.removeFirst();
		assertEquals(true, que.isEmpty());
		assertEquals(0, que.size());
		
		que.addFirst("incredible");
		que.removeLast();
		assertEquals(true, que.isEmpty());
		assertEquals(0, que.size());
		
	
		// test add Last
		assertEquals(0, que.size());
		que.addLast("quick");
		que.addLast("brown");
		que.addLast("fox");
		que.addLast("jumps");
		que.addLast("over");
		que.addLast("little");
		que.addLast("lazy");
		que.addLast("dog");
		assertEquals(false, que.isEmpty());
		assertEquals(8, que.size());
		
		// try null addition at last
		try {
			que.addLast(null);
		} catch (NullPointerException e) {
			assertNotNull(e);
		} catch (Throwable e) {
			assertNull(e);;
		}
		
		// test remove last
		assertEquals(8, que.size());
		que.removeLast();
		que.removeLast();
		assertEquals(6, que.size());
		assertEquals("little", que.removeLast());
		assertEquals("quick", que.removeFirst());
		assertEquals(false, que.isEmpty());
		
	}
}
