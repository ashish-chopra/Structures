/*
 *  File: UnionFind.java
 *  Author: Ashish Chopra
 *  Date: 5 Feb, 2013
 *  ----------------------------------------------
 *  In a dynamic connectivity problem, we are given a set
 *  of objects in which few objects are connected to the other.
 *  So we need to determine whether one is connected to other or not,
 *  for this purpose we use Union-Find data structure, which maintains a
 *  list of all objects along with the connected components.
 *  
 *  In this data structure, each object is given a number 0 - 9 and supports 
 *  operations like:
 *  union(3, 6)  = void
 *  connected(5, 1) = true | false  (it is also called find(5, 1))
 *  
 *  The data structure keeps updating the connected component-sets during each 
 *  union operation.
 *  
 *  Union-Find data structures are implemented using quick-find, quick-union, 
 *  wighted-quick-union, path-compression-weighted-union techniques.
 *  
 *  It is useful in network connectivity problem, electricity conductibity problem,
 *  percolation problem of physical chemistry and many more.
 *  
 */
package com.unions;

/**
 * UnionFind data structure is implemented according to quick-find
 * technique. Each object is given a number starting from 0 which are 
 * initially disconnected. They connects with subsequent calls to union
 * operation.
 * 
 * @author Ashish Chopra
 *
 */
public class UnionFind {

	private int[] id;
	
	public UnionFind(int N) {
		id = new int[N];
	}
	
	public void union(int p, int q) {
		
	}
	
	public boolean find(int p, int q) {
		return false;
	}
}