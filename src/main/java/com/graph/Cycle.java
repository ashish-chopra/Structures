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
 * @author Ashish Chopra
 *
 */
public class Cycle {

	private boolean marked[];	// list of vertices marked true if visited.
	private boolean hasCycle;   // flag to record if cycle exists.
	private Graph G;			// the graph under consideration
	

	/**
	 * creates a Cycle object which processes the
	 * given graph from the given source vertex s.
	 * @param G The Graph under processing.
	 * @param s source vertex
	 */
	public Cycle(Graph G, int s) {
		this.G = G;
		this.marked = new boolean[G.V()];
		this.hasCycle = false;
		dfs(G, s);
	}
	
	/*
	 * runs DFS on a given graph and identifies cycle.
	 * If any vertex which has already been marked/visited,
	 * is seen again, then cycle exists. 
	 * 
	 */
	private void dfs(Graph G, int s) {
		marked[s] = true;
		for (int w: G.adj(s)) {
			if (!marked[w])
				dfs(G, w);
			else {
				hasCycle = true;
				break;
			}
		}
	}
	
	/**
	 * determines if the given Graph G has cycle.
	 * @return true if cycle exists, false otherwise.
	 */
	public boolean hasCycle() {
		return hasCycle;
	}
}
