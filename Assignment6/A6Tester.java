/*
 * A6Tester.java
 *
 * A test program for Assignment 6.
 *
 * The auto grading of your assignment will include these tests
 *      with possibly different values.
 *
 */
public class A6Tester {

    private static int testPassCount = 0;
    private static int testCount = 0;
    public static int  stressTestSize = 2000;

    public static String listType = "recursive";

    public static void main (String[] args) {
        // updates listType command line argument is passed
        if (args.length == 1)
            listType = args[0];

        try {
            listTestOne();
            testToStringReverse();
            testGetAtPosition();
            testRemoveAtPosition();
            testSumMultiplesOf();
            testMultiplyBy();
            testRemoveValue();
            testGetMax();
            listStressTest();

        } catch (Exception e) {
            System.out.println("Your code threw an Exception.");
            System.out.println("Perhaps a stack trace will help:");
            e.printStackTrace(System.out);

        }
        System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
    }



    /*
     *
     * Purpose: increases testCount,
     *   if passed is true - increases testPassCount and prints Passed test
     *   if passed is false - prints Failed test and line number of failure
     *
     * Parameters: boolean passed, String testName
     *
     * Returns: nothing
     *
     */
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

    /*
     *
     * Purpose: creates and returns a new IntegerList.
     *    The type of list created is dependent on value of listType
     *
     * Parameters: none
     *
     * Returns: IntegerList - the new list or null if listType invalid
     *
     */
     public static IntegerList createList() {

         if (listType.equals("recursive")){
             return new RecursiveIntegerLinkedList();
         } else {
             System.out.println("list type specified not supported");
             return null;
         }
     }

    /*
     *
     * Purpose: adds elements in a to l
     *    adds to back of l if addBack is true, otherwise adds to front of l
     *
     * Parameters: int[] a, IntegerList l, boolean addBack
     *
     * Returns: nothing
     *
     */
    private static void addArray (int[] a, IntegerList l, boolean addBack) {
        for (int i=0;i<a.length;i++) {
            if (addBack)
                l.addBack(a[i]);
            else
                l.addFront(a[i]);
        }
    }

    public static void listTestOne() {
        System.out.println("testing addFront, addBack, size, getAtPosition");
        IntegerList list = createList();

        displayResults(list.size() == 0, "list constructor, size");
        list.addFront(4);

        displayResults(list.size() == 1, "list constructor + add 1 element");
        list.addFront(7);

        displayResults(list.size() == 2, "list constructor + add 1 element");
        displayResults(list.getAtPosition(0) == 7, "list get 2 element list");
        displayResults(list.getAtPosition(1) == 4, "list get 2 element list");

        list.addBack(11);
        list.addBack(23);
        list.addFront(15);
        displayResults(list.size() == 5, "list size + addFront+ addBack - 5 elements");

        displayResults(list.getAtPosition(0) == 15, "list get 5 element list");
        displayResults(list.getAtPosition(1) == 7, "list get 5 element list");
        displayResults(list.getAtPosition(2) == 4, "list get 5 element list");
        displayResults(list.getAtPosition(3) == 11, "list get 5 element list");
        displayResults(list.getAtPosition(4) == 23, "list get 5 element list");

        list = createList();
        list.addBack(11);
        list.addBack(23);
        displayResults(list.size() == 2, "list size + addBack - 2 elements");
        displayResults(list.getAtPosition(0) == 11, "list get 2 element list");
        displayResults(list.getAtPosition(1) == 23, "list get 2 element list");

        list.addFront(15);
        displayResults(list.size() == 3, "list size + addBack + addFront - 3 elements");
        displayResults(list.getAtPosition(0) == 15, "list get 3 element list");
        displayResults(list.getAtPosition(1) == 11, "list get 3 element list");
        displayResults(list.getAtPosition(2) == 23, "list get 3 element list");

    }

    public static void testToStringReverse() {
        System.out.println("testing list order using toString and reverse");
        IntegerList list1 = createList();
        list1.addFront(4);
        list1.addFront(7);
        list1.addBack(11);
        list1.addBack(23);
        list1.addFront(15);

        IntegerList list2 = createList();
        list2.addBack(11);
        list2.addBack(23);
        list2.addFront(15);
        list2.addFront(14);
        list2.addBack(12);
        // uncomment these  statements if tests are failing to see list state
               System.out.println("list1 fwd: " + list1);
               System.out.println("list1 rev: " + list1.reverse());
               System.out.println("list2 fwd: " + list2);
               System.out.println("list2 rev: " + list2.reverse());

        displayResults(list1.toString().equals("15 7 4 11 23"),
                       "using addBack + addFront to test toString");
        displayResults(list2.toString().equals("14 15 11 23 12"),
                       "using addBack + addFront to test toString");

        displayResults(list1.reverse().equals("23 11 4 7 15"),
                       "using addBack + addFront to test toString");
        displayResults(list2.reverse().equals("12 23 11 15 14"),
                       "using addBack + addFront to test toString");

    }

    public static void testGetAtPosition() {

        System.out.println("List testing: add, getAtPosition");

        IntegerList list = createList();
        list.addFront(34);

        displayResults((list.size() == 1) && (list.getAtPosition(0) == 34),
                       "addFront + size +getAtPosition, 1 element list");

        list.addFront(22);
        list.addBack(13);

        displayResults((list.size() == 3)
                       && (list.getAtPosition(0) == 22)
                       && (list.getAtPosition(2) == 13),
                       "addFront, addBack + size + getAtPosition, 3 element list");

        list.addBack(2);
        list.addBack(3);

        displayResults((list.size() == 5)
                       && (list.getAtPosition(0) == 22)
                       && (list.getAtPosition(3) == 2
                       && (list.getAtPosition(4) == 3)),
                       "addFront, addBack + size + getAtPosition, 3 element list");

    }

    public static void testRemoveAtPosition() {

        System.out.println("List testing: add, removeAtPosition");

        IntegerList list = createList();
        list.addFront(34);
        list.removeAtPosition(0);

        displayResults(list.size() == 0
                       && list.toString().equals("")
                       && list.reverse().equals(""),
                       "addFront+removeAtPosition + size, 1 element list");

        list.addBack(22);
        list.addBack(13);
        list.addBack(2);
        list.addBack(3);

        list.removeAtPosition(2);
        displayResults((list.size() == 3)
                       && (list.getAtPosition(0) == 22)
                       && (list.getAtPosition(1) == 13)
                       && (list.getAtPosition(2) == 3),
                       "addBack, removeAtPosition + size + getAtPosition, 4 element list");
        displayResults(list.toString().equals("22 13 3")
                       && list.reverse().equals("3 13 22"),
                       "addBack, removeAtPosition + toString, reverse, 4 element list");


        list.removeAtPosition(0);
        displayResults((list.size() == 2)
                       && (list.getAtPosition(0) == 13) && (list.getAtPosition(1) == 3),
                       "addBack, removeAtPosition + size + getAtPosition, 4 element list");
        displayResults(list.toString().equals("13 3") && list.reverse().equals("3 13"),
                        "addBack, removeAtPosition + toString, reverse, 4 element list");

        list.removeAtPosition(1);
        displayResults((list.size() == 1) && (list.getAtPosition(0) == 13),
                       "addBack, removeAtPosition + size + getAtPosition, 4 element list");
        displayResults(list.toString().equals("13") && list.reverse().equals("13"),
                        "addBack, removeAtPosition + toString, reverse, 4 element list");

    }


    public static void testSumMultiplesOf() {

        System.out.println("List testing: sumMultiplesOf");

        IntegerList emptyList = createList();

        int[] arrayAllMultiplesOf3 = {9, 3, -6, 18};
        IntegerList listAllMultiplesOf3 = createList();
        addArray(arrayAllMultiplesOf3, listAllMultiplesOf3, true);

        int sumResult;

        sumResult = emptyList.sumMultiplesOf(3);
        displayResults(sumResult == 0, "sumMultiplesOf, emptyList");

        sumResult = listAllMultiplesOf3.sumMultiplesOf(3);
        displayResults(sumResult == (9 + 3 + -6 + 18),
                       "sumMultiplesOf, all multiples");

        sumResult = listAllMultiplesOf3.sumMultiplesOf(5);
        displayResults(sumResult == 0, "sumMultiplesOf, no multiples");

        sumResult = listAllMultiplesOf3.sumMultiplesOf(9);
        displayResults(sumResult == (9 + 18), "sumMultiplesOf, some multiples");

        listAllMultiplesOf3.addBack(0);
        sumResult = listAllMultiplesOf3.sumMultiplesOf(3);
        displayResults(sumResult == (9 + 3 + -6 + 18 + 0),
                       "sumMultiplesOf, list contains 0 value");

        sumResult = listAllMultiplesOf3.sumMultiplesOf(0);
        System.out.println("expect: 0: " + sumResult);
        displayResults(sumResult == 0, "sumMultiplesOf, 0 is the only multiple of 0");


    }

    public static void testMultiplyBy() {

        System.out.println("List testing: multiplyBy");

        IntegerList emptyList = createList();

        int[] array4 = {9, 3, -6, 18};
        IntegerList list= createList();
        addArray(array4, list, true);
        
        list.duplicateNegative();
        System.out.println(list.toString());

        emptyList.multiplyBy(4);
        displayResults(emptyList.toString().equals("")
                       && emptyList.reverse().equals(""),
                       "multiplyBy emptyList");

        list.multiplyBy(2);
        displayResults(list.toString().equals("18 6 -12 36")
                       && list.reverse().equals("36 -12 6 18"),
                       "multiplyBy non empty list");

        list.multiplyBy(-1);
        displayResults(list.toString().equals("-18 -6 12 -36")
                       && list.reverse().equals("-36 12 -6 -18"),
                       "multiplyBy non empty list");

        list.multiplyBy(0);
        displayResults(list.toString().equals("0 0 0 0")
                       && list.reverse().equals("0 0 0 0"),
                       "multiplyBy non empty list");

        

    }


    public static void testGetMax() {

        System.out.println("List testing: getMax");

        IntegerList oneElement = createList();
        oneElement.addBack(9);

        int[] maxFront = {19, 3, -6, 18};
        IntegerList listMaxFront= createList();
        addArray(maxFront, listMaxFront, true);

        int[] maxMiddle = {19, 3, 24, -6, 18};
        IntegerList listMaxMiddle= createList();
        addArray(maxMiddle, listMaxMiddle, true);

        int[] maxEnd = {19, 3, 24, -6, 18, 92};
        IntegerList listMaxEnd= createList();
        addArray(maxEnd, listMaxEnd, true);

        int result;

        result = oneElement.getMax();
        displayResults(result == 9, "getMax one element list");

        result = listMaxFront.getMax();
        displayResults(result == 19, "getMax front of list");

        result = listMaxMiddle.getMax();
        displayResults(result == 24, "getMax middle of list");

        result = listMaxEnd.getMax();
        displayResults(result == 92, "getMax end of list");

    }

    public static void testRemoveValue() {

        System.out.println("IntegerList removeValue");

        IntegerList list = createList();
        list.removeValue(5);
        displayResults(list.size() == 0, "removeValue empty list");

        int num = 10;
        int p0 = num+0;
        int p1 = num+2;
        int p2 = num+1;
        int p3 = num+2;
        int p4 = num+1;
        int p5 = num+1;
        int p6 = num+4;
        int p7 = num+5;

        int[] vals = {p0, p1, p2, p3, p4, p5, p6, p7};
        addArray(vals, list, true);

        list.removeValue(p0);

        displayResults(list.size() == 7,
                       "removeValue one element at front");

        String sFwd = list.toString();
        String sRev = list.reverse();
        String foward = p1 + " " + p2 + " " + p3 + " " + p4 + " "  + p5 + " "  + p6 + " "  + p7;
        String reverse = p7 + " "  + p6 + " "  + p5 + " " + p4 + " " + p3 + " " + p2 + " "  + p1;
        displayResults(sFwd.equals(foward), "removeValue one element at front");
        displayResults(sRev.equals(reverse), "removeValue one element at front");

        list.removeValue(p7);
        displayResults(list.size() == 6, "removeValue one element at end");

        sFwd = list.toString();
        sRev = list.reverse();
        foward = p1 + " " + p2 + " " + p3 + " " + p4 + " "  + p5 + " "  + p6;
        reverse = p6 + " "  + p5 + " " + p4 + " " + p3 + " " + p2 + " "  + p1;
        displayResults(sFwd.equals(foward),
                       "removeValue one element at end");
        displayResults(sRev.equals(reverse),
                       "removeValue one element at end");


        list.removeValue(p2);

        displayResults(list.size() == 3,
                       "removeValue multiple elements not at ends");

        sFwd = list.toString();
        sRev = list.reverse();
        foward = p1 + " " + p3 + " " + p6;
        reverse = p6 + " " + p3 + " " + p1;
        displayResults(sFwd.equals(foward),
                       "removeValue multiple elements not at ends");
        displayResults(sRev.equals(reverse),
                       "removeValue multiple elements not at ends");


        list.removeValue(p6);

        displayResults(list.size() == 2, "removeValue 1 element at end");

        sFwd = list.toString();
        sRev = list.reverse();
        foward =  p1 + " " + p3;
        reverse = p3 + " " + p1;
        displayResults(sFwd.equals(foward), "removeValue 1 element at end");
        displayResults(sRev.equals(reverse), "removeValue 1 element at end");

        list.removeValue(p1);

        displayResults(list.size() == 0,
                       "removeValue multiple elements to make empty");

        sFwd = list.toString();
        sRev = list.reverse();
        foward = "";
        reverse = "";
        displayResults(sFwd.equals(foward),
                       "removeValue multiple elements to make empty");
        displayResults(sRev.equals(reverse),
                       "removeValue multiple elements to make empty");

        list.removeValue(5);
        displayResults(list.size() == 0, "removeValue empty list");

    }



    public static void listStressTest() {
        IntegerList list = createList();

        System.out.println("Stress test");
        // add num to the front and to the back of list
        for (int i=0;i<stressTestSize;i++) {
            list.addFront(i);
            list.addBack(i);
        }
        int numElements = stressTestSize * 2;
        displayResults(list.size() == numElements,
                       "added stressTestSize*2 elements");

        boolean passed = true;
        int num = 0;
        while (num<stressTestSize && passed) {

            if ( list.getAtPosition(num) != ((stressTestSize-1) - num) ) {
                passed = false;
            }

            if ( list.getAtPosition(num+stressTestSize) != num ) {
                passed = false;
            }
            num++;
        }
        displayResults(passed, "getAtPosition stressTestSize*2 elements");



        passed = true;
        num = 0;
        while (num<stressTestSize && passed) {
            // should remove both occurances of num
            list.removeValue(num);
            numElements -= 2;

            if (list.size() != numElements)
                passed = false;

            if (find(list, num))
                passed = false;
            num++;
        }
        displayResults(passed, "remove + getAtPosition stressTestSize values");
        displayResults(list.size() == 0, "removed stressTestSize*2 elements");

    }

    /* find
     *
     * Purpose: determines whether elements is contained in list
     *
     * Parameters: IntegerList list, int element
     *
     * Returns: boolean - true if element is found in list, false otherwise
     *
     */
    private static boolean find(IntegerList list, int element) {
        int position = 0;

        while (position<list.size() && element!=list.getAtPosition(position)) {
            position++;
        }

        return position < list.size();
    }
}
