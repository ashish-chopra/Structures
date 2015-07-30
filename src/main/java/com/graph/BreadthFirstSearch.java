/*
 *  File: BreadthFirstSearch.java
 *  Author: Ashish Chopra
 *  Date: 17 July, 2015
 *  ------------------------------------------------
 *  BreadthFirstSearch process a given graph to traverse in
 *  breadth first search fashion. This fashion is used to identify 
 *  if path exist between the source vertex and destination vertex
 *  just like DFS. But it also helps in identifying the minimum path
 *  if exists.
 * 
 * 
 */
package com.graph;

import com.queues.Queue;
import com.stacks.Stack;

/**
 * Process a graph in BFS fashion to determine the minimum
 * path between a source vertex and any given vertex.
 * @author Ashish Chopra
 *
 */
public class BreadthFirstSearch {

	private boolean marked[];
	private int edgeTo[];
	
	public BreadthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s) {
		marked[s] = true;
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(s);
		
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			marked[v] = true;
			for (int w: G.adj(v)) {
				if (!marked[w]) {
					queue.enqueue(w);
					edgeTo[w] = v;
				}
			}
		}
	}
	
	/**
	 * returns the path between source vertex and
	 * given vertex as an Iterable set.
	 * @param v
	 * @return
	 */
	public Iterable<Integer> pathTo(int v) {
		Stack<Integer> stack = new Stack<Integer>();
		while (v != 0) {
			stack.push(v);
			v = edgeTo[v];
		}
		stack.push(v);
		return stack;
	}
	
	/**
	 * checks to see if there is a path between source vertex and
	 * given vertex v.
	 * @param v
	 * @return
	 */
	public boolean hasPathTo(int v) {
		return marked[v];
	}
}
