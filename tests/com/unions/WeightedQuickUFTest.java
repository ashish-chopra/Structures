package com.unions;

import com.Test;

public class WeightedQuickUFTest implements Test {

	
	public void run() {
		int N = 10;
		WeightedQuickUF uf = new WeightedQuickUF(N);

		uf.union(4, 7);
		uf.union(3, 2);
		uf.union(6, 3);
		uf.union(2, 0);
		uf.union(9, 1);
		uf.union(3, 9);
		uf.union(5, 8);
		uf.union(7, 5);
		
		String expected = "2222782771";
		assert (expected.equals(uf.toString()));
		
	}

}
