package com.queues;

import java.util.NoSuchElementException;
import com.Test;

public class DequeTest implements Test {

	public void run() {

		
		// test empty deque
		Deque<String> que = new Deque<String>();
		assert (que.size() == 0);
		assert (que.isEmpty());
		
		// test add front 
		que.addFirst("quick");
		que.addFirst("brown");
		que.addFirst("fox");
		que.addFirst("jumps");
		assert (que.size() == 4);
		assert (!que.isEmpty());
		
		//check null condition in addFront
		try {
			que.addFirst(null);
		} catch (NullPointerException e) {
			assert true;
		} catch (Exception e) {
			assert false;
		}
	
		// test remove front
		assert (que.removeFirst().equals("jumps"));
		assert (que.removeFirst().equals("fox"));
		assert (que.removeFirst().equals("brown"));
		assert (que.size() == 1);
		assert (que.removeFirst().equals("quick"));
		assert (que.isEmpty());
		
		// check underflow condition
		try {
			que.removeFirst();
		}  catch (NoSuchElementException e) {
			assert true;
		} catch (Throwable e) {
			assert false;
		}
		
		que.addFirst("incredible");
		que.removeFirst();
		assert (que.isEmpty());
		assert (que.size() == 0);
		
		que.addFirst("incredible");
		que.removeLast();
		assert (que.isEmpty());
		assert (que.size() == 0);
		
	
		// test add Last
		assert (que.size() == 0);
		que.addLast("quick");
		que.addLast("brown");
		que.addLast("fox");
		que.addLast("jumps");
		que.addLast("over");
		que.addLast("little");
		que.addLast("lazy");
		que.addLast("dog");
		assert (!que.isEmpty());
		assert (que.size() == 8);
		
		// try null addition at last
		try {
			que.addLast(null);
		} catch (NullPointerException e) {
			assert true;
		} catch (Throwable e) {
			assert false;
		}
		
		// test remove last
		assert (que.size() == 8);
		que.removeLast();
		que.removeLast();
		assert (que.size() == 6);
		assert (que.removeLast().equals("little"));
		assert (que.removeFirst().equals("quick"));
		assert (!que.isEmpty());
		
	}
}
