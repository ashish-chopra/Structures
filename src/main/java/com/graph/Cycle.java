/*
 *  File: Cycle.java
 *  Author: Ashish Chopra
 *  Date: 13 July, 2015
 *  -----------------------------------------
 *  Cycle code detects if the given graph consists of cycles.
 *  A cycle in a graph is a path that has one vertex as the start and 
 *  the end of a path.
 *  
 *  In an undirected graph, a cycle can be detected by traversing the 
 * 
 */
package com.graph;
/**
 * Cycle detects if the given graph 
 * contains cycle or not.
 * 
 * @author eashcra
 *
 */
public class Cycle {

	private boolean marked[];
	private boolean hasCycle;
	private Graph G;
	private int s;
	

	public Cycle(Graph G, int s) {
		this.G = G;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int s) {
		marked[s] = true;
		for (int w: G.adj(s)) {
			if (!marked[w])
				dfs(G, w);
			else if (w == s) hasCycle = true;
		}
	}
	
	public boolean hasCycle() {
		return hasCycle;
	}
}
