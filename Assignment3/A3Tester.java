import java.util.Arrays;
/*
 * A3Tester.java
 *
 * A partial test program for Assignment 3.
 *
 * While this program includes many test cases,
 * it is INTENTIONALLY not a comprehensive set of tests.
 * You should add your own tests to test cases not considered.
 *
 * The auto grading of your assignment will include different and additional tests.
 *
 */
public class A3Tester {

    private static int testPassCount = 0;
    private static int testCount = 0;

    private static Actor jLopez = new Actor("Jennifer", "Lopez", 1969);
    private static Actor bPitt = new Actor("Brad", "Pitt", 1963, 2);
    private static Actor fMcdormand = new Actor("Frances", "McDormand", 1957, 4);
    private static Actor jFonda = new Actor("Jane", "Fonda", 1937, 2);
    private static Actor mJordan = new Actor("Michael", "Jordan", 1963, 0);

    private static Movie nomadland = new Movie("Nomadland", 2020, fMcdormand);
    private static Movie monsterInLaw = new Movie("Monster-in-Law", 2005, jLopez);
    private static Movie maidInManhattan = new Movie("Maid in Manhattan", 2002, jLopez);
    private static Movie spaceJam = new Movie("Space Jam", 1996, mJordan);
    private static Movie ladyBird = new Movie("Lady Bird", 2017);
    private static Movie moneyball = new Movie("Moneyball", 2011, bPitt);
    private static Movie minari = new Movie("Minari", 2021);


    public static void main (String[] args) {

        getMovieTitlesTest();
        findMovieTest();
        getMoviesWithActorTest();
        countMoviesWithActorTest();
        getLeadActorTest();
        addMovieTest();
        removeMovieTest();
        getMovieWithOldestActorTest();

        System.out.println("Passed " + testPassCount + "/" + testCount + " tests");
    }

    public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        testCount++;
        if (passed) {
            System.out.println ("Passed test: " + testCount);
            testPassCount++;
        } else {
            System.out.println ("Failed test: " + testName + " at line "
                  + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }

    public static void getMovieTitlesTest() {
        Movie[] empty = {};
        Movie[] movies4 = {nomadland, spaceJam, minari, ladyBird};

        String[] result;
        String[] expectedEmpty = {};
        String[] expected4 = {"Nomadland", "Space Jam", "Minari", "Lady Bird"};

        result = MovieArrayOperations.getMovieTitles(movies4);
        // uncomment to print the result array
        // System.out.println("result array: " + Arrays.toString(result));
        displayResults (Arrays.equals(result, expected4),
                        "getMovieTitlesTest - non-empty array");
    }

    public static void findMovieTest() {

        Movie[] empty = {};
        Movie[] movies4 = {nomadland, spaceJam, minari, ladyBird};

        int result;

        result = MovieArrayOperations.findMovie(empty, "Nomadland");
        displayResults (result==-1, "findMovieTest - empty array");

        result = MovieArrayOperations.findMovie(movies4, "Minari");
        displayResults (result==2, "findMovieTest - middle non-empty array");

    }


    public static void getMoviesWithActorTest() {
        Movie[] empty = {};
        Movie[] movies4 = {maidInManhattan, spaceJam, monsterInLaw, ladyBird};

        Movie[] result;

        Movie[] expectedEmpty = {};
        result = MovieArrayOperations.getMoviesWithActor(empty, "Lopez");
        displayResults (Arrays.equals(result, expectedEmpty), "getMoviesWithActor - empty array");

        Movie[] expected2 = {maidInManhattan, monsterInLaw};
        result = MovieArrayOperations.getMoviesWithActor(movies4, "Lopez");
        displayResults (Arrays.equals(result, expected2), "getMoviesWithActor - non empty array");

    }

    public static void countMoviesWithActorTest(){

        Movie[] empty = {};
        Movie[] movies4 = {nomadland, moneyball, ladyBird, spaceJam};

        int result = 0;
        int expected = 0;

        result = MovieArrayOperations.countMoviesWithActor(empty, "Lopez");
        displayResults(result == expected, "countMoviesWithActorTest - empty array");

        result = MovieArrayOperations.countMoviesWithActor(movies4, "Lopez");
        expected = 0;
        displayResults(result == expected, "countMoviesWithActorTest - Lopez");
    }

    public static void getLeadActorTest() {

        Movie[] empty = {};
        Movie[] movies4 = {nomadland, moneyball, ladyBird, spaceJam};

        String result;

        result = MovieArrayOperations.getLeadActor(empty, "Nomadland");
        displayResults (result.equals(""), "getLeadActorTest - empty array");

        result = MovieArrayOperations.getLeadActor(movies4, "Moneyball");
        displayResults (result.equals("Brad Pitt"), "getLeadActorTest - middle non-empty array");

        result = MovieArrayOperations.getLeadActor(movies4, "Lady Bird");
        displayResults (result.equals(""), "getLeadActorTest - no leadActor non-empty array");

    }

    public static void addMovieTest() {
        Movie[] empty = {};
        Movie[] movies3 = {maidInManhattan, spaceJam, monsterInLaw};

        Movie[] result;

        Movie[] expected3 = {maidInManhattan, spaceJam, monsterInLaw, moneyball};
        result = MovieArrayOperations.addMovie(movies3, moneyball);
        displayResults (Arrays.equals(result, expected3), "addMovieTest - non empty array");

    }

    public static void removeMovieTest() {
        Movie[] empty = {};
        Movie spaceJam2 = new Movie("Space Jam", 1996);
        Movie[] movies6 = {maidInManhattan, spaceJam, monsterInLaw, ladyBird, spaceJam2, moneyball};

        Movie[] result;

        Movie[] expectedEmpty = {};
        result = MovieArrayOperations.removeMovie(empty, "Maid in Manhattan");
        displayResults (Arrays.equals(result, expectedEmpty), "removeMovieTest - empty array");

        Movie[] expectedMid = {maidInManhattan, spaceJam, monsterInLaw, spaceJam2, moneyball};
        result = MovieArrayOperations.removeMovie(movies6, "Lady Bird");
        // uncomment to print the result array
        // System.out.println("result array: " + Arrays.toString(result));
        displayResults (Arrays.equals(result, expectedMid), "removeMovieTest - middle non empty array");

    }


    public static void getMovieWithOldestActorTest() {
        Movie[] empty = {};
        Movie[] moviesFront = {nomadland, spaceJam, monsterInLaw, moneyball};
        Movie[] moviesBack = {spaceJam, monsterInLaw, moneyball, minari};
        Movie[] moviesMiddle = {ladyBird, spaceJam, maidInManhattan, minari};
        Movie[] noActors = {ladyBird, minari};

        Movie result = MovieArrayOperations.getMovieWithOldestActor(empty);
        displayResults (result == null, "getMovieWithOldestActorTest - empty array");

        result = MovieArrayOperations.getMovieWithOldestActor(moviesFront);
        displayResults (result == nomadland, "getMovieWithOldestActorTest - front non-empty array");

        result = MovieArrayOperations.getMovieWithOldestActor(moviesBack);
        displayResults (result == moneyball, "getMovieWithOldestActorTest - end non-empty array");

        result = MovieArrayOperations.getMovieWithOldestActor(moviesMiddle);
        displayResults (result == spaceJam, "getMovieWithOldestActorTest - middle non-empty array");

        result = MovieArrayOperations.getMovieWithOldestActor(noActors);
        displayResults (result == null, "getMovieWithOldestActorTest - not found non-empty array");

    }
}
