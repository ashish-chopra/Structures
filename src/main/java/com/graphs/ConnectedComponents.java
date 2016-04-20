/*
 *  File: CC.java
 *  Author: Ashish Chopra
 *  Date: 14 July, 2015
 *  ------------------------------------
 *  CC identifies the connected components in an undirected
 *  graph. A graph may have multiple connected components which are not
 *  connected to each other. These are identified by running DFS and keeping a
 *  list of marked vertices.
 *  
 *  Following API is supported by CC:
 *  --------------------------------------
 *       CC(Graph G)  		// process the graph G to identify CC.
 *   int count()			// number of connected components
 *   int id(int v)			// returns the connected component id (0 to count()-1) in which the given vertex v lies
 *   
 */
package com.graphs;

/**
 * It processes the given graph to identify the connected components
 * and mark each vertex to the component id to which it belongs to.
 * @author Ashish Chopra
 *
 */
public class ConnectedComponents {

	private boolean[] marked;
	private int[] id;
	private int count;
	
	public ConnectedComponents(Graph graph) {
		marked = new boolean[graph.getNumberOfVertices()];
		id = new int[graph.getNumberOfVertices()];
		count = 0;
		for (int v = 0; v < graph.getNumberOfVertices(); v++) {
			if (!marked[v]) {
				dfs(graph, v);
				count++;
			}
		}
	}
	
	private void dfs(Graph graph, int sourceVertex) {
		marked[sourceVertex] = true;
		id[sourceVertex] = count;
		for (int w: graph.adj(sourceVertex)) {
			if (!marked[w]) {
				dfs(graph, w);
			}
		}
	}
	public int count() {
		return count;
	}
	
	public int id(int v) {
		return id[v];
	}
}
