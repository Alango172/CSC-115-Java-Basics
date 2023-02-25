/*
 * Lab2Tester.java
 *
 * A tester for the methods in Lab2.java
 *
 */
import java.util.Arrays;

public class L2Grader {

    private static int testPassCount = 0;
    private static int testCount = 0;


    // for approximate comparison of floating point numbers
    private static final double THRESHOLD = 0.01;

    public static void main(String[] args) {

        testGetHigherGradeStudent();
        testIsGradeAbove();
        testGetClasslist();
        testCountAbove();
        testGetClassAverage();
        testRegisterStudent();

        System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }

    public static void displayResults (boolean passed, String testName)
    {
        /* There is some magic going on here getting the line number
         * Borrowed from:
         * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
         */

        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }

    }

    public static void testGetHigherGradeStudent() {
        // ToDo: once you have completed your getHigherGradeStudent in Lab2.java
        //  uncomment the following tests - make sure you understand what they are testing

        /*
         Student s0  = new Student("abc", 50);
         Student s1a = new Student("def", 56);
         Student s1b = new Student("xyz", 56);
         Student s2  = new Student("xyz", 99);

         Student result;

         result = Lab2.getHigherGradeStudent(s0,s1a);
         //System.out.println("should be  " + s1a + " is " + result);
         displayResults(result.equals(s1a), "testGetHigherGradeStudent");

         result = Lab2.getHigherGradeStudent(s1a,s0);
         //System.out.println("should be  " + s1a + " is " + result);
         displayResults(result.equals(s1a), "testGetHigherGradeStudent");

         result = Lab2.getHigherGradeStudent(s1b,s1a);
         //System.out.println("should be  " + s1b + " is " + result);
         displayResults(result.equals(s1b) && result == s1b, "testGetHigherGradeStudent");

         result = Lab2.getHigherGradeStudent(s1b,s2);
         //System.out.println("should be  " + s2 + " is " + result);
         displayResults(result.equals(s2), "testGetHigherGradeStudent");
         */

    }

    public static void testIsGradeAbove() {
        // ToDo: write tests for isGradeAbove in Lab2.java

        Student s0  = new Student("abc", 50);
        Student s1 = new Student("def", 56);
        Student s2  = new Student("xyz", 99);

        boolean result;
        try{
        result = Lab2.isGradeAbove(s0, 20);
        displayResults(result, "testIsGradeAbove - true");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }
        try{
        result = Lab2.isGradeAbove(s0, 30);
        displayResults(result, "testIsGradeAbove - true");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }
        try{
        result = Lab2.isGradeAbove(s0, 56);
        displayResults(!result, "testIsGradeAbove - false");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }
        try{
        result = Lab2.isGradeAbove(s0, 70);
        displayResults(!result, "testIsGradeAbove - false");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }        
    }

    public static void testGetClasslist() {
        // ToDo: write tests for getClasslist in Lab2.java

        // NOTE: the Arrays library has been imported for you.
        //  you can use the Arrays.equals method to compare
        //  2 arrays of String objects as String has a equals method
        // The API for Arrays.equals:
        //  equals(Object[] a, Object[] a2)
        //  Returns true if the two specified arrays of Objects are equal to one another.

        Student s0  = new Student("abc", 50);
        Student s1 = new Student("def", 56);
        Student s2  = new Student("xyz", 99);

        Student[] studentsMT = {};
        Student[] students1 = {s0};
        Student[] students3 = {s0, s1, s2};
        String[] expectedMT = {};
        String[] expected1 = {"abc"};
        String[] expected3 = {"abc", "def", "xyz"};

        String[] result;
        try{
        result = Lab2.getClasslist(studentsMT);
        displayResults(Arrays.equals(result, expectedMT), "testGetClasslist - empty");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 

        try{
        result = Lab2.getClasslist(students1);
        displayResults(Arrays.equals(result, expected1), "testGetClasslist - 1 elements");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 

        try{
        result = Lab2.getClasslist(students3);
        displayResults(Arrays.equals(result, expected3), "testGetClasslist - 3 elements");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }         

    }


    public static void testCountAbove() {
        // ToDo: write tests for countAbove in Lab2.java

        Student s0  = new Student("abc", 50);
        Student s1 = new Student("def", 56);
        Student s2  = new Student("xyz", 99);

        Student[] studentsMT = {};
        Student[] students1 = {s0};
        Student[] students3 = {s0, s1, s2};

        int result;
        try{
        result = Lab2.countAbove(studentsMT, 20);
        displayResults( result == 0, "testCountAbove - empty");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }
        try{
        result = Lab2.countAbove(students1, 40);
        displayResults( result == 1, "testCountAbove - count all");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }
        try{
        result = Lab2.countAbove(students3, 40);
        displayResults( result == 3, "testCountAbove - count all");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }
        try{
        result = Lab2.countAbove(students3, 99);
        displayResults( result == 0, "testCountAbove - count none");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }
        try{
        result = Lab2.countAbove(students3, 56);
        displayResults( result == 1, "testCountAbove - count some");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        }        
    }



    public static void testGetClassAverage() {
        // ToDo: write tests for getClassAverage in Lab2.java

        Student s0  = new Student("abc", 50);
        Student s1 = new Student();
        Student s2  = new Student("xyz", 99);
        Student s3 = new Student("def", 88);


        Student[] studentsMT = {};
        Student[] students1 = {s0};
        Student[] students3Some = {s0, s1, s2};
        Student[] students3All = {s0, s2, s3};
        double expectedMT = 0;
        double expected1 = 50.0;
        double expected3Some = (50 + 99) / 2.0;
        double expected3All = (50 + 99 + 88) / 3.0;

        double result;
        try{
        result = Lab2.getClassAverage(studentsMT);
        displayResults(Math.abs(result-expectedMT) < THRESHOLD, "testGetClasslist - empty");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 
        try{
        result = Lab2.getClassAverage(students1);
        displayResults(Math.abs(result-expected1) < THRESHOLD, "testGetClasslist - 1 student");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 
        try{
        result = Lab2.getClassAverage(students3Some);
        displayResults(Math.abs(result-expected3Some) < THRESHOLD, "testGetClasslist - 3 students, count 2");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 
        try{
        result = Lab2.getClassAverage(students3All);
        displayResults(Math.abs(result-expected3All) < THRESHOLD, "testGetClasslist - 3 students, count 3");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 
    }

    public static void testRegisterStudent() {
        // ToDo: write tests for registerStudent in Lab2.java

        Student s0  = new Student("abc", 50);
        Student s1  = new Student();
        Student s2  = new Student("xyz", 99);
        Student s3  = new Student("def", 88);


        Student[] studentsMT = {};
        Student[] students1 = {s0};
        Student[] students3 = {s0, s1, s3};
        Student[] expectedMTs0 = {s0};
        Student[] expected1s1 = {s0, s1};
        Student[] expected3s3 = {s0, s1, s2, s3};

        Student[] result;
        try{
        result = Lab2.registerStudent(studentsMT, s0);
        displayResults(containSameElements(result, expectedMTs0), "testGetClasslist - empty");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 
        try{
        result = Lab2.registerStudent(students1, s1);
        displayResults(containSameElements(result, expected1s1), "testGetClasslist - one element");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 
        try{
        result = Lab2.registerStudent(students3, s2);
        displayResults(containSameElements(result, expected3s3), "testGetClasslist - 3 elements");
        }catch(Exception e){
            displayResults(false,"fatal exception thrown");
        } 
    }

    /*
     *
     * Purpose: determines whether a1 and a2 contain equal elements
     *    ignoring order
     *
     * Parameters: Student[] a1, Student[] a2
     *
     * Returns: boolean - true if a1 and a2 contain equal elements, false otherwise
     *
     */
    public static boolean containSameElements(Student[] a1, Student[] a2) {
        if (a1.length != a2.length) {
            return false;
        }

        for (int i=0; i<a1.length; i++) {
            if (!contains(a2, a1[i])) {
                return false;
            }
        }
        return true;
    }

    /*
     *
     * Purpose: determines whether array contains element equal to s
     *
     * Parameters: Student[] array, Student s
     *
     * Returns: boolean - true if array contains s, false otherwise
     *
     */
    public static boolean contains(Student[] array, Student s) {
        for (int i=0; i<array.length; i++) {
            if (array[i].equals(s)) {
                return true;
            }
        }
        return false;
    }
}
