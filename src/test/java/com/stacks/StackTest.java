package com.stacks;

import com.Test;

public class StackTest extends Stack implements Test {

	public void run() {
	
		Stack<String> stack = new Stack<String>();
		stack.push("quick");
		stack.push("brown");
		stack.push("fox");
		stack.push("jumped");
		stack.push("over");
		stack.push("little");
		stack.push("lazy");
		stack.push("dog");
		
		assert stack.size() == 8;
	}
	
	
}
