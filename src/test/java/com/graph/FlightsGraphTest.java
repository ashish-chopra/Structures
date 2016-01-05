package com.graph;

import com.graphs.SymbolGraph;

import junit.framework.TestCase;

public class FlightsGraphTest {

	private static String FLIGHT_ROUTES = "src/test/resources/routes.txt";
	private static String DELIMITER = " ";
	public void testQueriesOnFlightsGraph() {
		SymbolGraph flights = new SymbolGraph(FLIGHT_ROUTES, DELIMITER);
		System.out.println(flights.index("DEN"));
		
	}
	
	public static void main(String[] args) {
		SymbolGraph flights = new SymbolGraph(FLIGHT_ROUTES, DELIMITER);
		System.out.println(flights.index("DEN"));
	}
}
