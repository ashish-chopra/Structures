package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import junit.framework.TestCase;

public class CycleTest extends TestCase {

	private Graph G;
	public void setUp() {
		Scanner scn = null;
		try {
			URL url = this.getClass().getResource("/tinyCyclicGraph.txt");
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.G = new Graph(scn);

	}
	
	public void testBasicCycleDetection() {
		Cycle cycle = new Cycle(G, 0);
		assertEquals(true, cycle.hasCycle());
	}
}
