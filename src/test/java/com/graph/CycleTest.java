package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import com.graphs.Cycle;
import com.graphs.Graph;

import junit.framework.TestCase;

public class CycleTest extends TestCase {

	private Graph graph;
	public void setUp() {
		Scanner scn = null;
		try {
			URL url = this.getClass().getClassLoader().getResource("tinyCyclicGraph.txt");
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.graph = new Graph(scn);

	}
	
	public void testBasicCycleDetection() {
		Cycle cycle = new Cycle(graph, 0);
		assertTrue(cycle.hasCycle());
	}
}
