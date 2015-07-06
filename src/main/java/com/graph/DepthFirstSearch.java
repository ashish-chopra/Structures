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
 *  5. Using DFS we can answer queries like "Is it a connected graph; Is there any path between two given vertices;
 *     Find a path b/w given two vertices"
 *   
 *  
 */
package com.graph;

public class DepthFirstSearch {
	
	private boolean[] marked;
	private int[] edgeTo;
	private Graph G;
	
	public boolean marked(int v) {
		return false;
	}
	
	public void dfs(Graph G, int s) {
		
	}

}
