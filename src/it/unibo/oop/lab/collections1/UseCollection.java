package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int ZERO = 0;
    private static final int DIM_EL = 1;
	private static final int ELEMS = 100000;
	private static final int TO_MS = 1000000;
	private static final int TIMES = 1000;

	private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	final List<Integer> alist = new ArrayList<>();
    	
    	for (int i = 1000; i < 2000; i++) {
    		alist.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	final LinkedList<Integer> llist = new LinkedList<>();
    	
    	llist.addAll(alist);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */    	
    	int tmp = alist.get(alist.size() - DIM_EL);
    	alist.set(alist.size() - DIM_EL, alist.get(ZERO));
    	alist.set(ZERO, tmp);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for(Integer i : alist) {
    		System.out.print(i + " ");
    	}
    	System.out.println("");
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	//arraylist
    	 long time = System.nanoTime();

         for (int i = 1; i <= ELEMS; i++) {
             alist.add(ZERO, i);
         }

         time = System.nanoTime() - time;
         System.out.println("Adding " + ELEMS
                 + " elements at the beginning of the Arraylist " + time
                 + "ns (" + time / TO_MS + "ms)");
         //System.out.println(alist);
         
         //linkedlist
    	 time = System.nanoTime();

    	 for (int i = 1; i <= ELEMS; i++) {
             llist.addFirst(i);
         }

         time = System.nanoTime() - time;
         System.out.println("Adding " + ELEMS
                 + " elements at the beginning of the  Linkedlist " + time
                 + "ns (" + time / TO_MS + "ms)");
         //System.out.println(alist);
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
         
       //arraylist
    	 time = System.nanoTime();

    	 for (int i = 0; i < TIMES; i++) {
             alist.get(alist.size()/2);
         }

         time = System.nanoTime() - time;
         System.out.println("Reading " + TIMES
                 + " times an element in the middle of the Arraylist " + time
                 + "ns (" + time / TO_MS + "ms)");
         //System.out.println(alist);
         
         //linkedlist
    	 time = System.nanoTime();

         
         for (int i = 0; i < TIMES; i++) {
        	 llist.get(alist.size()/2);
         }

         time = System.nanoTime() - time;
         System.out.println("Reading " + TIMES
                 + " times an element in the middle of the Linkedlist " + time
                 + "ns (" + time / TO_MS + "ms)");
         //System.out.println(alist);
 /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
         
         final Map <String, Integer> continents = new HashMap<>();
         continents.put("Africa", 1110635000);
         continents.put("America", 972005000);
         continents.put("Antarctica", 0);
         continents.put("Asia", 429872300); //come fare??
         continents.put("Europe", 742452000);
         continents.put("Oceania", 38304000);
         
        /*
         * 8) Compute the population of the world
         */
         long populationTot = 0;
         for(final Integer i : continents.values()) {
        	 populationTot += (long)i;
         }
         System.out.println(populationTot);
    }
}
