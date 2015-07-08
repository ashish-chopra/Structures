package com.graph;

public class BasicOperations {

	Graph G;
	
	public BasicOperations(Graph G) {
		this.G = G;
	}
	
	/**
	 * gets the degree of a given vertex v in the graph G.
	 * A degree is the number of edges incident from vertex v.
	 * @param v vertex number as int
	 * @return degree as int
	 */
	public int degree(int v) {
		if (v < 0 || v >= G.V())
			throw new IllegalArgumentException("vertex not found in Graph");
		int degree = 0;
		for (int w: G.adj(v)) {
			degree++;
		}
		return degree;
	}
	
	/**
	 * returns the maximum degree of the graph. That is the maximum
	 * number of edges to any vertex in the given graph.
	 * @return degree as int.
	 */
	public int maxDegree() {
		int maxDegree = 0;
		for (int v = 0; v < G.V(); v++) {
			int deg = degree(v);
			if (maxDegree < deg) {
				maxDegree = deg;
			}
		}
		return maxDegree;
	}
	
	public int averageDegree() {
		return 0;
	}
	
	/**
	 * return the count of self loops in the graph.
	 * Self loop is an edge from vertex V to the same vertex V.
	 * @return
	 */
	public int numberOfSelfLoops() {
		int count = 0;
		for (int v = 0; v < G.V(); v++) {
			for(int w: G.adj(v)) {
				if (w == v) count++;
			}
		}
		return count;
	}
	
}
