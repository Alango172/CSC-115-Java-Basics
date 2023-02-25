/*
 * A7Tester.java
 *
 *
 */

import java.io.*;
import java.util.List;
import java.util.LinkedList;

public class A7Tester
{
    private static int     testCount = 0;
    private static int     testPassCount = 0;

    public static void main (String[] args) {
        try	{
            testBasicStack();
            testTrains();

        } catch (Exception e) {
            System.out.println("Your code threw an Exception.");
            System.out.println("Perhaps a stack trace will help:");
            e.printStackTrace(System.out);
        }
        System.out.println ("Passed " + testPassCount + "/" + testCount + "tests");
    }

    public static void displayResults (boolean passed, String testName) {
        /* There is some magic going on here getting the line number
         * Borrowed from:
         * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
         */
        testCount++;
        if (passed) {
            System.out.println ("Passed test: " + testCount);
            testPassCount++;
        } else {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    public static void testBasicStack() {
        System.out.println("testBasicStack: start");

        Stack<Integer> s;
        int subtestSize;
        boolean subtestResult;

        // Test constructor, size and isEmpty
        s = new StackRefBased<Integer>();
        displayResults(s.isEmpty(), "isEmpty on empty stack");
        displayResults(s.size() == 0, "size on empty stack");

        s = new StackRefBased<Integer>();
        s.push(22);
        displayResults(!s.isEmpty(), "isEmpty - stack with one element");
        displayResults(s.size() == 1, "size - stack with one element");

        // Test constructor, size and isEmpty and push/pop
        try {
            s = new StackRefBased<Integer>();
            subtestSize = 10;
            for (int i = 0; i < subtestSize; i++) {
                s.push(i);
                
            }
            
            displayResults(!s.isEmpty(), "isEmpty - stack with multiple elements");
            displayResults(s.size() == subtestSize, "size - stack with multiple elements");
            System.out.println(s.toString());
            subtestResult = true;
            for (int i = subtestSize - 1; i >= 0; i--) {
                Integer ii = s.pop();
                subtestResult = subtestResult && (ii == i);
            }
            displayResults(subtestResult, "pop - stack with multiple elements");
            displayResults(s.isEmpty(), "isEmpty - after pop");
            displayResults(s.size() == 0, "size - after pop");
        }
        catch (StackEmptyException see) {
            displayResults(false, "exception thrown when it shouldn't be");
        }

        // Test constructor, size and isEmpty and push/peek one element
        try {
            s = new StackRefBased<Integer>();
            s.push(33);
            s.peek();
            displayResults( !s.isEmpty(), "push/peek + isEmpty - stack with one elements");
            displayResults(s.size() == 1, "push/peek + size - stack with one elements");
        }
        catch (StackEmptyException see) {
            displayResults(false, "exception thrown when it shouldn't be");
        }

        // Test pop/peek exceptions
        try {
            s = new StackRefBased<Integer>();
            s.pop();
            displayResults( false, "shouldn't get here - exception should be thrown");
            s.peek();
            displayResults( false, "shouldn't get here - exception should be thrown");
        }
        catch (StackEmptyException see) {
            displayResults(true, "exception should have been thrown");
        }

        // Test constructor, size and isEmpty and push/peek multiple elements
        try {
            s = new StackRefBased<Integer>();
            subtestSize = 10;
            for (int i = 0; i < subtestSize; i++) {
                s.push(i);
            }
            displayResults(!s.isEmpty(), "push + isEmpty");
            displayResults(s.size() == subtestSize, "push + size");
            subtestResult = true;
            for (int i = subtestSize - 1; i >= 0; i--) {
                Integer ii = s.peek();
                subtestResult = subtestResult && (ii == (subtestSize - 1));
            }
            displayResults(subtestResult, "push + peek");
            displayResults(!s.isEmpty(), "push + peek + isEmpty");
            displayResults(s.size() == subtestSize, "push + peek + size");
        }
        catch (StackEmptyException see) {
            displayResults(false, "exception thrown when it shouldn't be");
        }

        // Test constructor, push, makeEmpty, isEmpty
        s = new StackRefBased<Integer>();
        subtestSize = 10;
        for (int i = 0; i < subtestSize; i++) {
            s.push(i);
        }
        s.makeEmpty();
        displayResults( s.isEmpty(), "makeEmpty + isEmpty - stack with multiple elements");

        s = new StackRefBased<Integer>();
        subtestSize = 10;
        for (int i = 0; i < subtestSize; i++) {
            s.push(i);
        }
        s.makeEmpty();
        for (int i = 0; i < subtestSize; i++) {
            s.push(i);
        }
        displayResults(!s.isEmpty(), "makeEmpty + push + isEmpty - stack with multiple elements");
        displayResults(s.size() == subtestSize, "makeEmpty + push + size - stack with multiple elements");

        // Test constructor, push, makeEmpty, isEmpty
        try {
            s = new StackRefBased<Integer>();
            subtestSize = 10;
            for (int i = 0; i < subtestSize; i++) {
                s.push(i);
            }
            s.makeEmpty();
            for (int i = 0; i < subtestSize; i++) {
                s.push(i);
            }
            displayResults(s.peek() == (subtestSize - 1), "makeEmpty + push + peek - stack with multiple elements");
            s.pop();
            displayResults(s.peek() == (subtestSize - 2), "makeEmpty + push + pop + peek - stack with multiple elements");
        }
        catch (StackEmptyException see) {
            displayResults(false, "exception thrown when it shouldn't be");
        }

        System.out.println("testBasicStack: end");
        System.out.println();
    }

    public static void testTrains() {
        System.out.println("testTrains: start");

        int[] railway0 = {1,2,3,4,5};	//true
        int[] railway1 = {5,4,3,2,1};	//true
        int[] railway2 = {1,3,5,4,2};	//true
        int[] railway3 = {4,3,5,1,2};	//false  - cannot do with only one spur
        int[] railway4 = {1,4,4,2,3}; 	//false  - duplicate entry
        int[] railway5 = {1,5,2,3,6};	//false	 - wrong entry
        int[] railway6 = {5,4,7,8,6,3,2,1};  //true  - can do with one spur
        int[] railway7 = {6,5,4,3,2};	//false - highest number > number of cars


        // arrays containing CarMove pairs.
        String expected0[] = {"in","out","in","out","in","out","in","out","in","out"};
        String expected1[] = {"in","spur","in","spur","in","spur","in","spur",
                "in","out","spur","out","spur","out","spur","out","spur","out"};
        String expected2[] = {"in","spur","in","spur","in","out","spur","out",
                             "in","out","spur","out","in","out"};
        String expected6[] = {"in","spur","in","spur","in","spur","in","spur",
                "in","out","in","out","spur","out","in","spur","in","out",
                "spur","out","spur","out","spur","out","spur","out"};

        // lists and variable to be used for tests:
        List<Integer> cars = new LinkedList<Integer>();
        List<CarMove> resultList = new LinkedList<CarMove>();
        List<CarMove> expectedList = new LinkedList<CarMove>();
        boolean returnedValue;

        cars.clear();
        resultList.clear();
        expectedList.clear();
        addIntegers(cars, railway0);
        addMoves(expectedList, expected0);
        returnedValue = Solver.reorderTrains(cars, resultList);
        displayResults(returnedValue, "railway0 should be true");
        displayResults(resultList.equals(expectedList), "CarMoves should match");
        // TESTS not passing? Print out the resultList and expectedList to compare:
        System.out.println(resultList);
        System.out.println(expectedList);

        cars.clear();
        resultList.clear();
        expectedList.clear();
        addIntegers(cars, railway1);
        addMoves(expectedList, expected1);
        returnedValue = Solver.reorderTrains(cars, resultList);
        displayResults(returnedValue, "railway1 should be true");
        displayResults(resultList.equals(expectedList), "CarMoves should match");
        System.out.println(resultList);
        System.out.println(expectedList);

        cars.clear();
        resultList.clear();
        expectedList.clear();
        addIntegers(cars, railway2);
        addMoves(expectedList, expected2);
        returnedValue = Solver.reorderTrains(cars, resultList);
        displayResults(returnedValue, "railway2 should be true");
        displayResults(resultList.equals(expectedList), "CarMoves should match");
        System.out.println(resultList);
        System.out.println(expectedList);

        cars.clear();
        resultList.clear();
        addIntegers(cars, railway3);
        returnedValue = Solver.reorderTrains(cars, resultList);
        displayResults(!returnedValue, "railway3 should be false");

        cars.clear();
        resultList.clear();
        addIntegers(cars, railway4);
        returnedValue = Solver.reorderTrains(cars, resultList);
        displayResults(!returnedValue, "railway4 should be false");

        cars.clear();
        resultList.clear();
        addIntegers(cars, railway5);
        returnedValue = Solver.reorderTrains(cars, resultList);
        displayResults(!returnedValue, "railway5 should be false");

        cars.clear();
        resultList.clear();
        expectedList.clear();
        addIntegers(cars, railway6);
        addMoves(expectedList, expected6);
        returnedValue = Solver.reorderTrains(cars, resultList);
        displayResults(returnedValue, "railway6 should be true");
        displayResults(resultList.equals(expectedList), "CarMoves should match");
        System.out.println(resultList);
        System.out.println(expectedList);

        cars.clear();
        resultList.clear();
        addIntegers(cars, railway7);
        returnedValue = Solver.reorderTrains(cars, resultList);
        displayResults(!returnedValue, "railway7 should be false");

        System.out.println("testTrains: end");
    }

    /*
     * Purpose: creates a CarMove from each 2-element pair in movePairs and
     *       adds them to the given list.
     * Parameters: List<CarMove> list, String[] movePairs
     * Preconditions: list and movePairs are not null.
     *    movePair contains an even number of elements ordered in pairs with
     *    a valid CarMove location followed by a valid CarMove destination
     * Returns: void
     */
    public static void addMoves(List<CarMove> list, String[] movePairs) {
        for(int i=0; i<movePairs.length; i+=2) {
            list.add(new CarMove(movePairs[i], movePairs[i+1]));
        }
    }

    /*
     * Purpose: adds each int in array to list
     * Parameters: List<CarMove> list, String[] movePairs
     * Preconditions: list and array are not null.
     * Returns: void
     */
    public static void addIntegers(List<Integer> list, int[] array) {
        // Java's for each loop
        // with each iteration val gets updated to the next element in the array
        for(int val: array)
            list.add(val);
    }


}
