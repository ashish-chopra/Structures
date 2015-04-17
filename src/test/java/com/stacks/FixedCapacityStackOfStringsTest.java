package com.stacks;

import com.Test;

public class FixedCapacityStackOfStringsTest implements Test{

	public void run() {
		
		//testing empty stack
		FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);
		assert (stack.isEmpty());
		assert (stack.size() == 0);
		
		// testing push
		stack.push("quick");
		stack.push("brown");
		stack.push("fox");
		assert (!stack.isEmpty());
		assert (stack.size() == 3);
		
		// testing pop
		assert (stack.pop().equals("fox"));
		assert (stack.pop().equals("brown"));
		assert (stack.size() == 1);
		assert (stack.pop().equals("quick"));
		assert (stack.isEmpty());
		assert (stack.size() == 0);
		
		// testing underflow
		try {
			stack.pop();
		} catch (ArrayIndexOutOfBoundsException e) {
			assert true;
		}
			
		
		
	}
	
}
