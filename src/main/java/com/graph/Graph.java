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
 */
package com.graph;

import java.util.Scanner;
import com.bags.Bag;

/**
 * Graph is an ADT that represents a collection of vertices V and the connection amongst them
 * called edges E. Every Graph G is defined as function of G = f(V, E). A graph is created by
 * calling one of the two constuctors. One creates a graph with given number of vertices.
 * Other takes a stream input and initializes the graph from stream data.
 * 
 * Graph provides following API
 * ----------------------------------------------
 * Graph (int v)                   // constructs a graph with given no. of vertices
 * Graph (Stream s)                // constructs a graph from input stream data
 * int V()                         // returns the number of vertices
 * int E()                         // returns the number of edges
 * Iterable<Integer> adj(int v)    // returns the adjacent vertices list of a given vertex v.    
 * void addEdge(int v, int w)      // adds an edge between vertex v and w. 
 * 
 * @author Ashish Chopra
 *
 */
public class Graph {
	private int V;				// number of vertices
	private int E;				// number of edges
	private Bag<Integer>[] adj; // adjacency list of vertices
	
	public Graph(int v) {
		if (v <= 0)
			throw new IllegalArgumentException("No. of vertices is zero or negative.");
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	
	public Graph(Scanner s) {
		this(s.nextInt());
		this.E = s.nextInt();
		for (int i = 0; i < E; i++) {
			addEdge(s.nextInt(), s.nextInt());
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Graph with V = " + V + " and E = " + E);
		for (int v = 0; v < V; v++) {
			sb.append(v + ": " + adj[v].toString());
		}
		return sb.toString();
	}
}
