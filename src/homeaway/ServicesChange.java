package homeaway;

public interface ServicesChange {
    void updateCounterRating();
    void addRating(int stars,int counter);
    void addTag(String tag);
    void addStudentsThere(Students newStudent);
    void removeStudentsThere(Students student);
    void addStudentsThereLodging();
    void removeStudentsThereLodging();
}
