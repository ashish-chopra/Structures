
package com.graph;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

import junit.framework.TestCase;

import com.queues.Queue;

public class CCTest extends TestCase {

	private Graph G;
	public void setUp() {
		Scanner scn = null;
		try {
			URL url = this.getClass().getResource("/tinyGraphCC.txt");
			scn = new Scanner(new File(url.getFile()));
		} catch (Exception e) {
			
		}
		this.G = new Graph(scn);
	}
	
	public void testCC() {
		CC cc = new CC(G);
		
		assertEquals(3, cc.count());
		Queue<Integer>[] components = (Queue<Integer>[]) new Queue[cc.count()];
		
		for (int i = 0; i < components.length; i++) {
			components[i] = new Queue<Integer>();
		}
		
		for (int v = 0; v < G.V(); v++) {
			int id = cc.id(v);
			components[id].enqueue(v);
		}
	
		for(int i = 0; i < components.length; i++) {
			for (int v: components[i]) {
				System.out.print(" " + v);
			}
			System.out.println("\n");
		}
		
	}
}
