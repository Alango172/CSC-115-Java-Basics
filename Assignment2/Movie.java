/*
 * Movie class
 *  represents a Movie
 */
public class Movie {

    private String title;
    private int releaseYear;
    private Actor leadActor;

    /* Constructor
     *
     * Purpose: Initialize this instance of Movie with given title and releaseYear.
     *   Set leadActor to NULL.
     *
     * Parameters: String title, int releaseYear
     *
     * Precondition: releaseYear is a valid year in the Gregorian calendar
     */
    // TODO: add the method implementation

    public Movie (String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }


    /* Constructor
     *
     * Purpose: Initialize this instance of Movie with given title, releaseYear
     *   and leadActor.
     *
     * Parameters: String title, int releaseYear, Actor leadActor
     *
     * Precondition: releaseYear is a valid year in the Gregorian calendar
     */
    // TODO: add the method implementation

    public Movie (String title, int releaseYear, Actor leadActor) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.leadActor = leadActor;
    }


    /* getTitle
     *
     * Purpose: Returns the title associated with this Movie
     *
     * Parameters: nothing
     *
     * Returns: String - the title associated with this Movie
     */
    // TODO: add the method implementation

    public String getTitle () {
        return title;
    }


    /* getReleaseYear
     *
     * Purpose: Returns the releaseYear associated with this Movie
     *
     * Parameters: nothing
     *
     * Returns: int - the releaseYear associated with this Movie
     */
    // TODO: add the method implementation
    
    public int getReleaseYear () {
        return releaseYear;
    }

    /* getLeadActor
     *
     * Purpose: Returns the leadActor associated with this Movie
     *
     * Parameters: nothing
     *
     * Returns: Actor - the leadActor associated with this Movie
     */
    // TODO: add the method implementation

    public Actor getLeadActor () {
        return leadActor;
    }


    /* setLeadActor
     *
     * Purpose: sets leadActor associated with this Movie to given leadActor
     *
     * Parameters: Actor leadActor
     *
     * Returns: void
     */
    // TODO: add the method implementation

    public void setLeadActor (Actor leadActor) {
        this.leadActor = leadActor;
    }


    /* equals
     *
     * Purpose: determines whether the title and releaseYear of
     *  this instance of Movie is equal to other's title and releaseYear
     *
     * Parameters: Movie other
     *
     * Precondition: other is not null
     *
     * Returns: boolean - true if this Movie's title and releaseYear of
     *  this instance of Movie is equal to other's title and releaseYear,
     *  false otherwise
     */
    // TODO: add the method implementation

    public boolean equals (Movie other) {
        boolean flag = false;
        if (this.title.equals(other.title) && this.releaseYear == other.releaseYear) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }




    /* actorAgeAtRelease
     * Purpose: calculates the age of the leadActor of this Movie was in the
     *        releaseYear
     *
     * Parameters: none
     *
     * Returns: int - the age of the leadActor of this Movie at releaseYear,
     *         -1 if the leadActor is NULL
     */
     // TODO: add the method implementation

    public int actorAgeAtRelease () { 
        int age = 0;
        if (leadActor == null) {
            age = -1;
        } else {
            age = leadActor.getAge(releaseYear);   
        }
        return age;
    }


    /* toString
     *
     * Purpose: returns a String representing this Movie formated as:
     *  title, released in releaseYear, starring: leadActor
     *
     * Parameters: nothing
     *
     * Returns: String - a representation of this Movie
     *
     * Example:
     *  Actor a = new Actor("Brad", "Pitt", 1963, 2)
     *  Movie m = new Movie("12 Years a Slave", 2014, a)
     *  m.toString() returns:
     *  "12 Years a Slave, released in 2014, starring: Brad Pitt, born in 1963, has 2 Oscar awards"
     */
     // TODO: add the method implementation

    public String toString () {
        String result = "";
        result = title + ", released in " + releaseYear + ", starring: " + leadActor;
        if (leadActor == null){
            result = title + ", released in " + releaseYear;
        }
        return result;
    }

}
