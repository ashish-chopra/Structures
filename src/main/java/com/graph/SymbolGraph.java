/*
 *  File: SymbolGraph.java
 *  Author: Ashish Chopra
 *  Date: 12 Dec, 2015
 *  ---------------------------------------------------------------------
 *  The graphs problem encountered in real world applications does
 *  not consist of vertices with integer indices, instead they consist
 *  of Strings, names, objects etc. Symbol Graph is a data structure 
 *  built upon Graph ADT to encapsulate the functionality to deal with 
 *  non-integer indices.
 *  
 *  SymbolGraph ADT provides following API:
 *  -------------------------------------------------------------------------------------------------------------
 *  			SymbolGraph(String filename, String delimiter)		// constructor
 *  boolean		contains(String key)								// checks if given key is present in graph
 *  String		name(int v)											// return the name of vertex with given index
 *  int			index(String key)									// returns the index of the given key.
 *  Graph		G()													// returns the underlying graph representation
 *  
 *  
 *  Features/Notes:
 *  ------------------------
 *  1. Symbol Graph maintains a symbol table of String to Integer which maps distinct 
 *     keys in the graph with a unique integer.
 *  2. Also in order to answer queries to identify the string representation of vertices, 
 *     given its integer index, it maintains the inverted index of keys as an array.
 *  3. SymbolGraph ADT is more of a storage data structure. It does not perform any 
 *     graph processing algorithms etc. Since it can return the underlying Graph ADT which 
 *     can further be input into any graph processing algorithm to answer queries. 
 *  
 *  
 */
package com.graph;

import java.io.File;
import java.util.Scanner;

import com.tables.ST;

/**
 * SymbolGraph ADT abstracts the representation of real world situations 
 * of Graph consists of non-integer vertices. It uses the Graph ADT as 
 * the underlying representation of Graph processing.
 * 
 * @author Ashish Chopra
 *
 */
public class SymbolGraph {

	private ST<String, Integer> st;  // stores keys and their index
	private String[] keys;			// stores inverted index of keys
	private Graph G;				// Graph representation of SymbolGraph
	
	public SymbolGraph(String name, String delimiter) {
		Scanner scn = null;
		try {
			scn = new Scanner(new File(name));
			st = new ST<String, Integer>();

			// reading the distinct vertices in ST
			while (scn.hasNextLine()) {
				String line = scn.nextLine();
				String[] words = line.split(delimiter);
				for(String w: words) {
					if(!st.contains(w))
						st.put(w, st.size());
				}
			}
			scn.close();
			
			// creating inverted index
			keys = new String[st.size()];
			for (String k: st.keys()) {
				keys[st.get(k)] = k;
			}
			
			//second pass to create a graph
			scn = new Scanner(new File(name));
			G = new Graph(st.size());
			while (scn.hasNextLine()) {
				String line = scn.nextLine();
				String[] words = line.split(delimiter);
				int v = st.get(words[0]);
				for (int i = 0; i < words.length; i++) {
					G.addEdge(v, st.get(words[i]));
				}
			}

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
