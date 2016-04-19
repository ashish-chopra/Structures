/*
 *  File: Graph.java
 *  Author: Ashish Chopra
 *  Date: 4 jul, 2015
 *  ----------------------------------------------
 *  Graph is an abstract Data type that represents the collection
 *  of vertices and edges as provided by input.
 *
 *  The Graph will be studied and developed in four flavors:
 *  1. Undriected Graph
 *  2. Directed Graph
 *  3. Weighted Undirected Graph
 *  4. Weighted Digraph
 *
 *  The Graph is implemented using adjacency list, which allows self loops
 *  and parallel edges as well. Every edge will be stored twice in this
 *  representation. However this representation is the most efficient among
 *  others like Adjacency matrix, array of edges etc.
 *
 *  Various operations that are performed on graph like search, finding path,
 *  minimum path and other queries will be developed as their own class which
 *  utilize Graph G as input.
 *  
 *  
 *  Graph provides following API
 * ----------------------------------------------
 * Graph (int v)                   // constructs a graph with given no. of vertices
 * Graph (Stream s)                // constructs a graph from input stream data
 * int V()                         // returns the number of vertices
 * int E()                         // returns the number of edges
 * Iterable<Integer> adj(int v)    // returns the adjacent vertices list of a given vertex v.
 * void addEdge(int v, int w)      // adds an edge between vertex v and w.
 *
 */
package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.bags.Bag;

/**
 * Graph is an ADT that represents a collection of vertices V and the connection amongst them
 * called edges E. Every Graph G is defined as function of G = f(V, E). A graph is created by
 * calling one of the two constructors. One creates a graph with given number of vertices.
 * Other takes a stream input and initializes the graph from stream data.
 *
 * Note: This graph is an undirected graph, i.e. if a vertex v is reachable from vertex w, 
 * then it implies that w is reachable from v
 * 
 * @author Ashish Chopra
 *
 */
public class Graph {
	private int noOfVertices;
	private int noOfEdges;
	private List<Bag<Integer>> adj; // adjacency list of vertices

	/**
	 * creates an empty graph with zero edges with
	 * given number of vertices as input.
	 * @param totalVertices Total number of vertices in the graph.
	 */
	public Graph(int totalVertices) {
		if (totalVertices <= 0)
			throw new IllegalArgumentException("No. of vertices is zero or negative.");
		this.noOfVertices = totalVertices;
		this.noOfEdges = 0;
		adj = new ArrayList<Bag<Integer>>();
		for (int i = 0; i < noOfVertices; i++) {
			adj.add(new Bag<Integer>());
		}
	}

	/**
	 * creates a graph by reading input from 
	 * the input stream.
	 * <pre>
	 * The input format is like:
	 * 5	// number of vertices
	 * 6	// number of edges
	 * 0 3	// edge wise pair in E lines
	 * 2 4
	 * 3 4
	 * 1 2
	 * </pre>
	 * @param s
	 */
	public Graph(Scanner s) {
		this(s.nextInt());
		int noOfEdges = s.nextInt();
		for (int i = 0; i < noOfEdges; i++) {
			addEdge(s.nextInt(), s.nextInt());
		}
	}

	/**
	 * adds an edge v-w in the graph.
	 * @param v one vertex
	 * @param w other vertex
	 */
	public void addEdge(int v, int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
		noOfEdges++;
	}

	/**
	 * gets the total number of vertices in the graph.
	 * @return
	 */
	public int getNumberOfVertices() {
		return noOfVertices;
	}

	/**
	 * gets the total number of edges in the graph.
	 * @return
	 */
	public int getNumberOfEdges() {
		return noOfEdges;
	}

	/**
	 * returns a list of adjacent vertices of a 
	 * given vertex in the graph.
	 * @param v the vertex whose adjacency list is required.
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj.get(v);
	}

	/**
	 * checks to see if there is an edge v-w in the graph.
	 * @param v  one vertex
	 * @param w  other vertex
	 * @return
	 */
	public boolean hasEdge(int v, int w) {
		for (int k: adj(v)) {
			if (w == k) return true;
		}
		return false;
	}

	/**
	 * returns a String representation of the graph.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Graph with V = " + noOfVertices + " and E = " + noOfEdges + "\n");
		for (int v = 0; v < noOfVertices; v++) {
			sb.append(v + ": ");
			for (int w: adj(v)) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
