package com.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import junit.framework.TestCase;

public class SelectionTest extends TestCase {
	
	public void testSortWithString(){
		
		String[] actual = {"F","M","B","Z","Q","A"};
		String[] expected = {"A","B","F","M","Q","Z"};
		Selection.sort(actual);
		//Selection.show(actual);
		assertEquals(expected[2],actual[2]);
		
	}
	
public void testSortWithIntegers(){
		
		Integer[] actual = {9,4,3,6,5,2};
		Integer[] expected = {2,3,4,5,6,9};
		Selection.sort(actual);
		//Selection.show(actual);
		assertEquals(expected[4],actual[4]);
		
	}

public void testSortwithValues(){
	
	Map<String,Integer> m1= new HashMap<String,Integer>();
	m1.put("delhi", 18);
	m1.put("mumbai", 15);
	m1.put("Banglore", 12);
	m1.put("Himachal", 8);
	m1.put("Chennai", 15);
	
	Set<Map.Entry<String,Integer>>s1 = m1.entrySet();
	MyData[] l1 = new MyData[m1.size()];
	int i=0;
	for(Map.Entry<String, Integer> entry: s1){
		l1[i++] = new MyData(entry.getKey(), entry.getValue());
		
	}
	
	Selection.sort(l1);
	assertEquals("Banglore",l1[1].getStateName());
	
}

private class MyData implements Comparable<MyData>{
	
	private String stateName;
	private int population;
	
	public MyData(String name, int number){
		this.stateName = name;
		this.population = number;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public int compareTo(MyData arg0) {
		int val = Integer.compare(this.population, arg0.population);
		return val != 0? val : stateName.compareTo(arg0.stateName);
	}
}

}
