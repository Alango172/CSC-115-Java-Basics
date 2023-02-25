/*
 * StackNode.java
 *
 * A node for a ref-based Stack, assuming that the stack
 * meant to contain nodes storing values of type T.
 */

public class StackNode<T> {
    private T data;
    public StackNode<T> next;


    /*
     * Purpose: sets this StackNode's data to given data and sets next to null
     * Parameters: T data, StackNode<T> next
     */
     public StackNode(T data) {
        this.data = data;
        this.next = null;
    }

    /*
     * Purpose: sets this StackNode's data and next to given data and next
     * Parameters: T data, StackNode<T> next
     */
    public StackNode(T data, StackNode<T> next) {
        this.data = data;
        this.next = next;
    }

    /*
     * Purpose: returns this StackNode's data
     * Parameters: none
     * Returns: T - data
     */
    public T getValue() {
        return this.data;
    }

    /*
     * Purpose: returns this StackNode's next
     * Parameters: none
     * Returns: StackNode<T> - next
     */
    public StackNode<T> getNext() {
        return this.next;
    }

    /*
     * Purpose: sets this StackNode's next to given next
     * Parameters: StackNode<T> next
     * Returns: void
     */
    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    /*
     * Purpose: creates and returns a String representation of this StackNode object
     * Parameters: none
     * Returns: String - representation of this StackNode object
     */
    public String toString() {
        return data.toString();
    }
}
