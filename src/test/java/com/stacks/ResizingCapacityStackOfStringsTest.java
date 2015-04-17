package com.stacks;

import com.Test;

public class ResizingCapacityStackOfStringsTest implements Test {

	public void run() {
		// creating empty test
		ResizingCapacityStackOfStrings stack = new ResizingCapacityStackOfStrings();
		assert (stack.isEmpty());
		
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
		
	}
}
