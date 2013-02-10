/*
 *  File: WeightedQuickUF.java
 *  Author: Ashish Chopra
 *  Date: 10 Feb, 2013
 *  -------------------------------------------------
 *  Weighted Quick Union-find is an improved version of
 *  quick union-find data structure in which each object 
 *  can be found within the range of constant depth from the
 *  root. It eradicates the problem occurred in QuickUF data structure
 *  in which the depth of finding node x can be very high i.e the 
 *  tree can grow longer in one direction.
 *  
 *  
 * 
 */
package com.unions;

/**
 * WeightedQuickUF is an improved adaptation in which the dynamic
 * connectivity takes place based on the weight of the each node.
 * @author Ashish Chopra
 * @see QuickUF
 */
public class WeightedQuickUF {

	private int[] id;   // object ids
	private int[] sz;   // the size of the tree rooted at i
	
	/**
	 * Constructs the object
	 * @param N size of the Union-find as int.
	 */
	public WeightedQuickUF(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
		
	}
	
	/**
	 * checks to see if given two objects by their id are connected.
	 * @param p first object id as int.
	 * @param q second object id as int.
	 * @return <code>true</code> if p and q are connected,
	 *         <code>false</code> otherwise.
	 */
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}
	
	/**
	 * 
	 * connects two given objects by their id.
	 * @param p first object id as int.
	 * @param q second object id as int.
	 */
	public void union(int p, int q) {
		int p_root = root(p);
		int q_root = root(q);
		if (sz[p] > sz[q]) {
			id[q_root] = p_root;
			sz[p] += sz[q];
		} else {
			id[p_root] = q_root;
			sz[q] += sz[p];
		}
	}
	
	/**
	 * returns the string representation of the object state.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i: id) {
			sb.append(i);
		}
		return sb.toString();
	}
	
	/*
	 *  returns the root of the given object.
	 */
	private int root(int x) {
		while (id[x] != x) {
			x = id[x];
		}
		return x;
	}
}