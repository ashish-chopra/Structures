package com;

import com.applications.IdenticalsTest;
import com.applications.RingBufferTest;
import com.bags.BagsTest;
import com.queues.DequeTest;
import com.queues.RandomizedQueueTest;
import com.queues.StequeTest;
import com.stacks.FixedCapacityStackOfStringsTest;
import com.stacks.ResizingCapacityStackOfStringsTest;
import com.stacks.StackOfStringsTest;
import com.stacks.StackTest;
import com.unions.QuickUFTest;
import com.unions.UnionFindTest;
import com.unions.WeightedQuickUFTest;

public class AcceptanceTester {

	private static final Test[] tests = {
		new StackOfStringsTest(),
		new FixedCapacityStackOfStringsTest(),
		new ResizingCapacityStackOfStringsTest(),
		new StackTest(),
		new DequeTest(),
		new StequeTest(),
		new RandomizedQueueTest(),
		new UnionFindTest(),
		new QuickUFTest(),
		new WeightedQuickUFTest()
	};
	
	public static void main(String[] args) {
		System.out.println("Unit testing elementary data structures!");
		
		boolean assertionsEnabled = false;
		try {
			assert (false);
		} catch (AssertionError e) {
			assertionsEnabled = true;
		}
		
		boolean failed = false;

	      if (!assertionsEnabled) {
	         System.out.println ("Please enable assertions, run with java -ea");
	         failed = true;
	      } else {
	         // step thru all the tests one at a time
	         for ( int i = 0; i < tests.length && !failed; i++) {
	            Test test = tests[i];
	            System.out.println ("Running "+test);
	            try {
	               test.run();
	            } catch (Throwable t) {
	               System.out.println ("TEST FAILED");
	               System.out.println ("Printing stack trace...");
	               t.printStackTrace ();
	               failed = true;
	            }
	         }
	      }

	      if (failed) {
	         System.out.println ("FAILED");
	         System.out.println ("Not accepted!");
	      } else { 
	         System.out.println ("ACCEPTED");
	         System.out.println ("You are awesome!");
	      }
	   }
	
}
