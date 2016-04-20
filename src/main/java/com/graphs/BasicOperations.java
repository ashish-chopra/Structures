/*
 * 
 *  File: BasicOperations.java
 *  Author: Ashish Chopra
 *  Date: 13 July, 2015
 *  ------------------------------------------------
 *  Collection of basic operations performed on Graph 
 *  data structure. 
 * 
 * 
 */
package com.graphs;

public class BasicOperations {

	Graph graph;

	public BasicOperations(Graph graph) {
		this.graph = graph;
	}

	/**
	 * gets the degree of a given vertex v in the graph G. A degree is the
	 * number of edges incident from vertex v.
	 * 
	 * @param vertex
	 *            vertex id as zero indexed <code>integer</code>
	 * @return degree as <code>integer</code>
	 */
	public int degree(int vertex) {
		if (vertex < 0 || vertex >= graph.V())
			throw new IllegalArgumentException("vertex not found in Graph");
		int degree = 0;
		for (int w : graph.adj(vertex)) {
			degree++;
		}
		return degree;
	}

	/**
	 * returns the maximum degree of the graph. That is the maximum number of
	 * edges to any vertex in the given graph.
	 * 
	 * @return degree as <code>int</code>.
	 */
	public int maxDegree() {
		int maxDegree = 0;
		for (int v = 0; v < graph.V(); v++) {
			int deg = degree(v);
			if (maxDegree < deg) {
				maxDegree = deg;
			}
		}
		return maxDegree;
	}

	/**
	 * calculates the average degree of a graph by averaging the degree of each
	 * vertex in the graph.
	 * 
	 * @return average as <code>double</code>.
	 */
	public double averageDegree() {
		double avgDegree = 0;
		int sumDegree = 0;
		for (int v = 0; v < graph.V(); v++) {
			sumDegree += degree(v);
		}
		avgDegree = sumDegree / graph.V();
		return avgDegree;
	}

	/**
	 * return the count of self loops in the graph. Self loop is an edge from
	 * vertex V to the same vertex V.
	 * 
	 * @return
	 */
	public int numberOfSelfLoops() {
		int count = 0;
		for (int v = 0; v < graph.V(); v++) {
			for (int w : graph.adj(v)) {
				if (w == v)
					count++;
			}
		}
		return count;
	}

}
