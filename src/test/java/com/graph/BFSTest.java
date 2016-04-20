package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import com.graphs.BreadthFirstSearch;
import com.graphs.Graph;

import junit.framework.TestCase;

public class BFSTest extends TestCase {
	
	Graph graph;
	public void setUp() {
		Scanner scn = null;
		try {
			URL url = this.getClass().getClassLoader().getResource("tinyGraph.txt");
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.graph = new Graph(scn);
	}
	
	public void testBFSOperations() {
		int sourceVertex = 0;
		int destinationVertex = 5;
		BreadthFirstSearch bfs = new BreadthFirstSearch(graph, sourceVertex);
		assertTrue(bfs.hasPathTo(destinationVertex));
		
		sourceVertex = 0;
		destinationVertex = 9;
		bfs = new BreadthFirstSearch(graph, sourceVertex);
		assertFalse(bfs.hasPathTo(destinationVertex));

		sourceVertex = 11;
		destinationVertex = 9;
		bfs = new BreadthFirstSearch(graph, sourceVertex);
		assertFalse(bfs.hasPathTo(destinationVertex));
		
		sourceVertex = 10;
		destinationVertex = 9;
		bfs = new BreadthFirstSearch(graph, sourceVertex);
		assertFalse(bfs.hasPathTo(destinationVertex));
		
	}
}
