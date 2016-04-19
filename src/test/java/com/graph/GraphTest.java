package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import com.graphs.BasicOperations;
import com.graphs.Graph;

import junit.framework.TestCase;

public class GraphTest extends TestCase {

	private Graph graph;
	public void setUp() {
		
		Scanner scn = null;
		try {
			URL url = this.getClass().getResource("/tinyGraph.txt");
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.graph = new Graph(scn);
	}
	public void testGraphAPI() throws Exception {
		
		assertEquals(12, graph.getNumberOfVertices());
		assertEquals(16, graph.getNumberOfEdges());
		System.out.println(graph.toString());
	}
	
	public void testBasicOperationsOfGraph() {
		BasicOperations bo = new BasicOperations(graph);
		
		assertEquals(3, bo.degree(1));
		assertEquals(2, bo.degree(4));
		assertEquals(4, bo.degree(8));
		assertEquals(0, bo.degree(9));
		assertEquals(4, bo.maxDegree());
		assertEquals(0, bo.numberOfSelfLoops());
	}
	
}

