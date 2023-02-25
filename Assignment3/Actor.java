/*
 * Actor class
 *  represents a movie actor
 */
public class Actor {

    private String firstName;
    private String lastName;;
    private int birthYear;
    private int numOscars;

    /*
     * Purpose: Initialize this instance of Actor with given firstName, lastName
     *    and year and numOscars with 0.
     *
     * Parameters: String firstName, String lastName, int birthYear
     */
    public Actor (String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.birthYear = birthYear;
        this.numOscars = 0;
    }

    /*
     * Purpose: Initialize this instance of Actor with given firstName, lastName,
     *    year and numOscars.
     *
     * Parameters: String firstName, String lastName, int birthYear, int numOscars
     */
    public Actor (String firstName, String lastName, int birthYear, int numOscars) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.birthYear = birthYear;
        this.numOscars = numOscars;
    }

    /*
     * Purpose: Returns the firstName associated with this Actor
     *
     * Parameters: nothing
     *
     * Returns: String - firstName associated with this Actor
     */
    public String getFirstName () {
        return firstName;
    }

        /*
     * Purpose: set the firstName associated with this Actor to given firstName
     *
     * Parameters: String firstName
     *
     * Returns: void
     */
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    /*
     * Purpose: Returns the lastName associated with this Actor
     *
     * Parameters: nothing
     *
     * Returns: String - lastName associated with this Actor
     */
    public String getLastName () {
        return lastName;
    }

    /*
     * Purpose: set the lastName associated with this Actor to given firstName
     *
     * Parameters: String lastName
     *
     * Returns: void
     */
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    /*
     * Purpose: Returns the birthYear associated with this Actor
     *
     * Parameters: nothing
     *
     * Returns: int - birthYear associated with this Actor
     */
    public int getBirthYear () {
        return birthYear;
    }

    /*
     * Purpose: Returns the numOscars associated with this Actor
     *
     * Parameters: nothing
     *
     * Returns: int - numOscars associated with this Actor
     */
    public int getNumOscars () {
        return numOscars;
    }

    /*
     * Purpose: adds moreOscars to numOscars associated with this Actor
     *
     * Parameters: int moreOscars
     *
     * Precondition: moreOscars>=0
     *
     * Returns: void
     */
    public void addOscars (int moreOscars) {
        numOscars += moreOscars;
    }

    /*
     * Purpose: calculates the age this Actor will be in the given year
     *
     * Parameters: nothing
     *
     * Precondition: year >= birthYear
     *
     * Returns: int - the age
     */
    public int getAge (int year) {
        return year - birthYear;
    }

    /*
     * Purpose: returns a String representing this Actor formated as:
     *  firstName lastName, born in birthYear, has numOscars Oscar awards
     *
     * Parameters: nothing
     *
     * Returns: String - a representation of this Actor
     *
     * Example:
     *  Actor a = new Actor("Brad", "Pitt", 1963, 2)
     *  a.toString() returns "Brad Pitt, born in 1963, has 2 Oscar awards"
     */
    public String toString() {
        return (firstName + " " + lastName + ", born in " + birthYear
              + ", has " + numOscars + " Oscar awards");
    }
}
