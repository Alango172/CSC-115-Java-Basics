/*
 * Movie class
 *  represents a Movie
 */
public class Movie {

    private String title;
    private int releaseYear;
    private Actor leadActor;

    /*
     * Purpose: Initialize this instance of Movie with given title and releaseYear
     *   and leadActor with NULL
     *
     * Parameters: String title, int releaseYear
     *
     * Precondition: releaseYear is a valid year in the Gregorian calendar
     */
    public Movie (String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.leadActor = null;
    }

    /*
     * Purpose: Initialize this instance of Movie with given title, releaseYear
     *   and leadActor.
     *
     * Parameters: String title, int releaseYear, Actor leadActor
     *
     * Precondition: releaseYear is a valid year in the Gregorian calendar,
     *               leadActor is not null
     */
    public Movie (String title, int releaseYear, Actor leadActor) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.leadActor = leadActor;
    }

    /*
     * Purpose: Returns the title associated with this Movie
     *
     * Parameters: nothing
     *
     * Returns: String - the title associated with this Movie
     */
    public String getTitle () {
        return title;
    }

    /*
     * Purpose: Returns the releaseYear associated with this Movie
     *
     * Parameters: nothing
     *
     * Returns: int - the releaseYear associated with this Movie
     */
    public int getReleaseYear() {
            return releaseYear;
    }

    /*
     * Purpose: Returns the leadActor associated with this Movie
     *
     * Parameters: nothing
     *
     * Returns: Actor - the leadActor associated with this Movie
     */
    public Actor getLeadActor () {
            return leadActor;
    }

    /*
     * Purpose: sets leadActor associated with this Movie to given leadActor
     *
     * Parameters: Actor leadActor
     *
     * Precondition: leadActor is not null
     *
     * Returns: void
     */
    public void setLeadActor (Actor leadActor) {
            this.leadActor = leadActor;
    }

    /*
     * Purpose: determines whether the title and releaseYear of
     *  this instance of Actor is equal to other's title and releaseYear
     *
     * Parameters: Movie other
     *
     * Precondition: other is not null
     *
     * Returns: boolean - true if this Movie equals other Movie, false otherwise
     */
    public boolean equals (Movie other) {
        return  other.getTitle().equals(title) &&
                other.getReleaseYear() == releaseYear;
    }

    /*
     * Purpose: calculates the age the leadActor of this Movie was in the
     *        releaseYear
     *
     * Parameters: none
     *
     * Returns: int - the age, -1 if the leadActor is NULL
     */
    public int actorAgeAtRelease () {
          int age = -1;
            if (leadActor != null) {
                  age = leadActor.getAge(releaseYear);
            }
            return age;
    }


    /*
     * Purpose: returns a String representing this Actor formated as:
     *  title, released in releaseYear, starring: leadActor
     *
     * Parameters: nothing
     *
     * Returns: String - a representation of this Actor
     *
     * Example:
     *  Actor a = new Actor("Brad", "Pitt", 1963, 2)
     *  Movie m = new Movie("12 Years a Slave", 2014, a)
     *  m.toString() returns:
     *  "12 Years a Slave, released in 2014, starring: Brad Pitt, born in 1963, has 2 Oscar awards"
     */
     public String toString() {
         String str =  title + ", released in " + releaseYear;
             if (leadActor != null) {
                 str += ", starring: " + leadActor;
             }
             return str;
     }
}
