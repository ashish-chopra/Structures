/*
 *  File: UnionFind.java
 *  Author: Ashish Chopra
 *  Date: 5 Feb, 2013
 *  Date Modified: 6 Feb, 2013
 *  ----------------------------------------------
 *  In a dynamic connectivity problem, we have some set of objects which 
 *  can connect to one another. This way we can have many joined networks
 *  in the set. In this data structure, each object is given an integer from 0
 *  and supports operations like:
 *  
 *  1) union: Used to connect two objects. for eg,
 *     union(3, 6)
 *     union(9, 1)
 *     
 *  2) Find: to determine if there is a path connecting two objects. for eg,
 *     connected(5, 1) -> true
 *     connected(6, 2) -> false
 *  
 *  Each object is said to have connection with itself. And the set of objects that are 
 *  connected together represents a connected component set. Union-Find data structures keep
 *  track of such connected components. There are different strategies to develop UF data structure:
 *  
 *  1) Quick-Find: Here find operation is very quick, but union takes linear time , O(N).
 *  2) Quick-Union: Here Union is done in constant time, but find takes O(N).
 *  3) Weighted Quick-Union
 *  4) Path Compression Quick Union
 *  
 *  Union-Find data structure is useful in number of applications like social network analysis,
 *  percolation in physical chemisty, electrical conductivity simulation of a material, graph theory,
 *  computer networks.
 *  
 *  Note: This data structure is used to connect and determine if there is any connection/ path exists 
 *  between two objects/node; it does not determine the best path b/w them. 
 *  
 */
package com.unions;

/**
 * UnionFind structure is based on quick-find technique in which objects are 
 * denoted by an integer number inside the structure and each union operation 
 * will update the id of each object to represent a connection between two of them.
 * 
 * @author Ashish Chopra
 * @version 1.0
 */
public class UnionFind {

	// objects represented as an id array of ints
	private int[] id; 
	
	/**
	 * constructs a UF object for N items.
	 * @param N number of items in positive integer.
	 */
	public UnionFind(int N) {
		id = new int[N];
		
		// initialize each object with its own id initially.
		for(int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}
	
	/**
	 * connects two objects given by its arguments.
	 * @param p id for the first object.
	 * @param q id for the second object.
	 */
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) id[i] = qid;
		}
	}
	
	/**
	 * checks to see if there is a connection between
	 * given two object ids.
	 * @param p first object id
	 * @param q second object id
	 * @return true if connected, false otherwise.
	 */
	public boolean find(int p, int q) {
		return id[p] == id[q];
	}
	
	/**
	 * returns a string representation of UF.
	 * 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i: id) {
			sb.append(i);
		}
		return sb.toString();
	}
}