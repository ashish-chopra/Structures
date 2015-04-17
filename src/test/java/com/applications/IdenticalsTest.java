package com.applications;

import com.Test;

public class IdenticalsTest implements Test{

	public void run() {
		int[] a = new int[] {1,2,3,4,5};
		int[] b = new int[] {3,7,8,10,18};
		Identicals identicals = new Identicals(a, b);
		assert ("[3,]".equals(identicals.printIdenticals()));
		
		a = new int[] {1,2,3,4,5, 8, 10,22,56};
		b = new int[] {3,7,8,10,18, 20, 22, 56};
		identicals = new Identicals(a, b);
		assert ("[3,8,10,22,56,]".equals(identicals.printIdenticals()));
		
		a = new int[] {1,2,3,4,5, 8, 10,11,56};
		b = new int[] {3,7,8,10,18, 20, 22, 56};
		identicals = new Identicals(a, b);
		assert ("[3,8,10,56,]".equals(identicals.printIdenticals()));
		
		a = new int[] {1,2,3,4,5, 8, 10,11,56};
		b = new int[] {4,5,8,10,17, 20,22,76};
		identicals = new Identicals(a, b);
		assert ("[4,5,8,10,]".equals(identicals.printIdenticals()));
		
		a = new int[] {1,2,3,4,5, 8, 10,11,90};
		b = new int[] {6,7,8,10,18, 20, 22, 56};
		identicals = new Identicals(a, b);
		assert ("[8,10,]".equals(identicals.printIdenticals()));
		
		a = new int[] {1,2,3,4,5, 8, 10,11,56};
		b = new int[] {57,89,90,92,99,100, 101, 102};
		identicals = new Identicals(a, b);
		assert ("[]".equals(identicals.printIdenticals()));
		
	}
	
	
}
