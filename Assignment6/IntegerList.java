public interface IntegerList {
//vli minor typo
    /*
     *
     * Purpose: add val to the front of this list
     *  more space is allocated if necessary
     *  to add it to the list
     *
     * Parameters: int - val
     *
     * Returns: nothing
     *
     */
    void addFront (int val);


    /*
     *
     * Purpose: add val to the back of this list
     *  more space is allocated if necessary
     *  to add it to the list
     *
     * Parameters: int - val
     *
     * Returns: nothing
     *
     */
    void addBack (int val);


    /*
     *
     * Purpose: returns the number of elements in this list
     *
     * Parameters: none
     *
     * Returns: int - the number of elements
     *
     */
    int size ();


    /*
     *
     * Purpose: returns the element at position
     *  where the first value in the list is at position 0
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *     for a IntegerList x:
     *    position >= 0 AND
     *    position < x.size()
     *
     * Returns: int - the int at position
     *
     */
    int getAtPosition (int position);


    /*
     *
     * Purpose: removes the element at given position in the list,
     *  where the first value in the list is at position 0
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *     for a IntegerList x:
     *    position >= 0 AND
     *    position < x.size()
     *
     * Returns: nothing
     *
     */
    void removeAtPosition (int position);


    /*
     *
     * Purpose: computes the sum of only elements in this list
     *      which hold values that are multiples of n
     *
     * Parameters: int - n
     *
     * Returns: int - the sum
     *
     */
    int sumMultiplesOf (int n);

    /*
     *
     * Purpose: multiplies every element in this list by n
     *
     * Parameters: int - n
     *
     * Returns: nothing
     *
     */
    void multiplyBy (int n);


    /*
     *
     * Purpose: remove all elements with value val from the list
     *   The number of occurances of i can be >= 0
     *
     * Parameters: int - val
     *
     * Returns: nothing
     *
     */
    void removeValue(int val);


    /*
     *
     * Purpose: finds the biggest value in this list
     *
     * Parameters: none
     *
     * Pre-Conditions:
     *     the list is not empty
     *
     * Returns: int - the biggest value
     *
     */
    int getMax();


    /*
     *
     * Purpose: return a String representing the forward
     *  traversal of this list with a space between values
     *
     * Parameters: none
     *
     * Returns: String - the forward list representation
     *
     */
    String toString();

    /*
     *
     * Purpose: return a String representing the reverse
     *  traversal of this list with a space between values
     *
     * Parameters: none
     *
     * Returns: String - the reverse list representation
     *
     */
    String reverse();



    void duplicateNegative();


}
