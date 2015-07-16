package com.graph;

public class BreadthFirstSearch {

	private boolean marked[];
	private int edgeTo[];
	
	public BreadthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
	}
}
