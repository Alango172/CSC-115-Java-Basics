/*
 * PriorityQueue.java
 *
 * A priority queue interface for objects that implement the
 * Comparable interface.
 *
 * This interface considers the maximum value to be the highest priority.
 *
 * This interface isn't using generic Comparable objects because
 * one cannot (easily) create an array of a generic type in Java.
 * Generics only have compile time type checking whereas
 * arrays support runtime type checking.
 *
 * This results in compiler warnings on calls to compareTo in the
 *   linked and heap implementations that can be ignored.
 *
 * It also allows people to incorrectly insert objects of different types into
 * the same PriorityQueue.  This programming error will result in exceptions
 * being thrown at run-time.
 *
 * It is up to the programmer to only insert objects of ONE
 * type into an instance of the PriorityQueue.
 */

 public interface PriorityQueue {

    /*
     * Purpose:
     *    Adds element into the PriorityQueue at the position
     *    according to the element's priority.
     *
     * Parameters:
     *    Comparable element
     *
     * Preconditions:
     *    None.
     *
     * Returns:
     *    void
     *
     * Examples:
     *     If q contains elements that would be accessed in the
     *     following order:  {5,3,1} after q.insert(2) returns,
     *     then q will contain elements that will be accessed
     *     in the following order: {5,3,2,1}.
     *
     */
     public void insert ( Comparable element );


     /*
     * Purpose:
     *    Remove highest priority element from the PriorityQueue,
     *    where the maximum value will be of highest priority.
     *
     * Parameters:
     *    None.
     *
     * Preconditions:
     *    None.
     *
     * Returns:
     *    a Comparable object with the highest priority
     *
     * Examples:
     *     If q contains elements that would be accessed in the
     *     following order:  {5,3,1},  q.removeHigh() returns 5,
     *     and then q will contain elements that will be accessed
     *     in the following order: {3,1}.
     *
     * Throws: QueueEmptyException if called on empty Queue
     */
    public Comparable removeHigh () throws QueueEmptyException;


    /*
     * Purpose:
     *    Determines if the PriorityQueue is empty or not.
     *
     * Parameters:
     *    None.
     *
     * Preconditions:
     *    none
     *
     * Returns:
     *    boolean - true if PriorityQueue is empty, false otherwise.
     *
     */
    public boolean isEmpty();

    /*
     * Purpose:
     *    Determines number of elements in the PriorityQueue.
     *
     * Parameters:
     *    None.
     *
     * Preconditions:
     *    None.
     *
     * Returns:
     *    int - number of elements in the PriorityQueue.
     *
     */
    public int size ();

 }
