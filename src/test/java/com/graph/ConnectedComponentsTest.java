
package com.graph;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import junit.framework.TestCase;

import com.graphs.ConnectedComponents;
import com.graphs.Graph;
import com.queues.Queue;

public class ConnectedComponentsTest extends TestCase {

	private Graph graph;

	public void setUp() {
		Scanner scn = null;
		try {
			URL url = this.getClass().getClassLoader().getResource("tinyGraphCC.txt");
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.graph = new Graph(scn);
	}

	public void testConnectedComponents() {
		ConnectedComponents cc = new ConnectedComponents(graph);

		assertEquals(3, cc.count());
		List<Queue<Integer>> components = new ArrayList<Queue<Integer>>();
		
		for (int i = 0; i < cc.count(); i++) {
			components.add(new Queue<Integer>());
		}

		for (int v = 0; v < graph.getNumberOfVertices(); v++) {
			int id = cc.id(v);
			components.get(id).enqueue(v);
		}

		for (int i = 0; i < components.size(); i++) {
			for (int v : components.get(i)) {
				System.out.print(" " + v);
			}
			System.out.println("\n");
		}
	}
}
