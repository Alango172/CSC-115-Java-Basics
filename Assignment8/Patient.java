/*
 * Patient.java
 */

public class Patient implements Comparable<Patient>{

    private int priority;
    private String name;
    private int carecard;
    private String initAssessment;

    public Patient(int priority, String name, int carecard, String initAssessment) {
        this.priority = priority;
        this.name = name;
        this.carecard = carecard;
        this.initAssessment = initAssessment;
    }

    /*
     * Purpose:
     *  Computes and returns a relative difference between this Patient and
     *  other Patient based on priority for order.
     *  Difference is a negative integer, zero, or a positive integer as this Patient priority
     *  is less than, equal to, or greater than the other Patient respectively.
     *
     * Parameters:
     *   Patient other - Patient to compare to
     *
     * Returns:
     *  int - the relative difference
     */
     public int compareTo(Patient other) {
         // if they are the same Patient (same caredcard) return 0
         if (this == other ||
            Integer.valueOf(this.carecard).compareTo(Integer.valueOf(other.carecard)) == 0) {
            return 0;
         }
         return Integer.valueOf(this.priority).compareTo(Integer.valueOf(other.priority));
     }

    /*
     * Purpose:
     *  deterimine whether this Patient is the same Patient
     *  by comparing this carecard to other Patient's carecard
     *
     * Parameters:
     *   Patient other - Patient to compare to
     *
     * Returns:
     *  boolean - true if other is same Patient as this patient
     */
     public boolean equals(Object other) {
         if (other == null || !(other instanceof Patient)) {
             return false;
         }
         Patient otherPatient = (Patient) other;
         return Integer.valueOf(this.carecard).equals(Integer.valueOf(otherPatient.carecard));
     }

    public String toString() {
        return carecard + ": " + name;
    }
}
