/*
 *  File: DepthFirstSearch.java
 *  Author: Ashish Chopra
 *  Date: 5 Jul, 2015
 *  ----------------------------------------------------
 *  This is a design of depth first search graph processing algorithm.
 *  We will not modify the basic API of Graph, In order to answer queries,
 *  we will build a seperate API like this one, which uses graph API to perform
 *  operations on it.
 *  
 *  Depth First Search Insights:
 *  1. During DFS, we keep storing the visited nodes by marking it. 
 *  2. At the end, we will find that using DFS, all the vertices of a graph are marked.
 *     This shows that graph is connected graph. If all the components are not marked, then
 *     graph has connected components.
 *  3. If we do not mark the visited vertices, then the DFS will run for infinite time.
 *  4. DFS will also able to find path/connection between two vertices (one is source, and other
 *     is destination); but that path depends on the nature of recursion and representation. 
 *     In order to find path with special properties like minimum distance etc, we will use other
 *     algorithms.
 *  5. Using DFS we can answer queries like 
 *     
 *      Is it a connected graph? 
 *      Is there any path between two given vertices?
 *      Find a path between two given vertices?
 *      Is the given graph acyclic?
 *  
 */
package com.graph;

public class DepthFirstSearch {
	
	private boolean[] marked;	// vertices which are already visited
	private int[] edgeTo;		// store the parent vertex for each visited vertex
	private int s;				// source vertex
	private int count;			// count the number of vertices traveled during DFS.
	
	/**
	 * creates a depth first search object and
	 * process the given Graph in DFS fashion.
	 * @param G Graph
	 * @param s source vertex
	 */
	public DepthFirstSearch(Graph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		edgeTo[s] = Integer.MIN_VALUE;
		dfs(G, s);
	}
	
	/**
	 * checks if the given vertex is marked.
	 * This will help in answering questions like,
	 * is there any path between given vertex and source vertex?
	 * 
	 * @param v destination vertex in the graph.
	 * @return true if path exists, false otherwise.
	 */
	public boolean marked(int v) {
		return marked[v];
	}
	
	private void dfs(Graph G, int s) {
		marked[s] = true;
		count++;
		for (int w: G.adj(s)) {
			if (!marked[w]) {
				edgeTo[w] = s;
				dfs(G, w);
			}
		}
	}
	
	/**
	 * returns the number of vertices connected in the graph.
	 * if the count is equal to total number of vertices of the graph,
	 * then the complete graph is connected, otherwise it contains connected
	 * components.
	 * @return
	 */
	public int count() {
		return count;
	}
	
	public String pathTo(int w) {
		String path = null;
		int v = w;
		while (v == s) {
			path = edgeTo[w] + " - " + path;
		}
		path = s + " - " + path + " - " + w;
		return path;
	}

}
