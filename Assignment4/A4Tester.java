import java.util.Arrays;
import java.util.Random;

import javax.swing.text.Position;
/*
 * A4Tester.java
 *
 * The auto grading of your assignment may include tests with different values.
 *
 */
public class A4Tester {

    private static int testPassCount = 0;
    private static int testCount = 0;
    public static int  stressTestSize = 20000;

    private static Actor jLopez = new Actor("Jennifer", "Lopez", 1969);
    private static Actor bPitt = new Actor("Brad", "Pitt", 1963, 2);
    private static Actor fMcdormand = new Actor("Frances", "McDormand", 1957, 4);
    private static Actor jFonda = new Actor("Jane", "Fonda", 1937, 2);
    private static Actor mJordan = new Actor("Michael", "Jordan", 1963, 0);

    private static Movie nomadland = new Movie("Nomadland", 2020, fMcdormand);
    private static Movie monsterInLaw = new Movie("Monster-in-Law", 2005, jLopez);
    private static Movie spaceJam = new Movie("Space Jam", 1996, mJordan);
    private static Movie maidInManhattan = new Movie("Maid in Manhattan", 2002, jLopez);
    private static Movie ladyBird = new Movie("Lady Bird", 2017);
    private static Movie moneyball = new Movie("Moneyball", 2011, bPitt);
    private static Movie minari = new Movie("Minari", 2021);

    private static Movie[] movies = {nomadland, monsterInLaw, spaceJam,
                                     maidInManhattan, ladyBird, moneyball, minari};

    public static void main (String[] args) {

        try {
            movieListTestOne();
            movieListTestTwo();
            movieListResizeTest();
            movieListRemoveAtTest();
            movieListStressTest();
            movieListGetTitlesTest();
            movieLibraryTestOne();
            movieLibraryTestTwo();

        } catch (Exception e) {
            System.out.println("Your code threw an Exception.");
            System.out.println("Perhaps a stack trace will help:");
            e.printStackTrace(System.out);
        }

        System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
    }

    public static void displayResults (boolean passed, String testName) {
        /* There is some magic going on here getting the line number
         * Borrowed from:
         * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
         */
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testCount);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    public static void movieListTestOne() {

        System.out.println("MovieList testing: constructor, add, get, find in max 1 element list");

        MovieListInterface list = new MovieArrayList();

        displayResults(list.size() == 0, "list constructor, size");
        list.add(nomadland);
        // uncomment to see resulting list
        System.out.println(list);

        displayResults(list.size() == 1, "list constructor + add 1 element");
        displayResults(list.get(0) == nomadland, "list get 1 element list");
        displayResults(list.find("Toy Story") == -1, "list find not there, 1 element list");
        displayResults(list.find("Nomadland") == 0, "list find is there, 1 element list");

    }

    public static void movieListTestTwo() {

        System.out.println("MovieList testing: add, get, find, remove");

        MovieListInterface list = new MovieArrayList();

        list.add(nomadland);
        list.add(monsterInLaw);

        displayResults(list.size() == 2, "add + size, 2 element list");
        Movie movieReference = list.get(0);
        Movie remaining;

        if (movieReference == nomadland)
            remaining = monsterInLaw;
        else
            remaining = nomadland;

        list.removeFromPosition(0);
        displayResults(list.find(remaining.getTitle()) != -1, "remove + find, 1 element list");
        displayResults(list.size() == 1, "remove + size, 2 element list");
        displayResults(list.get(0) == remaining, "remove + get, 2 element list");

        list.removeFromPosition(0);
        System.out.println(list);
        displayResults(list.size() == 0, "remove + size, 1 element list");
        displayResults(list.find(remaining.getTitle()) == -1, "remove + find empty list");

    }

    public static void movieListResizeTest() {

        System.out.println("MovieList testing resizing, add, find");
        MovieListInterface list = new MovieArrayList();

        int titleNum = 5500000;
        int releaseYear = 1963;
        int numToAdd = 100;
        for (int i = 0; i < numToAdd; i++) {
            Movie m = new Movie(Integer.toString(titleNum+i), (releaseYear+i));
            list.add(m);
        }

        displayResults(list.size() == numToAdd, "add + size, " + numToAdd + " elements");


        boolean passed = true;
        int i = numToAdd - 1;

        while (i>=0 && passed) {
            if (list.find(Integer.toString(titleNum+i)) == -1) {
                passed = false;
            }
            i--;
        }

        displayResults(passed, "find, " + numToAdd + " elements");
    }

    public static void movieListRemoveAtTest() {

        System.out.println("MovieList testing resizing, add, find, removeAtPos");
        MovieListInterface list = new MovieArrayList();

        int titleNum = 5500000;
        int releaseYear = 1963;
        int numToAdd = 100;
        for (int i = 0; i < numToAdd; i++) {
            Movie m = new Movie(Integer.toString(titleNum+i), (releaseYear+i));
            list.add(m);
        }


        int numElements = numToAdd;

        int pos = list.find(Integer.toString(titleNum+10));
        Movie toRemove = list.get(pos);
        String titleToRemove = new String(toRemove.getTitle());

        list.removeFromPosition(pos);
        numElements--;
        displayResults(list.size() == numElements, "add, removeAt + size, " + numToAdd + " elements");
        displayResults(list.find(titleToRemove) == -1, "add, removeAt + find, " + numToAdd + " elements");

        Random r = new Random();
        int numToRemove = 10;
        for (int i=0; i<numToRemove; i++) {
            pos = r.nextInt(numElements); // random number between 0 and numElements-1 inclusive
            toRemove = list.get(pos);
            titleToRemove = new String(toRemove.getTitle());

            displayResults(list.find(titleToRemove) == pos, "add + size, " + numToAdd + " elements");
            list.removeFromPosition(pos);
            numElements--;
            displayResults(list.size() == numElements, "add, removeAt + size, " + numToAdd + " elements");
            displayResults(list.find(titleToRemove) == -1, "add, removeAt + find, " + numToAdd + " elements");

        }

    }


    public static void movieListStressTest() {

        System.out.println("MovieList stress test.");

        MovieListInterface list = new MovieArrayList();

        int titleNum = 5500000;
        int releaseYear = 1963;
        int numToAdd = 100;
        for (int i = 0; i < stressTestSize; i++) {
            Movie m = new Movie(Integer.toString(titleNum+i), (releaseYear+i));
            list.add(m);
        }

        displayResults(list.size() == stressTestSize, "add + size, >10000 elements");

        boolean passed = true;
        int i = stressTestSize - 1;

        while (i>=0 && passed) {
            if (list.find(Integer.toString(titleNum+i)) == -1) {
                passed = false;
            }
            i--;
        }

        displayResults(passed, "find, " + stressTestSize +" elements");
        displayResults(list.size()==stressTestSize, "size, " + stressTestSize +" elements");

        passed = true;
        i = stressTestSize - 1;
        while (i>=0 && passed) {
            Movie toRemove = list.get(0);
            String titleToRemove = toRemove.getTitle();
            list.removeFromPosition(0);

            if (list.find(titleToRemove) != -1) {
                passed = false;
            }

            if (list.size() != i) {
                passed = false;
            }
            i--;
        }
        displayResults(passed, "remove, " + stressTestSize +" elements");

    }

    public static void movieListGetTitlesTest() {

        System.out.println("movieList testing getMovieTitles");
        MovieListInterface list = new MovieArrayList();

        String[] emptyExpected = {};
        String[] result = list.getMovieTitles();
        displayResults(Arrays.equals(result, emptyExpected), "test getMovieTitles on empty list");

        result = list.getMovieTitlesWithActor("Pitt");
        displayResults(Arrays.equals(result, emptyExpected), "test getMovieTitlesWithActor on empty list");


        for (int i=0; i<movies.length; i++) {
            list.add(movies[i]);
        }
        String[] allExpected = new String[movies.length];
        for (int i=0; i<movies.length; i++) {
            allExpected[i] = movies[i].getTitle();
        }

        result = list.getMovieTitles();
        displayResults(Arrays.equals(result, allExpected), "test getMovieTitles on nonempty list");


        result = list.getMovieTitlesWithActor("Washington");
        displayResults(Arrays.equals(result, emptyExpected), "test getMovieTitlesWithActor on non empty list, none found");


        String[] oneExpected = {"Moneyball"};
        result = list.getMovieTitlesWithActor("Pitt");
        displayResults(Arrays.equals(result, oneExpected), "test getMovieTitlesWithActor on non empty list, 1 found");

        String[] moreExpected = {"Monster-in-Law", "Maid in Manhattan"};
        result = list.getMovieTitlesWithActor("Lopez");
        displayResults(Arrays.equals(result, moreExpected), "test getMovieTitlesWithActor on non empty list, >1 found");


    }


    public static void movieLibraryTestOne() {

        System.out.println("MovieLibrary testing one");
        MovieLibrary library = new MovieLibrary();

        displayResults(library.getMovieCount() == 0, "constructor without movies added + getExamCount");
        displayResults(library.getFavouriteCount() == 0, "constructor without movies added + getFavouriteCount");


        // add movie
        library.addMovie(nomadland, false);
        displayResults(library.getMovieCount() == 1, "constructor with movie added but not to favourites + getMovieCount");
        displayResults(library.getFavouriteCount() == 0, "constructor with movie added but not to favourites + getFavouriteCount");

        String[] result = library.getAllMovieTitles();
        String[] expected = {"Nomadland"};
        displayResults(Arrays.equals(result, expected), "constructor with movie added + getAllMovieTitles");

        result = library.getFavouriteTitles();
        expected = new String[0];
        displayResults(Arrays.equals(result, expected), "constructor with movie added + getFavouriteTitles");


        // add movie
        library.addMovie(spaceJam, true);
        displayResults(library.getMovieCount() == 2, "constructor with movie added and to favourites + getMovieCount");
        displayResults(library.getFavouriteCount() == 1, "constructor with movie added and to favourites + getFavouriteCount");

        result = library.getAllMovieTitles();
        String[] expected2 = {"Nomadland", "Space Jam"};
        displayResults(Arrays.equals(result, expected2), "constructor with movie added + getAllMovieTitles");

        result = library.getFavouriteTitles();
        expected = new String[1];
        expected[0] = "Space Jam";
        displayResults(Arrays.equals(result, expected), "constructor with movie added + getFavouriteTitles");


        // add movie
        library.addMovie(moneyball, true);
        displayResults(library.getMovieCount() == 3, "movie added and to favourites + getMovieCount");
        displayResults(library.getFavouriteCount() == 2, "movie added and to favourites + getFavouriteCount");

        result = library.getAllMovieTitles();
        String[] expected3 = {"Nomadland", "Space Jam", "Moneyball"};
        displayResults(Arrays.equals(result, expected3), "movie added and to favourites + getAllMovieTitles");

        result = library.getFavouriteTitles();
        expected = new String[2];
        expected[0] = "Space Jam";
        expected[1] = "Moneyball";
        displayResults(Arrays.equals(result, expected), "movie added and to favourites + getFavouriteTitles");

        library.removeFavourite("Nomadland");
        displayResults(library.getMovieCount() == 3, "removeFavourite not there + getMovieCount");
        displayResults(library.getFavouriteCount() == 2, "removeFavourite not there + getFavouriteCount");
        result = library.getAllMovieTitles();
        displayResults(Arrays.equals(result, expected3), "removeFavourite not there  + getAllMovieTitles");
        result = library.getFavouriteTitles();
        displayResults(Arrays.equals(result, expected), "removeFavourite not there  + getFavouriteTitles");


        library.removeFavourite("Moneyball");
        displayResults(library.getMovieCount() == 3, "removeFavourite there + getMovieCount");
        displayResults(library.getFavouriteCount() == 1, "removeFavourite there + getFavouriteCount");
        result = library.getAllMovieTitles();
        displayResults(Arrays.equals(result, expected3), "removeFavourite there  + getAllMovieTitles");
        result = library.getFavouriteTitles();
        expected = new String[1];
        expected[0] = "Space Jam";
        displayResults(Arrays.equals(result, expected), "removeFavourite there  + getFavouriteTitles");


        library.removeMovie("Nomadland");
        displayResults(library.getMovieCount() == 2, "removeMovie not in favourites + getMovieCount");
        displayResults(library.getFavouriteCount() == 1, "removeMovie not in favourites + getFavouriteCount");
        result = library.getAllMovieTitles();
        expected = new String[2];
        expected[0] = "Space Jam";
        expected[1] = "Moneyball";
        displayResults(Arrays.equals(result, expected), "removeMovie not in favourites  + getAllMovieTitles");
        result = library.getFavouriteTitles();
        expected = new String[1];
        expected[0] = "Space Jam";
        displayResults(Arrays.equals(result, expected), "removeMovie not in favourites  + getFavouriteTitles");


        library.removeMovie("Space Jam");
        displayResults(library.getMovieCount() == 1, "removeMovie in favourites + getMovieCount");
        displayResults(library.getFavouriteCount() == 0, "removeMovie in favourites + getFavouriteCount");
        result = library.getAllMovieTitles();
        expected = new String[1];
        expected[0] = "Moneyball";
        displayResults(Arrays.equals(result, expected), "removeMovie in favourites  + getAllMovieTitles");
        result = library.getFavouriteTitles();
        expected = new String[0];
        displayResults(Arrays.equals(result, expected), "removeMovie in favourites  + getFavouriteTitles");

      }
      public static void movieLibraryTestTwo() {

          System.out.println("MovieLibrary testing and getTitlesWithActor");

          MovieLibrary library = new MovieLibrary();
          int favouriteAlternate = 3;
          int numFavourites = 0;
          for (int i=0; i<movies.length; i++) {
              if (i%favouriteAlternate == 0) {
                  library.addMovie(movies[i], true);
                  numFavourites++;
              } else {
                  library.addMovie(movies[i], false);
              }
          }

          String[] moviesExpected = new String[movies.length];
          String[] favouritesExpected = new String[numFavourites];
          int favouritesIndex = 0;
          for (int i=0; i<movies.length; i++) {
              moviesExpected[i] = movies[i].getTitle();
              if (i%favouriteAlternate == 0) {
                  favouritesExpected[favouritesIndex++] = movies[i].getTitle();
              }
          }

          displayResults(library.getMovieCount() == movies.length, "Movie library add + getFavouriteCount");
          displayResults(library.getFavouriteCount() == (numFavourites), "Movie library add + getFavouriteCount");

          String[] result = library.getAllMovieTitles();
          displayResults(Arrays.equals(result, moviesExpected), "add  + getAllMovieTitles");

          result = library.getFavouriteTitles();
          displayResults(Arrays.equals(result, favouritesExpected), "add  + getFavouriteTitles");

          result = library.getTitlesWithActor("Washington");
          String[] expected0 = {};
          displayResults(Arrays.equals(result, expected0), "not found getTitlesWithActor");

          result = library.getTitlesWithActor("Pitt");
          String[] expected1 = {"Moneyball"};
          displayResults(Arrays.equals(result, expected1), " found 1 getTitlesWithActor");

          result = library.getTitlesWithActor("Lopez");
          String[] expected2 = {"Monster-in-Law", "Maid in Manhattan"};
          displayResults(Arrays.equals(result, expected2), " found >1 getTitlesWithActor");

     }


}
