package homeaway;

public interface ServicesChange {
    void addRating(int stars,String tag, int counter);
    void addTag(String tag);
    void addStudentsThere(Students newStudent);
    void removeStudentsThere(Students student);
    void updateCounterRating(int counter);
    void addStudentsThereLodging();
    void removeStudentsThereLodging();
}
