/*
 * Triage.java
 */

public class Triage {

    private PriorityQueue patients;

    /*
     * Purpose:
     *  initialize patients to a new HeapPriorityQueue of default size
     */
    public Triage() {
        // TODO...
        patients = new HeapPriorityQueue();

    }

    /*
     * Purpose:
     *  initialize patients to a new empty HeapPriorityQueue with a capacity
     *    of given size
     *
     * Parameters:
     *    int size
     *
     * Precondition: size > 0
     */
    public Triage(int size) {
        // TODO...
        patients = new HeapPriorityQueue(size);
    }

    /*
     * Purpose:
     *  add given Patient p to patients if it is not full and
     *  prints a notification message if the Triage is full
     *
     * Parameters:
     *  Patient p - Patient to be added
     *
     * Returns:
     *  void
     */
    public void addPatient(Patient p) {
        // TODO...
        try {
            patients.insert(p);
        } catch (Exception e) {
            
        }
    }

    /*
     * Purpose:
     *  returns that number of Patients in patients
     *
     * Parameters:
     *  None.
     *
     * Returns:
     *  int - number of patients in He
     */
    public int numPatientsWaiting() {
        // TODO...
        return patients.size();
    }

    /*
     * Purpose:
     *  removes and returns the next Patient from patients
     *
     * Parameters:
     *  None.
     *
     * Returns:
     *  Patient - the next patient, null if there is no more Patients.
     */
    public Patient nextPatient() {
        // TODO...
        try {
            return (Patient)patients.removeHigh();
        } catch (QueueEmptyException e) {
            return null;
        }
    }
}
