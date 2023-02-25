/*
 * MovieLibrary
 *  - a library to store and track Movies and favourite Movies
 *  - uses a MovieListInterface as the underlying abstract data type
 *       to store Movie instances to allMovies and favourites
 */

public class MovieLibrary {

    private MovieListInterface	allMovies;
    private MovieListInterface	favourites;

    /* Constructor
     *
     * Purpose: initialize allMovies and favourites of
     * 	this instance of MovieLibrary with empty MovieLists
     *
     */
    public MovieLibrary () {
        // TODO: complete constructor initializing allMovies and favourites
        //You must allocate MovieArrayList instances here for allMovies and favourites

        this.allMovies = new MovieArrayList();
        this.favourites = new MovieArrayList();

    }



    /* getMovieCount
     *
     * Purpose: return the number of Movies in this MovieLibrary
     *
     * Parameters: none
     *
     * Returns: int - the number of Movies in allMovies
     *
     */
    public int getMovieCount() {
        // TODO: complete method
        return allMovies.size();
    }

    /* getFavouriteCount
     *
     * Purpose: return the number of Movies in favourites in this MovieLibrary
     *
     * Parameters: none
     *
     * Returns: int - the number of Movies in favourites
     *
     */
    public int getFavouriteCount() {
        // TODO: complete method
        return favourites.size();
    }

    /*
     *
     * Purpose: add m to allMovies, if favourite is true add m to favourites
     *
     * Parameters: Movie m, boolean favourite
     *
     * Precondition: m is not null
     *
     * Returns: void
     *
     */
    public void addMovie (Movie m, boolean favourite) {
         // TODO: complete method
        allMovies.add(m);
        if(favourite == true) {
            favourites.add(m);
        }
    }

    /* removeFavourite
     *
     * Purpose: remove Movie with title from favourites if found.
     *   Does not remove Movie from allMovies
     *
     * Parameters: String title
     *
     * Precondition: title is not null
     *
     * Returns: void
     *
     */
    public void removeFavourite (String title) {
        // TODO: complete method
        for (int i = 0; i < favourites.size(); i++) {
            if((favourites.getMovieTitles())[i].equals(title)) {
                favourites.removeFromPosition(i);
            }
        }
    }


    /* removeMovie
     *
     * Purpose: remove Movie with title from allMovies and favourites if found
     *
     * Parameters: String title
     *
     * Precondition: title is not null
     *
     * Returns: void
     *
     */
    public void removeMovie (String title) {
        // TODO: complete method
        for (int i = 0; i < allMovies.size(); i++) {
            if ((allMovies.getMovieTitles())[i].equals(title)) {
                allMovies.removeFromPosition(i);
            }
        }
        for (int i = 0; i < favourites.size(); i++) {
            if((favourites.getMovieTitles())[i].equals(title)) {
                favourites.removeFromPosition(i);
            }
        }
    }


    /* getAllMovieTitles
     *
     * Purpose: returns an array of titles of Movies in allMovies
     *
     * Parameters: none
     *
     * Returns: String[] - an array of Movie titles
     *
     */
    public String[] getAllMovieTitles () {
        // TODO: complete method
        return allMovies.getMovieTitles();
    }

    /* getAllMovieTitles
     *
     * Purpose: returns an array of titles of Movies in favourites
     *
     * Parameters: none
     *
     * Returns: String[] - an array of Movie titles
     *
     */
    public String[] getFavouriteTitles () {
        // TODO: complete method
        return favourites.getMovieTitles();
    }

    /* getTitlesWithActor
     *
     * Purpose: returns an array of titles of Movies in allMovies
     *     with leadActor with lastName
     *
     * Parameters: String lastName
     *
     * Precondition: lastName is not null
     *
     * Returns: String[] - an array of Movie titles
     *
     */
    public String[] getTitlesWithActor (String lastName) {
        // TODO: complete method
        return allMovies.getMovieTitlesWithActor(lastName);
    }

}
