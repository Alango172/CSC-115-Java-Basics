/*
 * MovieArrayList
 *  - a concrete implementation of the MovieListInterface
 *  - uses an array as the underlying data structure to store Movie instances
 *  - see MovieListInterface for method specifications
 */
public class MovieArrayList implements MovieListInterface {

    private static final int INITIAL_CAPACITY = 2;

    private Movie[]  storage;  // holds Movie instance, each with a unique title
    private int numMovies;  // keeps track of the number of Movie objects in storage

    /* Constructor
     *
     * Purpose: Initialize a new instance of MovieArrayList
     *
     */
    public MovieArrayList() {
        // TODO: You must initialize storage to be an array able
        // to hold INITIAL_CAPACITY Movie objects
        // Initially, there will be no Movie instances in storage, therefore
        // initialize numExams to be 0 even though the capacity is INITIAL_CAPACITY

        this.storage = new Movie[INITIAL_CAPACITY];
        numMovies = 0;
    }


    // completed for you
    public String toString() {
        String result = "";
        for (int i=0; i<numMovies; i++) {
            result += storage[i].toString() + "\n";
        }
        return result;
    }

    public Movie get (int position) {
        return storage[position];
    }

    public int size() {
        return numMovies;
    }

    public void add (Movie m) {
        if (numMovies >= storage.length) {
            Movie[] temp = new Movie[numMovies + 1];
            for (int i = 0; i < storage.length; i++) {
                temp[i] = storage[i];
            }
            storage = temp;
        }
        this.storage[numMovies] = m;
        numMovies++;
    }

    public int find (String title) {
        if (numMovies == 0){
            return -1;
        }
        boolean found = false;
        int position = 0;
        for (int i = 0; i < numMovies; i++) {
            if (storage[i].getTitle().equals(title)){
                position = i;
                found = true;
                break;
            }
        }
        if (found == false) {
            return -1;
        }
        return position;
    }

    public void removeFromPosition (int position) {
       for (int i = position; i < numMovies - 1; i++) {
           storage[i] = storage[i+1];
       }
        numMovies--;
    }

    public String[] getMovieTitles () {
        String[] result = new String[numMovies];
        for (int i = 0; i < numMovies; i++) {
            result[i] = storage[i].getTitle();
        }
        return result;
    }

    public String[] getMovieTitlesWithActor (String actorLastName) {
        int counter = 0;
        for (int i = 0; i < numMovies; i++) {
            if (storage[i].getLeadActor() == null) {
                continue;
            } else if (storage[i].getLeadActor().getLastName().equals(actorLastName)){
                counter++;
            }
        }
        String[] result = new String[counter]; 
        if(counter==0){
            return result;
        } else {
            int index = 0;
            for(int i=0;i < numMovies;i++){
                if(storage[i].getLeadActor() !=null){
                    if(storage[i].getLeadActor().getLastName().equals(actorLastName)){
                    result[index] = storage[i].getTitle();
                    index++;
                    }
                }
            }
            
        }
        return result;
    }
}
