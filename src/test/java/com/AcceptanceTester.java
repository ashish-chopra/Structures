/*
 * 
 *  File:   AcceptanceTester.java
 *  Author: Ashish Chopra
 *  Date:   17 Apr, 2015
 *  ---------------------------------------------
 *  This file is no more in use since Maven is introduced.
 *  All the test cases are converted into Junits.
 * 
 */
package com;

/**
 * <code>AcceptanceTester</code> was designed with v1.0 release to implement
 * the test in-house test framework. It consists of a collection
 * of test cases which implements <code>Test</code> interface.
 * 
 * This <code>AcceptanceTester</code> runs the <code>run()</code> method of each test case.
 * With the introduction of maven, this class is no more used. Hence
 * just kept for archive purpose only. 
 * 
 * @author Ashish Chopra
 * @since 1.0
 */

@Deprecated
public class AcceptanceTester {

	private static final Test[] tests = {

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
