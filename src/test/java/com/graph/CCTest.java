
package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import com.queues.Queue;

import junit.framework.TestCase;

public class CCTest extends TestCase {

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
	
	public void TestCC() {
		Graph G = getGraph("tinyGraphCC.txt");
		CC cc = new CC(G);
		
		assertEquals(3, cc.count());
		Queue<Integer>[] components = (Queue<Integer>[]) new Object[cc.count()];
		
		for (int v = 0; v < G.V(); v++) {
			int id = cc.id(v);
			components[id].enqueue(v);
		}
	
	}
}
