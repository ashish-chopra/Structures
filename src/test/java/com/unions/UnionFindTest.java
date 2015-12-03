package com.unions;

import junit.framework.TestCase;

public class UnionFindTest extends TestCase {

	
	public void testOperations() {
		
		// initialize with 10 objects and
		// test for connectivity
		int N = 10;
		UnionFind uf = new UnionFind(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					assertEquals(true, uf.find(i, j));
				else
					assertEquals(false, uf.find(i, j));
			}
		}
		
		uf.union(1, 3);
		uf.union(7, 3);
		uf.union(5, 7);
		uf.union(2, 3);
		assertEquals(true, uf.find(1, 3));
		assertEquals(false, uf.find(2, 4));
		
		// an actual use case test
		uf = new UnionFind(N);
		uf.union(5, 3);
		uf.union(7, 5);
		uf.union(5, 6);
		uf.union(0, 7);
		uf.union(3, 9);
		uf.union(8, 5);

		String expected = "9129499999";
		assertEquals(expected, uf.toString());

	}

}
