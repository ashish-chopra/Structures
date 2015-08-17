package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import junit.framework.TestCase;

public class GraphTest extends TestCase {

	private Graph G;
	public void setUp() {
		
		Scanner scn = null;
		try {
			URL url = this.getClass().getResource("/tinyGraph.txt");
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			
		}
		this.G = new Graph(scn);
	}
	public void testGraphAPI() throws Exception {
		
		assertEquals(12, G.V());
		assertEquals(16, G.E());
		System.out.println(G.toString());
	}
	
	public void testBasicOperationsOfGraph() {
		BasicOperations bo = new BasicOperations(G);
		
		assertEquals(3, bo.degree(1));
		assertEquals(2, bo.degree(4));
		assertEquals(4, bo.degree(8));
		assertEquals(0, bo.degree(9));
		assertEquals(4, bo.maxDegree());
		assertEquals(0, bo.numberOfSelfLoops());
	}
	
}

