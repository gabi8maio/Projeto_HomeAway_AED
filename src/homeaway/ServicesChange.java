package homeaway;

public interface ServicesChange {
    void updateCounterRating();
    void addRating(int stars,int counter);
    void addTag(String tag);
    void addOneStudent();
    void removeOneStudent();
    void addStudentsThere(Students newStudent);
    void removeStudentsThere(Students student);
}
