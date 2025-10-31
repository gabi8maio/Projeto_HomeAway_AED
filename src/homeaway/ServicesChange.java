package homeaway;

public interface ServicesChange {
    void updateCounterRating(int counter);
    void addRating(int stars,String tag, int counter);

    /**
     * Adds the Student that is on this Service
     * @param newStudent - the student to add
     */
    void addStudentsThere(Students newStudent);

    /**
     * Removes the Student that is on this Service
     * @param student - the student to remove
     */
    void removeStudentsThere(Students student);

    /**
     * Increments by one the number of students that are living on Lodging
     */
    void addStudentsThereLodging();
    /**
     * Decrements by one the number of students that are living on Lodging
     */
    void removeStudentsThereLodging();

    /**
     * Set the number that was inserted on the Area.
     * (If the number is smaller than other the service is older)
     * @param counter The number of Insertion
     */
    void setNumOfInsertion(int counter);
}
