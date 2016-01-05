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
 *  
 *   * Following is the outline of this data structure:
 * 
 * 	BST<Key, Value>
 * ------------------------------------------------
 * 		 	BST()						// constructs an empty tree object
 * Value 	get(Key key)				// get the given key from tree
 * void  	put(Key key, Value value)  	// put the key, value pair in BST
 * boolean	contains(Key key)			// checks to see if the key is present in BST
 * int		size()						// gets the current size of BST
 * boolean	isEmpty()					// checks if the BST is empty
 * Key		min()						// gets the minimum key from BST
 * Key		max()						// gets the maximum key from BST
 * Key		floor(Key key)				// gets the floor of a given key
 * Key		ceiling(Key key)			// gets the ceiling of a given key
 * int		rank(Key key)				// gets the number of keys smaller than the given key
 * Key		select(int rank)			// select the key with a given rank
 * void		delete(Key key)				//deletes the given key and its value from BST
 * 
 * 
 */
package com.trees;

/**
 * BST stands for Binary Search Tree is a basic tree structure used to 
 * keep data in binary searchable format. On every compare, one side of tree is pruned 
 * which helps in achieving the searching performance similar to binary search. 
 * Since it uses linked nodes to represent each data item, hence insertion, deletion
 * etc are also performed in o(logN) time.
 * 
 * @author Ashish Chopra
 *
 * @param <Key>
 * @param <Value>
 */
public class BST<Key extends Comparable<Key>, Value> {

	private Node root;		// root element of the tree
	
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
	 * checks if the given key is present in BST.
	 * @param key
	 * @return <code>true</code> if key is available,
	 *		   <code>false</code> otherwise.
	 */
	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("Null key argument specified");
		Value val = get(key);
		return val != null;
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
	
	private int size(Node x) {
		if (x == null) return 0;
		return x.N;
	}
	
	
	/**
	 * gets the smallest key in BST
	 * @return Key
	 */
	public Key min() {
		if (isEmpty()) 
			return null;
		return min(root).key;
	}
	
	private Node min(Node x) {
		if (x == null)  // this check will never be encountered.
			return null;
		if (x.left != null)
			return min(x.left);
		else
			return x;
	}
	
	
	/**
	 * gets the largest key present in BST.
	 * @return key the largest key.
	 */
	public  Key max() {
		if (isEmpty())
			return null;
		return max(root).key;
	}
	
	private Node max(Node x) {
		if (x == null)
			return null;
		if (x.right != null)
			return max(x.right);
		else
			return x;
	}
	
	
	/**
	 * returns the floor of a given key in the tree.
	 * A floor of a key is defined as the largest element
	 * which is smaller than or equal to the given key.
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		Node n = floor(root, key);
		if (n != null) return n.key;
		return key;
	}
	
	private Node floor(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0) 
			return floor(x.left, key);
		else if (cmp > 0) {
			Node t = floor(x.right, key);
			if (t == null) 
				return x;
			else
				return t;
		}
		return x;
	}
	
	/**
	 * returns the ceiling of a given key in the tree.
	 * The key may/may not be present in the tree. A ceiling
	 * of a key is defined as the smallest element which is larger than or equal to
	 * the given key.
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		Node n = ceiling(root, key);
		if (n != null) return n.key;
		return key;
	}
	
	private Node ceiling(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x.key);
		if (cmp > 0) 
			return ceiling(x.right, key);
		else if (cmp < 0) {
			Node t = ceiling(x.left, key);
			if (t == null) 
				return x;
			else
				return t;
		}
		return x;
	}
	
	
	/**
	 * returns the rank of a key in the given tree.
	 * Rank is the number of keys smaller than the given key.
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		return rank(root, key);
	}
	
	private int rank(Node x, Key key) {
		if (x == null) return 0;
		
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(x.left, key);
		else if (cmp > 0)
			return rank(x.right, key) + size(x.left) + 1;

		return size(x.left);
	}
	
	/**
	 * returns a key with a given rank as input.
	 * @param rank
	 * @return
	 */
	public Key select(int rank) {
		return select(root, rank);
	}

	private Key select(Node x, int rank) {
		if (x == null) return null;
		
		int t = size(x.left);
		if(rank < t) return select(x.left, rank);
		else if (rank > t)
			return select(x.right, rank-t-1);
		return x.key;
	}
	
	/**
	 * deletes the node with minimum key from the BST.
	 * 
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if (x == null) return null;
		
		if (x.left == null) return x.right; 
	
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;	
		return x;
	}
	
	/**
	 * deletes the node containing the given key.
	 * @param key Key stored in BST.
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		
		if (cmp > 0) {
			x.right = delete(x.right, key);
		} else if (cmp < 0) {
			x.left = delete(x.left, key);
		} else {
			
			if (x.left == null) 
				return x.right;
			else if (x.right == null) 
				return x.left;
			else {
				
				Node t = x.right;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left; 
			}
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	
}
