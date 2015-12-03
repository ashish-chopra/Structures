/*
 *  File: HumpingDumping.java
 *  Author: Tarun Jain
 *  Date Modified: 3 Dec, 2015
 *  --------------------------------------------------------
 *  HumpingDumping is a swapping game to swap a entries of unsorted integer 
 *  array such that the value at a[n] will be a[a[n]]
 *  
 * 	In order to develop this few points are mentioned:
 * 	- Position and values have range from 0 to n-1
 * 	- It should be performed in-place. No extra memory should be taken.
 * 	- Should have minimum time complexity.
 * 
 *  The solution given below can achieve the task in O(N).
 * 
 * 
 */

package com.applications;

public class HumpingDumping {
	
	private int[] data;		// array to hold integers
	
	/**
	 * constructs the HumpingDumping object with given 
	 * input array.
	 * @param data
	 */
	public HumpingDumping(int[] data) {
		this.data = data;
	}
	
	/**
	 * return the current size of the Humping Dumping array.
	 * @return
	 */
	public int size() {
		return data.length;
	}
	
	
	/**
	 * swap the elements in the said strategy as 
	 * mentioned above.
	 * 
	 */
	public void swap(){
		swap(0);
	}
	
	private void swap(int position){
		if (position == size())
			return;
		
		int temp =  data[data[position]];
		swap(position + 1);
		data[position] = temp;
	}
	
	/**
	 * returns the string representation of this object data.
	 */
	public String toString() {
		String output = "Data: ";
		for (int item : data) {
			output += item + ", ";
		}
		return output;
		
	}
	
}
