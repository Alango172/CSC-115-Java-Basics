/*
 * MovieListInterface
 *  - an interface for a MovieList with specified functionality
 */

public interface MovieListInterface {

    /* get
     *
     * Purpose: returns the element at position
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *     for a MovieList x:
     *    position >= 0 AND
     *    position < x.size()
     *
     * Returns: Movie - the Movie at position
     *
     */
    Movie get (int position);


    /* size
     *
     * Purpose: returns the number of elements in the list
     *
     * Parameters: none
     *
     * Returns: int - the number of elements
     *
     */
    int size();


    /* add
     *
     * Purpose: add Movie m to the MovieList
     *  more space is allocated for the MovieList if necessary
     *  to add m to the list
     *
     * Parameters: Movie m
     *
     * Precondition: m is not null, the title of m is unique,
     *   ie. MovieList does not already contain a Movie with the same title
     *
     * Returns: void
     *
     */
    void add (Movie m);


    /* find
     *
     * Purpose: returns the position of Movie with given title in the list.
     *  If a Movie with given title is not found, returns -1
     *
     * Parameters: String title
     *
     * Precondition: title is not null
     *
     * Returns: int - position of Movie with title, -1 if it does not exist
     *
     */
    int find (String title);


    /* removeFromPosition
     *
     * Purpose: removes the element at given position in the list
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *    for a MovieList x:
     *        position >= 0 AND
     *        position < x.size()
     *
     * Returns: void
     *
     */
    void removeFromPosition (int position);


    /* getMovieTitles
     *
     * Purpose: returns an array of titles from Movie instances in MovieList
     *
     * Parameters: none
     *
     * Returns: String[] - array of Movie titles
     *
     */
    String[] getMovieTitles ();


    /* getMovieTitlesWithActor
     *
     * Purpose: returns an array of titles from Movie instances in MovieList
     *   which have a leadActor with given actorLastName
     *
     * Parameters: String actorLastName
     *
     * Precondition: actorLastName is not null
     *
     * Returns: String[] - array of Movie titles
     *
     */
    String[] getMovieTitlesWithActor (String actorLastName);


    /* toString
     *
     * Purpose: return a String representing the forward traversal
     *  with a space between each element
     *
     * Parameters: none
     *
     * Returns: String - the forward list representation
     *
     */
    String toString();

}
