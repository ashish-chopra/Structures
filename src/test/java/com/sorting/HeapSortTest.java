package com.sorting;

import java.util.Collections;

import junit.framework.TestCase;

public class HeapSortTest extends TestCase {

    public void testSortWithString() {

        String[] actual = { "F", "M", "B", "Z", "Q", "A" };
        String[] expected = { "A", "B", "F", "M", "Q", "Z" };
        Heap.sort(actual);
        assertEquals(expected[2], actual[2]);

    }

    public void testSortWithStringWithComparator() {

        String[] actual = { "F", "M", "B", "Z", "Q", "A" };
        String[] expected = { "Z", "Q", "M", "F", "B", "A" };
        Heap.sort(actual, Collections.reverseOrder());
        assertEquals(expected[2], actual[2]);

    }

    public void testSortWithIntegers() {

        Integer[] actual = { 9, 4, 3, 6, 5, 2 };
        Integer[] expected = { 2, 3, 4, 5, 6, 9 };
        Heap.sort(actual);
        assertEquals(expected[4], actual[4]);

    }

    public void testSortWithIntegersWithComparator() {

        Integer[] actual = { 9, 4, 3, 6, 5, 2 };
        Integer[] expected = { 9, 6, 5, 4, 3, 2 };
        Heap.sort(actual, Collections.reverseOrder());
        assertEquals(expected[4], actual[4]);

    }

    /*
     * test method to sort the array of object on the basis of population and if
     * population is same then object is sort on the basis of stateName in
     * natural order.
     */
    public void testSortingObjects() {

        City[] cities = { new City("Delhi", 18), new City("Banglore", 10), new City("Calcutta", 12),
                new City("Chennai", 10), new City("Rajasthan", 8) };
        Heap.sort(cities);
        assertEquals("Banglore", cities[1].getStateName());

    }

    // Test (expected = Exception.class)
    public void testException() {

        City[] l1 = null;
        try {
            Heap.sort(l1);
        } catch (Exception e) {
            assertNotNull(e);
        }

    }

    private class City implements Comparable<City> {

        private String stateName;
        private int population;

        public City(String name, int number) {
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

        /*
         * (non-Javadoc) method compares City class object on the basis of
         * population and return the non zero value, if value is zero then
         * object is compare on the basis of stateName.
         * 
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(City arg0) {
            int val = Integer.compare(this.population, arg0.population);
            return val != 0 ? val : stateName.compareTo(arg0.stateName);
        }
    }

}
