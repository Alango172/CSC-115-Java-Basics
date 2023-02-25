class StackEmptyException extends Exception {
    private String msg;

    public StackEmptyException (String m) {
        msg = m;
    }

    /*
     * Purpose: creates and returns a String representation of this Exception
     * Parameters: none
     * Returns: String - representation of this Exception
     */
    public String toString() {
        return "StackEmptyException: " + msg;
    }
}
