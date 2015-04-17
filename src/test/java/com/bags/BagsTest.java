package com.bags;

import java.util.Iterator;

import com.Test;

public class BagsTest implements Test {
	
	public void run() {

		// testing the initial size of the bag.
		Bag<Integer> balls = new Bag<Integer>();
		assert (balls.isEmpty());
		assert (balls.size() == 0);
		
		// testing add operation
		balls.add(4);
		balls.add(5);
		balls.add(6);
		
		assert (!balls.isEmpty());
		assert (balls.size() == 3);
		
		// testing remove operation
		Iterator<Integer> it = balls.iterator();
			while (it.hasNext()) {
				try {
					it.remove();
				} catch (UnsupportedOperationException e) {
					assert (true);
				} catch (Throwable ex) {
					assert (false);
				}
			}
	}

}
