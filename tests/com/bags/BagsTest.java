package com.bags;

import java.util.Iterator;

import com.Test;

public class BagsTest implements Test {
	
	public void run() {

		// testing the initial size of the bag.
		Bag<Integer> balls = new Bag<Integer>();
		assert (balls.isEmpty());
		
		// testing add operation
		balls.add(4);
		balls.add(5);
		balls.add(6);
		
		assert (!balls.isEmpty());
		assert (balls.size() == 3);
		
		// testing remove operation
		Iterator<Integer> it = balls.iterator();
		try {
			while (it.hasNext()) {
				it.remove();
			}
		} catch (UnsupportedOperationException e) {
			assert (false);
		} catch (Throwable ex) {
			assert (false);
		}
	}

}
