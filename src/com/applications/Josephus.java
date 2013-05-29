/*
 *  File: Josephus.java
 *  Author: Ashish Chopra
 *  Date: 29 May, 2013
 *  ---------------------------------------
 *  Josephus problem is a theoritcal computer science
 *  problem or a counting-out game in which N number of 
 *  people are waiting in a circle to be executed. The executor
 *  will pick every Mth person and executes him. The only one left 
 *  in the end will survive. 
 *  
 */
package com.applications;

import com.queues.Queue;

/**
 * Josephus is simulation of Josephus problem which accepts two integers
 * from command line N, M and will print the series of execution.
 * This implementation of Josephus problem is based on Queue data structure 
 * from com.queues package.
 * 
 * @author Ashish Chopra
 * @version 1.0
 */
public class Josephus {

	private Queue<Integer> people;
	private int N;
	public Josephus(int N) {
		if (N <= 0)
			throw new IllegalArgumentException("You have entered a bad N :(");
		people = new Queue<Integer>();
		this.N = N;
		for (int i = 0; i < N; i++) {
			people.enqueue(i);
		}
	}
	
	public String execute(int M) {
		if (M < 1 || M >= N)
			throw new IllegalArgumentException("M is out of range!");
		String sequence = "";
		while (!people.isEmpty()) {
			sequence += removeAt(2) + " ";
		}
		return sequence;
	}
	
	private String removeAt(int index) {
		int count = 1;
		while (count < index) {
			int person = people.dequeue();
			people.enqueue(person);
			count++;
		}
		return people.dequeue().toString();
	}
	
	// Unit Test 
	public static void main(String[] args) {
		Josephus josephus = new Josephus(7);
		String sequence = josephus.execute(2);
		System.out.println(sequence);
	}
}
