package com.applications;

import junit.framework.TestCase;

public class HumpingDumpingTest extends TestCase {

	public void testHumpingDumpingSwap() {
			HumpingDumping hd = new HumpingDumping(new  int[]{5,0,1,4,2,3});
			hd.swap();
			assertEquals("Data: 3, 5, 0, 2, 1, 4, ", hd.toString());
			
	}
}
