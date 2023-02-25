/*
 * A2Tester.java
 * The auto grading of your assignment will include tests with different values.
 *
 */
public class A2Tester {

    private static int testPassCount = 0;
    private static int testCount = 0;

    public static void main (String[] args) {

        actorConstructorGetterTests();
        actorSetterGetterTests();
        actorAddOscarsTests();
        actorGetAgeTests();
        actorToStringTests();

        movieConstructorGetterTests();
        movieSetterGetterTests();
        movieEqualsTests();
        movieToStringTests();

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

    public static void actorConstructorGetterTests() {
        // TODO: uncomment the following code to test this method
        /*
        Actor threeArguments = new Actor("Brad", "Pitt", 1963);
        displayResults (threeArguments.getFirstName().equals("Brad"), "Actor() Constructor Getter Test -firstName");
        displayResults (threeArguments.getLastName().equals("Pitt"), "Actor() Constructor Getter Test -lastName");
        displayResults (threeArguments.getBirthYear()  == 1963, "Actor() Constructor Getter Test -birthYear");
        displayResults (threeArguments.getNumOscars()  == 0, "Actor() Constructor Getter Test -numOscars");

        Actor fourArguments = new Actor("Jennifer", "Hudson", 1981, 1);
        displayResults (fourArguments.getFirstName().equals("Jennifer"), "Actor() Constructor Getter Test -firstName");
        displayResults (fourArguments.getLastName().equals("Hudson"), "Actor() Constructor Getter Test -lastName");
        displayResults (fourArguments.getBirthYear()  == 1981, "Actor() Constructor Getter Test -birthYear");
        displayResults (fourArguments.getNumOscars()  == 1, "Actor() Constructor Getter Test -numOscars");
        */

    }

    public static void actorSetterGetterTests() {
        // TODO: uncomment the following code to test this method
        /*
        Actor a1 = new Actor("Jennifer", "Lopez", 1969);

        a1.setFirstName("J");
        a1.setLastName("Lo");

        displayResults (a1.getFirstName().equals("J"), "Actor setFirstName Test");
        displayResults (a1.getLastName().equals("Lo"), "Actor setLastName  Test");

        a1.setFirstName("Jenny");
        a1.setLastName("From the Block");

        displayResults (a1.getFirstName().equals("Jenny"), "Actor setFirstName Test");
        displayResults (a1.getLastName().equals("From the Block"), "Actor setLastName  Test");
        */
    }


    public static void actorAddOscarsTests() {
        // TODO: uncomment the following code to test this method
        /*
        Actor a1 = new Actor("Jennifer", "Lopez", 1969);
        Actor a2 = new Actor("Brad", "Pitt", 1963, 2);

        a1.addOscars(0);
        a2.addOscars(0);

        displayResults (a1.getNumOscars() == 0, "Actor addOscars add 0 Test");
        displayResults (a2.getNumOscars() == 2, "Actor addOscars add 0 Test");

        a1.addOscars(3);
        a2.addOscars(2);

        displayResults (a1.getNumOscars() == 3, "Actor addOscars add 3 Test");
        displayResults (a2.getNumOscars() == 4, "Actor addOscars add 2 Test");

        a1.addOscars(1);
        a2.addOscars(1);

        displayResults (a1.getNumOscars() == 4, "Actor addOscars add 1 Test");
        displayResults (a2.getNumOscars() == 5, "Actor addOscars add 1 Test");
        */
    }

    public static void actorGetAgeTests() {
        // TODO: uncomment the following code to test this method
        /*
        Actor a1 = new Actor("Jennifer", "Lopez", 1969);
        Actor a2 = new Actor("Brad", "Pitt", 1963, 2);

        displayResults (a1.getAge(1969) == 0, "Actor getAge 0 Test");
        displayResults (a2.getAge(1963) == 0, "Actor getAge 0 Test");

        displayResults (a1.getAge(1970) == 1, "Actor getAge 1 Test");
        displayResults (a2.getAge(1964) == 1, "Actor getAge 1 Test");

        displayResults (a1.getAge(2021) == 52, "Actor getAge 2021 Test");
        displayResults (a2.getAge(2021) == 58, "Actor getAge 2021 Test");
        */
    }

    public static void actorToStringTests() {
        // TODO: uncomment the following code to test this method
        /*
        Actor a1 = new Actor("Jennifer", "Lopez", 1969);
        Actor a2 = new Actor("Brad", "Pitt", 1963, 2);
        displayResults (a1.toString().equals("Jennifer Lopez, born in 1969, has 0 Oscar awards"),
                        "Actor toString Test");
        displayResults (a2.toString().equals("Brad Pitt, born in 1963, has 2 Oscar awards"),
                        "Actor toString Test");

        */
    }

    public static void movieConstructorGetterTests() {
        // TODO: uncomment the following code to test this method
        /*
        Movie m1 = new Movie("Nomadland", 2020);
        Actor a = new Actor("Jennifer", "Lopez", 1969);
        Movie m2 = new Movie("Monster-in-Law", 2005, a);

        displayResults (m1.getTitle().equals("Nomadland"),
                        "Movie Constructor, null actor test");
        displayResults (m1.getReleaseYear() == 2020,
                        "Movie Constructor, null actor test");
        displayResults (m1.getLeadActor() == null,
                        "Movie Constructor, null actor test");

        displayResults (m2.getTitle().equals("Monster-in-Law"),
                        "Movie Constructor, non null actor test");
        displayResults (m2.getReleaseYear() == 2005,
                        "Movie Constructor, non null actor test");
        Actor lead =  m2.getLeadActor();
        displayResults (lead.getFirstName().equals("Jennifer"),
                        "Movie Constructor, non null actor test");
        displayResults (lead.getLastName().equals("Lopez"),
                        "Movie Constructor, non null actor test");
        displayResults (lead.getBirthYear() == 1969,
                        "Movie Constructor, non null actor test");
        displayResults (lead.getNumOscars() == 0,
                        "Movie Constructor, non null actor test");
        */
    }

    public static void movieSetterGetterTests() {
        // TODO: uncomment the following code to test this method
        /*
        Actor a1 = new Actor("Jennifer", "Lopez", 1969);
        Movie m1 = new Movie("Monster-in-Law", 2005, a1);
        Actor a2 = new Actor("Jane", "Fonda", 1937, 2);
        Movie m2 = new Movie("Nomadland", 2020);
        Actor a3 = new Actor("Frances", "McDormand", 1957, 4);

        m1.setLeadActor(a2);
        Actor lead =  m1.getLeadActor();

        displayResults (lead.getFirstName().equals("Jane"),
                        "Actor setLeadActor non null Test");
        displayResults (lead.getLastName().equals("Fonda"),
                        "Actor setLeadActor non null Test");
        displayResults (lead.getBirthYear() == 1937,
                        "Actor setLeadActor non null Test");
        displayResults (lead.getNumOscars() == 2,
                        "Actor setLeadActor non null Test");

        m2.setLeadActor(a3);
        lead =  m2.getLeadActor();
        displayResults (lead.getFirstName().equals("Frances"),
                        "Actor setLeadActor  null Test");
        displayResults (lead.getLastName().equals("McDormand"),
                        "Actor setLeadActor  null Test");
        displayResults (lead.getBirthYear() == 1957,
                        "Actor setLeadActor  null Test");
        displayResults (lead.getNumOscars() == 4,
                        "Actor setLeadActor  null Test");
        */
    }

    public static void movieEqualsTests() {
        // TODO: uncomment the following code to test this method
        /*
        Actor a1 = new Actor("Jennifer", "Lopez", 1969);
        Actor a2 = new Actor("Jane", "Fonda", 1937, 2);

        Movie m = new Movie("Monster-in-Law", 2005, a1);
        Movie mEqualWithoutActor = new Movie("Monster-in-Law", 2005);
        Movie mEqualWithActor = new Movie("Monster-in-Law", 2005, a2);
        Movie mNotEqualTitle = new Movie("Monsters Inc", 2005);
        Movie mNotEqualYear = new Movie("Monster-in-Law", 2020);
        Movie mNotEqual = new Movie("Monster-in-Law", 2020);

        displayResults (m.equals(m) == true, "Movie equal same instance test");
        displayResults (m.equals(mEqualWithoutActor) == true, "Movie equals same movie test");
        displayResults (mEqualWithoutActor.equals(m) == true, "Movie equals same movie test");
        displayResults (m.equals(mEqualWithActor) == true, "Movie equals same movie test");

        displayResults (m.equals(mNotEqualTitle) == false, "Movie equals not same title test");
        displayResults (m.equals(mNotEqualYear) == false, "Movie equals not same year test");
        displayResults (m.equals(mNotEqual) == false, "Movie equals not same year and title test");
        */
    }

    public static void movieToStringTests() {
        // TODO: uncomment the following code to test this method
        /*
        Actor a = new Actor("Jane", "Fonda", 1937, 2);
        Movie m1 = new Movie("Monster-in-Law", 2005, a);
        Movie m2 = new Movie("Nomadland", 2020);

        String expected1 = "Monster-in-Law, released in 2005, starring: Jane Fonda, born in 1937, has 2 Oscar awards";
        displayResults (m1.toString().equals(expected1), "Movie toString non-null leadActor Test");

        String expected2 = "Nomadland, released in 2020";
        displayResults (m2.toString().equals(expected2), "Movie toString null leadActor Test");
        */
    }
}
