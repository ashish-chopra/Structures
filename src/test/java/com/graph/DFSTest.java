package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import junit.framework.TestCase;

public class DFSTest extends TestCase {

	private Graph getGraph(String name) {
		Scanner scn = null;
		try {
			URL url = this.getClass().getResource("/" + name);
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			
		}
		Graph G = new Graph(scn);
		return G;
	}
	
	/*
	 *  1. Is the given graph is connected?
	 *  2. Is there any path between source vertex and given vertex.
	 */
	public void TestDFSQueries() {
		Graph G = getGraph("tinyGraph.txt");
		DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
		
	}
}
