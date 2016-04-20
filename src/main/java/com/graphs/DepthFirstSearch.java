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
package com.graphs;

public class DepthFirstSearch {

	private boolean[] marked; // vertices which are already visited
	private int[] edgeTo; // store the parent vertex for each visited vertex
	private int source;
	private int count; // count the number of vertices traveled during DFS.

	/**
	 * creates a depth first search object and process the given Graph in DFS
	 * fashion.
	 * 
	 * @param graph
	 *            Graph
	 * @param sourceVertex
	 *            source vertex
	 */
	public DepthFirstSearch(Graph graph, int sourceVertex) {
		this.source = sourceVertex;
		marked = new boolean[graph.V()];
		edgeTo = new int[graph.V()];
		edgeTo[sourceVertex] = Integer.MIN_VALUE;
		dfs(graph, sourceVertex);
	}

	/**
	 * checks if the given vertex is marked. This will help in answering
	 * questions like, is there any path between given vertex and source vertex?
	 * 
	 * @param vertex
	 *            destination vertex in the graph.
	 * @return true if path exists, false otherwise.
	 */
	public boolean marked(int vertex) {
		return marked[vertex];
	}

	private void dfs(Graph graph, int source) {
		marked[source] = true;
		count++;
		for (int w : graph.adj(source)) {
			if (!marked[w]) {
				edgeTo[w] = source;
				dfs(graph, w);
			}
		}
	}

	/**
	 * returns the number of vertices connected in the graph. if the count is
	 * equal to total number of vertices of the graph, then the complete graph
	 * is connected, otherwise it contains connected components.
	 * 
	 * @return
	 */
	public int count() {
		return count;
	}

	public String pathTo(int w) {
		String path = null;
		int v = w;
		while (v == source) {
			path = edgeTo[w] + " - " + path;
		}
		path = source + " - " + path + " - " + w;
		return path;
	}

}
