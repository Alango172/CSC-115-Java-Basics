import java.lang.Math;

import javax.swing.text.Position;

/*
 * MovieArrayOperations
 *  - static methods that operate on arrays of Movie instances
 */
public class MovieArrayOperations {

    /*
     * getMovieTitles
     *
     * Purpose: creates a new array of the titles of all of the Movie instances
     *       in input array
     *
     * Parameters: Movie[] - array
     *
     * Precondition: array is not null
     *
     * Returns: String[] - new array of Movie titles
     *
     */
    // TODO: add the method implementation

    public static String[] getMovieTitles(Movie[] array) {
        String [] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].getTitle();
        }
        return result;
    }

    /*
     * findMovie
     *
     * Purpose: finds the position of Movie instance with given title
     *  within the input array.
     *
     * Parameters: Movie[] - array, String - name
     *
     * Precondition: array and name are not null
     *
     * Returns: int - the position found, -1 if title is not found
     *
     */
    // TODO: add the method implementation

    public static int findMovie(Movie[] array, String name) {
        int position = 0;
        if (array.length == 0) {
            return -1;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].getTitle() == name) {
                    position = i;
                }
            }
        }
        return position;
    }   


    /*
     * getMoviesWithActor
     *
     * Purpose: creates a new array that holds only Movie instances
     *   from input array that have a leadActor with lastName matching
     *   the given actorLastName.
     *   The new array is exactly big enough to hold the Movie instances
     *   with given actorLastName from input array.
     *
     * Parameters: Movie[] - array, String - actorLastName
     *
     * Precondition: array and actorLastName are not null
     *
     * Returns: Movie[] - the new array
     *
     */
    // TODO: add the method implementation

    public static Movie[] getMoviesWithActor (Movie[] array, String actorLastName) {
        int counter = 0;
        for(int i=0;i<array.length;i++){
            if(array[i].getLeadActor()==null){
                continue;
            } else {
                if(array[i].getLeadActor().getLastName().equals(actorLastName)){
                counter++;
                }
            }    
        }

        Movie [] result = new Movie[counter];

        if(counter==0){
            return result;
        } else {
            int index = 0;
            for(int i=0;i<array.length;i++){
                if(array[i].getLeadActor() !=null){
                    if(array[i].getLeadActor().getLastName().equals(actorLastName)){
                        result[index] = array[i];
                        index++;
                    }
                }
            }
            return result;
        }
    }



    /*
     * countMoviesWithActor
     *
     * Purpose: counts the Movie instances from input array that have a
     *   leadActor with lastName matching the given actorLastName.
     *
     * Parameters: Movie[] - array, String - actorLastName
     *
     * Precondition: array and actorLastName are not null
     *
     * Returns: int - the count
     *
     */
    // TODO: add the method implementation

    public static int countMoviesWithActor(Movie[] array, String actorLastName) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getLeadActor() == null) {
                continue;
            } else {
                if (actorLastName == array[i].getLeadActor().getLastName()) {
                    count++;
                }
            }
        }
        return count;    
    }

    /*
     * getLeadActor
     *
     * Purpose: constructs and returns a String with firstName and lastName
     *   separated by a space of the leadActor of the Movie instance
     *   with the given title in input array.
     *
     * Parameters: Movie[] - array, String - title
     *
     * Precondition: array and title are not null
     *
     * Returns: String - in format "firstName lastName"
     *    or "" if Movie title not found or Movie has no leadActor assigned
     *
     */
    // TODO: add the method implementation

    public static String getLeadActor(Movie[] array, String title) {
        String result = "";
        if (array.length == 0) {
            return result;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].getTitle() == title && array[i].getLeadActor() != null) {
                    result = array[i].getLeadActor().getFirstName() + " " + array[i].getLeadActor().getLastName();
                }
            }
        }
        return result;
    }

    /*
     * addMovie
     *
     * Purpose: creates a new array 1 longer than input array and
     *  copies all Movie references from input array to new array
     *  and stores m at the end of the new array
     *
     * Parameters: Movie[] - array, Movie - m
     *
     * Preconditions:  array and m are not null
     *
     * Returns:  Movie[] - the new array
     *
     */
    // TODO: add the method implementation

    public static Movie[] addMovie (Movie[] array, Movie m) {
        Movie[] result = new Movie[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[array.length] = m;
        return result;
    }

    /*
     * removeMovie
     *
     * Purpose: if input array has Movie with given title, returns a new array
     *  with length one less than the input array. The new array is created and
     *  all but the Movie to be removed is copied from the input array to new array.
     *  If the input array does not have a Movie with given title,
     *  the input array is returned.
     *
     *
     *  If two Movie instances with the same title are in the input array
     *  the method removes the first occurance
     *
     * Parameters: Movie[] - array, String - title
     *
     * Precondition: array and title are not null
     *
     * Returns: Movie[] - the new array if title is found,
     *      otherwise returns the original input array
     *
     */
    // TODO: add the method implementation

    public static Movie[] removeMovie (Movie[] array, String title) {
        if (findMovie(array, title) >= 0) {
            Movie[] newArray = new Movie[array.length - 1];
            int index = 0;
            int deleteCount = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i].getTitle().equals(title)) {
                    if (deleteCount == 0) {
                        deleteCount++;
                        continue;
                    } else {
                        newArray[index] = array[i];
                    }
                } else {
                    newArray[index] = array[i];
                    index++;
                }
            }
            return newArray;
        } else {
            return array;
        }
    }


    /*
     * getMovieWithOldestActor
     *
     * Purpose: get the Movie from array with the leadActor who was the
     *  oldest at the time of the releaseYear of the Movie.
     *  If two Movies instances have leadActors that are the same age in the
     *  relevant releaseYear, return the first occurance in the input array
     *
     * Parameters: Movie[] - array
     *
     * Precondition: array is not null
     *
     * Returns: Movie - movie with oldest leadActor, null if no leadActors found
     *
     */
    // TODO: add the method implementation

    public static Movie getMovieWithOldestActor (Movie[] array) { 
        if (array.length == 0 ) {
            return null;
        }
        Movie old = array[0];
        for (int i = 0; i < array.length; i++) {
            if (old.actorAgeAtRelease() < array[i].actorAgeAtRelease()) {
                old = array[i];
            }
        }
        if (old.getLeadActor() == null) {
            return null;
        }
        return old;
    }
}
