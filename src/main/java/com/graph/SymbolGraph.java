package com.graph;

import java.io.File;
import java.util.Scanner;

import com.tables.ST;

public class SymbolGraph {

	private ST<String, Integer> st;
	private String[] keys;
	private Graph G;
	
	public SymbolGraph(String name, String delimiter) {
		Scanner scn = null;
		try {
			scn = new Scanner(new File(name), delimiter);
			G = new Graph(scn);
		} catch (Exception e) {
			
		}
		
	}
	
	public Graph G() {
		return G;
	}
	
	public boolean contains(String key) {
		return st.contains(key);
	}
	
	public int index(String key) {
		return st.get(key);
	}
	
	public String name(int v) {
		return keys[v];
	}
}
