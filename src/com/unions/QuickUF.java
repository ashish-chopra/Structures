/*
 *  File: QuickUF.java
 *  Date: 7 Feb, 2013
 *  --------------------------------------------------------
 *  QuickUF is an adaptation of union-find data structure in which
 *  union operation is optimized to carry out in constant time. It 
 *  however affects the time taken by find() operation. 
 *  
 *  In quick-union technique, each object is marked by its parent.
 *  and during union operation, the root of p becomes the child of root
 *  of q. And two objects are said to be connected if their roots are same.
 * 
 */
package com.unions;

/**
 * QuickUF data structure is an improvement over UnionFind in which
 * union operation is improved to be carried out in constant time.
 * 
 * @author Ashish Chopra
 * @see UnionFind
 * 
 */
public class QuickUF {

	private int[] id;
	
	/**
	 * constructs a QuickUF object for given number of items.
	 * @param N number of items in the set as positive integer.
	 */
	public QuickUF(int N) {
		id = new int[N];
		// each element is root of itself
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * 
	 * connects two object represented by their ids
	 * in one connected component set.
	 * @param p first object id as int.
	 * @param q second object id as int.
	 */
	public void union(int p, int q) {
		int p_root =  root(p);
		int q_root = root(q);
		id[p_root] = q_root;
	}
	
	/**
	 * finds if connection exists between given two objects.
	 * @param p first object as int
	 * @param q second object as int
	 * @return <code>true</code> if connected, <code>false</code> otherwise.
	 */
	public boolean find(int p, int q) {
		return root(p) == root(q);
	}

	
	private int root(int n) {
		int i = n;
		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}
}
