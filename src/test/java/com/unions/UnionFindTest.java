package com.unions;

import com.Test;

public class UnionFindTest implements Test {

	@Override
	public void run() {
		
		// initialize with 10 objects and
		// test for connectivity
		int N = 10;
		UnionFind uf = new UnionFind(N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					assert (uf.find(i, j));
				else
					assert (!uf.find(i, j));
			}
		}
		
		uf.union(1, 3);
		uf.union(7, 3);
		uf.union(5, 7);
		uf.union(2, 3);
		assert (uf.find(1, 3));
		assert (!uf.find(2, 4));
		
		// an actual use case test
		uf = new UnionFind(N);
		uf.union(5, 3);
		uf.union(7, 5);
		uf.union(5, 6);
		uf.union(0, 7);
		uf.union(3, 9);
		uf.union(8, 5);

		String expected = "9129499999";
		assert (expected.equals(uf.toString()));

	}

}
