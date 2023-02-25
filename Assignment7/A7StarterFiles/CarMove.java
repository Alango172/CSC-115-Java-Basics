/* CarMove.Java
 *  Represents the relocation of a train car from location to destination
 */
public class CarMove {

    private String location;    // track the train car starts on
    private String destination; // track the train car should move to

    /*
     * Purpose: sets location and destination of this CarMove to given values
     * Parameters: String location, String destination
     */
    public CarMove(String location, String destination) {
        this.location = location;
        this.destination = destination;
    }

    /*
     * Purpose: returns location of this CarMove
     * Parameters: none
     * Returns: String - location of this CarMove
     */
    public String getLocation() {
        return location;
    }

    /*
     * Purpose: returns destination of this CarMove
     * Parameters: none
     * Returns: String - destination of this CarMove
     */
    public String getDestination() {
        return destination;
    }

    /*
     * Purpose: overrides Object's equals method
     *  determines whether other is a CarMove instance with the same
     *  location and destination as this CarMove
     * Parameters: Object other
     * Returns: boolean - true if they are equal, false otherwise
     */
     // DO NOT CHANGE - tester depends on this method
    // takes Object type to enable this method to work with Java generic ArrayList
    public boolean equals(Object other) {
        if (other == null || !(other instanceof CarMove)) {
            return false;
        }
        CarMove cmove = (CarMove)other;
        return (cmove.location.equals(location)
                && cmove.destination.equals(destination));
    }

    /*
     * Purpose: creates and returns a String representation of this CarMove
     * Parameters: none
     * Returns: String - representation of this CarMove
     */
    public String toString() {
        return (location + "->" + destination);
    }
}
