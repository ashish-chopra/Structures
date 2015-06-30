/*
 *  File: BST.java
 *  Author: Ashish Chopra
 *  Date: 30 June, 2015
 *  -----------------------------------------------------
 *  Binary Search Tree is a data structure that stores data in 
 *  Node format having left node and right node. 
 *  
 *  Why Binary search tree is required?
 *  Well, when we perform search and insert operation on a data structure
 *  it has been found that using a link list, we can improve the insert operation
 *  in O(1) time. Whereas search operation can be optimized if we can perform binary
 *  search operation over sorted data which is done in O(logN) time.
 *  
 *  Hence a data structure is needed which can provide the insert operation like link lists,
 *  and search operation like binary search.
 */
package com.trees;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private class Node {
		Key key;
		Value val;
		Node left;
		Node right;
		int N;
		
		public Node(Key key, Value value, Node left, Node right) {
			this.key = key;
			this.val = value;
			this.left = left;
			this.right = right;
			this.N = 1;
		}
	}
	
	/**
	 * creates an empty binary search tree
	 */
	public BST() {
		root = null;
	}
	
	/**
	 * checks to see if the tree is empty.
	 * @return <code>true</code> if tree is empty,
	 *         <code>false</code> otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * returns the current size of the tree.
	 * The size of a tree T is the number of nodes in the tree, rooted at
	 * node T.
	 * @return
	 */
	public int size() {
		return size(root);
	}
	
	/**
	 * inserts a key-value pair into the tree, if not already exists.
	 * In case if Key is found, then its corresponding value is replaced.
	 * if Value is <code>null</code>, then the entry will be deleted from
	 * tree.
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val) {
		if (x == null) {
			return new Node(key, val, null, null);
		}
		
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			x.val = val;
			return x;
		} else if (cmp < 0) {
			x.left = put(x.left, key, val);
		} else if (cmp > 0) {
			x.right = put(x.right, key, val);
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	/**
	 * gets the corresponding value for a given key.
	 * if key is not found then <code>null</code> is returned.
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(key, root);
	}
	
	private Value get(Key key, Node x) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		
		if (cmp < 0)
			return get(key, x.left);
		else if (cmp > 0)
			return get(key, x.right);
		
		return x.val;
	}
	
	private int size(Node x) {
		if (x == null) return 0;
		return x.N;
	}
	
	/*
	public Key floor(Key key) {
		return null;
	}
	
	public Key ceiling(Key key) {
		return null;
	}
	
	public void delete(Key key) {
		
	}
	
	public int rank(Key key) {
		return 0;
	}
	
	public Key select(int rank) {
		return null;
	}
	*/
	
}
