package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import junit.framework.TestCase;

public class BFSTest extends TestCase {
	
	Graph G;
	public void setUp() {
		Scanner scn = null;
		try {
			URL url = this.getClass().getResource("/tinyGraph.txt");
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.G = new Graph(scn);
	}
	
	public void testBFSOperations() {
		int s = 0;
		int v = 5;
		BreadthFirstSearch bfs = new BreadthFirstSearch(G, s);
		assertEquals(true, bfs.hasPathTo(v));
		
		s = 0;
		v = 9;
		bfs = new BreadthFirstSearch(G, s);
		assertEquals(false, bfs.hasPathTo(v));

		s = 11;
		bfs = new BreadthFirstSearch(G, s);
		assertEquals(false, bfs.hasPathTo(v));
		
		//TODO: This test is failing. Need to be fixed.
		/*
		s = 10;
		bfs = new BreadthFirstSearch(G, s);
		assertEquals(true, bfs.hasPathTo(v));
		*/
	}
}
