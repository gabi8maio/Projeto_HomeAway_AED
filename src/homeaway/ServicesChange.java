package homeaway;

public interface ServicesChange {
    void updateCounterRating(int counter);
    void addRating(int stars,String tag, int counter);
    void addTag(String tag);
    void addStudentsThere(Students newStudent);
    void removeStudentsThere(Students student);
    void addStudentsThereLodging();
    void removeStudentsThereLodging();
    void setNumOfInsertion(int counter);
}
