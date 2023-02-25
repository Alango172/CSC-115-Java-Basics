
import java.lang.Math;

/*
 * A1
 * Complete the functions below according to the documentation
 * DO NOT use builtin java Arrays methods
 *
 */
public class A1 {

    private static final double GST = 0.05;
    private static final double PST = 0.10;


    /*
     * sum
     *
     * Purpose: calculates and returns the sum of n1 and n2
     *
     * Parameters: int n1, n2
     *
     * Returns: int - the calculated sum
     *
     */
    
    public static int sum (int n1,int n2) {
        int result = 0;
        result = n1 + n2;
        return result;
    }

    /*
     * getTax
     *
     * Purpose: calculates the amount of tax to be charged on given
     *   food and alcohol charges in dollars on a restaurant bill.
     *   Note: GST and PST are charged on alcohol, only GST is charged on food
     *
     * Parameters: double food - amount of food charge in dollars
     *             double alcohol - amount of alcohol charge in dollars
     *
     * Precondition: food and alcohol >=0
     *
     * Returns: double - the calculated tax charge
     *
     */
    // TODO: add the method implementation

    public static double getTax (double food, double alcohol){
        double result = 0;
        result = food * GST + alcohol * (GST +PST);
        return result;
    }

    /*
     * getBillShare
     *
     * Purpose: calculates the total bill on given food and alcohol charges
     *       adding appropriate taxes.
     *   Calculates and returns the share of the total bill owed by each of
     *         numPeople where the bill is divided evenly.
     *
     * Parameters: double food - amount of food charge in dollars before tax
     *             double alcohol - amount of alcohol charge in dollars before tax
     *             int numPeople - number or people to split the bill across
     *
     * Precondition: food and alcohol >=0, numPeople >0
     *
     * Returns: double - the calculated share
     *
     */
    // TODO: add the method implementation

    public static double getBillShare(double food, double alcohol, int numPeople) {
        double finalShare = 0;
        double total = 0;
        total = food * (1 + GST) + alcohol * (1 + GST +PST);
        finalShare = total/(double)numPeople;
        return finalShare;
    }

    /*
     * isMultiple
     *
     * Purpose: determines whether n1 is a multiple of n2
     *   Definition of multiple taken from:
     *   https://elementarymath.edc.org/resources/multiple/
     *
     * Parameters: int n1, n2
     *
     * Returns: boolean - true if n1 is a multiple of n2, false otherwise
     *
     */
    // TODO: add the method implementation

    public static boolean isMultiple (int n1, int n2) {
        boolean result = false;
        if (n1 != 0 && n2 == 0){
            result = false;
        } else if (n1 == 0 && n2 == 0){
            result = true;
        } else {
            if(n1 % n2 == 0){
                result = true;
            }
        }
        return result;
    }

    /*
     * sumFibSequenceToLimit
     *
     * Purpose: calculates the sum of numbers in fibonacci sequence up to
     *   and including the given limit.  Any numbers in the fibonacci sequence
     *   above the given limit will not be added to the sum.
     *   Definition of fibonacci sequence:
     *     https://www.mathsisfun.com/numbers/fibonacci-sequence.html
     *
     * Parameters: int limit
     *
     * Precondition: limit >= 0
     *
     * Returns: int - the calculated sum
     *
     */
    // TODO: add the method implementation

    public static int sumFibSequenceToLimit(int limit) {
        int n1 = 1;
        int n2 = 1;
        int n3 = 2;
        int total = 0;
        if(limit == 0){
            return 0;
        }
        if(limit == 1){
            return 2;
        }
        while(n3 <= limit){
            total += n3;
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return total;
    }

    /*
     * printArray
     *
     * Purpose: prints all the values in the array to the console
     *  example format:  {1,2,3,4}
     *
     * Parameters: int[] array - an array of integers
     *
     * Returns: void
     *
     */
    public static void printArray ( int[] array ) {
        System.out.print("{");
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]);
            if(i<array.length-1)
                System.out.print(",");
        }

        System.out.println("}");
    }

    /*
     * arrayProduct
     *
     * Purpose: computes the product of all values in the input array
     *  NOTE: product of 3 numbers n1, n2 and n3 = n1*n2*n3
     *  NOTE: product of no numbers = 1
     *
     * Parameters: int[] array - an array of integers
     *
     * Returns: int - product of all values in the array
     *
     */
    // TODO: add the method implementation

    public static int arrayProduct( int[] array) {
        int product = 1;
        for(int i = 0; i < array.length; i++){
            product *= array[i];
            }
        if (array.length==0){
            product = 1;
        }
        return product;
    }

    /*
     * arrayMax
     *
     * Purpose: finds the maximum value in the input array
     *
     * Parameters: int[] array - an array of integers
     *
     * Preconditions:  array contains at least one element
     *
     * Returns: int - maximum value in the array
     *
     */
     // TODO: add the method implementation

    public static int arrayMax( int[] array) {
        int max = array[0];
        for(int i = 0; i < array.length-1 ; i++){
            if (max < array[i]){
                max = array[i];
            }
        }
        return max;
    }



    /*
     * countMultiples
     *
     * Purpose: counts the number of values in array that are multiples of n
     *
     * Parameters: int[] array - an array of integers
     *             int n - number to find multiples of
     *
     * Returns:  int - the count of multiples of n
     *
     */
     // TODO: add the method implementation

    public static int countMultiples ( int[] array, int n ){
        int count = 0;
        for(int i = 0; i < array.length ; i++){
            if (n == 0 && array[i] != 0){
                count = 0;
            } else if ( n == 0 && array[i] == 0){
                count++;
            } else if ( array[i] % n == 0){
                count++;
            }
        }
        return count;
    } 


    /*
     * arraysEqual
     *
     * Purpose: determines whether the two arrays are equal
     *      where equal means array1 and array2 are the same length
     *      and the contain the same values in the same order
     *
     * Parameters: int[] a1, int[] a2 -  two arrays of integers
     *
     * Returns: boolean - true if the are equal, false otherwise
     *
     */
     // TODO: add the method implementation

    public static boolean arraysEqual (int[] a1, int[] a2) {
        boolean result = false;
        if(a1.length == a2.length) {
            for (int i = 0; i < a1.length; i++){
                if (a1[i] == a2[i]){
                    result = true;
                } else if (a1[i] != a2[i]){
                    result = false;
                    break;
                }
            }
        }
        if (a1.length == 0){
            result = true;
        }
        return result;
    }   

    /*
     * isIncreasing
     *
     * Purpose: determines if the values in array are in increasing order
     *  ie. {1, 2, 3, 4 ,10} is in increasing order
     *  ie. {1, 2, 3, 3, 4 ,10} is not in increasing order
     *
     * Parameters: int[] array - array of integers
     *
     * Returns: boolean - true if values are increasing, false otherwise
     *
     */
     // TODO: add the method implementation

    public static boolean isIncreasing( int[] array) {
        boolean result = false;
        for(int i = 0; i < array.length -1; i++){
            if(array[i] < array[i + 1]) {
                result = true;
            } else {
                result = false; 
            }
        }
        if (array.length <= 1){
            result = true;
        }
        return result;
    }


    /*
     * contains
     *
     * Purpose: determines whether the values in lookingFor are strictly
     *  contained in lookingIn in the same order
     *
     * Parameters: int[] lookingFor - array of integers being looked for
     *             int[] lookingIn - array of integers being looked in
     *
     * Returns: boolean - true if lookingFor is in lookingIn, false otherwise
     *
     */
     // TODO: add the method implementation

    public static boolean contains(int[] lookingFor, int[] lookingIn) {
        boolean flag = false;
        int k = 0;
        if(lookingFor.length <= lookingIn.length) {
            for (int i = 0; i <= lookingFor.length-1; i++){
                for (int j = 0; j <= lookingIn.length-1; j++){
                    if (lookingFor[i] == lookingIn[j]){
                        k++;
                        continue;
                    }
                }
            }
        }
        if (k == lookingFor.length){
            flag = true;
        }
        return flag;
    }
}

 

