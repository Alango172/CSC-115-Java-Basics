/*
 * IntegerNode.java
 *
 * An implementation of a node class for a doubly-linked list of integers.
 *
 * Your textbook uses the following coding conventions for setting the value of
 * a node's next and prev values
 *
 *    n.next = null;
 *    n.prev.next = otherNode;
 *
 * Rather than:
 *
 *    n.setNext(null);
 *    n.getPrev().setNext(otherNode);
 *
 * Therefore I have not set next and prev to be private
 * contrary to what we have said about keeping data fields private...
 *
 * In this assignment, and on exams, you are free to use whichever
 * method you find most comfortable.
 *
 */

public class IntegerNode {
    IntegerNode    next;
    IntegerNode    prev;
    int            e; 


    /*
     *
     * Purpose: sets IntegerNode's element e to given element e,
     *         sets IntegerNode's next and prev to null
     *
     * Parameters: IntegerNode e
     *
     */
    public IntegerNode (Integer e) {
        this.e = e;
        next = null;
        prev = null;
    }


    /*
     *
     * Purpose: sets IntegerNode's element e, next and prev
     *     to given element e, next and prev
     *
     * Parameters: IntegerNode e
     *
     */
    public IntegerNode (Integer e, IntegerNode next, IntegerNode prev) {
        this.e = e;
        this.next = next;
        this.prev = prev;
    }

    /*
     *
     * Purpose: return IntegerNode's next
     *
     * Parameters: none
     *
     * Returns: IntegerNode - next
     *
     */
    public IntegerNode getNext() {
        return next;
    }



    /*
     *
     * Purpose: sets IntegerNode's next to given next
     *
     * Parameters: IntegerNode e
     *
     * Returns: void
     *
     */
    public void setNext (IntegerNode next) {
        this.next = next;
    }

    /*
     *
     * Purpose: return IntegerNode's prev
     *
     * Parameters: none
     *
     * Returns: IntegerNode - prev
     *
     */
    public IntegerNode getPrev() {
        return prev;
    }

    public void setPrev (IntegerNode prev) {
        this.prev = prev;
    }

    /*
     *
     * Purpose: return IntegerNode's element e
     *
     * Parameters: none
     *
     * Returns: int - e
     *
     */
    public int getElement() {
        return e;
    }


    /*
     *
     * Purpose: sets IntegerNode's element e to given element e
     *
     * Parameters: int e
     *
     * Returns: void
     *
     */
    public void setElement (int e) {
        this.e = e;
    }


    /*
     *
     * Purpose: a string representation of IntegerNode's element e
     *
     * Parameters: none
     *
     * Returns: String - the string representation
     *
     */
    public String toString() {
        return "e: " + e ;
    }
}
