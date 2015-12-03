/*
 * 
 *  File:    Test.java
 *  Author:  Ashish Chopra
 *  Date:    17 Apr, 2015
 *  -----------------------------------
 *  This interface is no more in use since the introduction
 *  of Maven. All test cases are converted into Junits.
 * 
 * 
 */
package com;

/**
 * <Code>Test</code> type is created to mark
 * test case classes as test which is recognizable by
 * <code>AcceptanceTester</code> test suite.
 * 
 * With the introduction of Maven, it is deprecated now.
 * We kept it for archive purpose only.
 * 
 * @author Ashish Chopra
 * @since 1.0
 * 
 */

@Deprecated
public interface Test {
	public void run();
}
