/*
 *  File : Percolation.java
 *  Author: Ashish Chopra
 *  Date: 16 Feb, 2013
 *  ----------------------------------------------------
 *  
 */
package com.applications;

import com.unions.WeightedQuickUF;

public class Percolation {

	private int N;                        /* grid length */
	private int NxN;					  /* N x N grid size */          
	private boolean[] sites;              /* keeps track of open sites */
	private WeightedQuickUF set;
	private final int TOP_VIRTUAL_SITE;   
	private final int BOTTOM_VIRTUAL_SITE;
	
	/**
	 * creates a percolation object of N x N grid
	 * and initialize internal state of different parts.
	 * @param N Number of rows in a square grid as integer.
	 */
	public Percolation(int N) {
		this.N = N;
		this.NxN = N * N;
		this.set = new WeightedQuickUF(NxN + 2);
		this.sites = new boolean[NxN + 2];
		
		// setting up virtual sites and initializing
		TOP_VIRTUAL_SITE = 0;
		BOTTOM_VIRTUAL_SITE = NxN + 1;
		for (int i = 1, j = NxN; i <= N; i++, j--) {
			set.union(TOP_VIRTUAL_SITE, i);
			set.union(BOTTOM_VIRTUAL_SITE, j);
		}
		sites[TOP_VIRTUAL_SITE] = true;
		sites[BOTTOM_VIRTUAL_SITE] = true;
	}
	
	/*
	 *  transform the 2-D matrix position  
	 *  to 1-D array index.
	 */
	private int transform(int i, int j) {
		return (N * (i - 1)) + j;
	}
	
	/**
	 * 
	 * checks to see if the site at location (i, j)
	 * is opened.
	 * @param i row position in the grid
	 * @param j column position in the grid
	 * @return <code>true</code> if site is opened, 
	 *         <code>false</code> otherwise.
	 */
	public boolean isOpen(int i, int j) {
		int p = transform(i, j);
		if (i < 1 ||  p > NxN)
			throw new IndexOutOfBoundsException("out of range :(");
		
		return sites[p];
	}
	
	/**
	 * opens the site at location (i, j) if not opened
	 * already.
	 * @param i row position in the grid
	 * @param j column position in the grid
	 * 
	 */
	public void open(int i, int j) {
		int p = transform(i, j);
		if (p < 1 || p > NxN)
			throw new IndexOutOfBoundsException("out of range :(");

		sites[p] = true;
		
		if (isInRange(i, j + 1) && isOpen(i, j + 1)) 
			set.union(p, transform(i, j + 1));
		if (isInRange(i, j - 1) && isOpen(i, j - 1))
			set.union(p, transform(i, j - 1));
		if (isInRange(i - 1, j) && isOpen(i - 1, j))
			set.union(p, transform(i - 1, j));
		if (isInRange(i + 1, j) && isOpen(i + 1, j))
			set.union(p, transform(i + 1, j));
	}
	
	/**
	 * checks to see if there is a connected site from 
	 * top row of the grid to the bottom row.
	 * @return <code>true</code> if it percolates, 
	 *         <code>false</code> otherwise.
	 */
	public boolean percolates() {
		int p = 0;
		int q = NxN + 1;
		//return set.connected(p, q);
		return false;
	}
	
	/**
	 * checks to see if the site at location (i, j) is 
	 * a full site.
	 * @param i row index of the grid
	 * @param j column index of the grid
	 * @return <code>true</code> if its a full site,
	 *         <code>false</code> otherwise.
	 */
	public boolean isFull(int i, int j) {
		int q = transform(i, j);
		if (q < 1 || q > NxN)
			throw new IndexOutOfBoundsException("out of range :(");
		//return set.connected(0, q);
		return false;
	}
	
	private boolean isInRange(int i, int j) {
		int p = transform(i, j);
		return p >= 1 && p <= NxN; 
	}
	
}
