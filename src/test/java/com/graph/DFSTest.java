package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import com.graphs.DepthFirstSearch;
import com.graphs.Graph;

import junit.framework.TestCase;

public class DFSTest extends TestCase {

	private Graph G;
	public void setUp() {
		String name = "tinyGraph.txt";
		Scanner scn = null;
		try {
			URL url = this.getClass().getResource("/" + name);
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			
		}
		this.G = new Graph(scn);
		
	}
	
	/*
	 *  1. Is the given graph is connected?
	 *  2. Is there any path between source vertex and given vertex.
	 */
	public void testDFSQueries() {
		DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
		
	}
}
