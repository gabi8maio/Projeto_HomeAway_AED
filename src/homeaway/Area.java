package homeaway;

import dataStructures.DoublyIterator;
import dataStructures.Iterator;
import dataStructures.TwoWayDoublyIterator;

public interface Area {

    Iterator<Services> getServicesIterator();
    String getName();
    void removeStudent(String studentName);
    boolean studentExists(String name);
    boolean lodgingExists(String serviceName);
    void createService(String serviceType, long latitude, long longitude, Double price, Double value, String serviceName);
    boolean serviceExists(String serviceName);
    boolean isPriceValid();
    boolean isValueValid();
    DoublyIterator<Services> serviceIterator();
    boolean isLodging();
    boolean isAlreadyThere();
    boolean isItFull(String name);
    void changedLodging();
    Services whereIsStudent();
    TwoWayDoublyIterator<Students> locationStudentIterator();
    DoublyIterator<Services> rankServicesIterator();
    Iterator<Students> getAllStudentsIterator();
    Iterator<Students> getStudentsByCountryIterator();
    long getDistance();
    DoublyIterator<Students> rankedCommand();
    Services findCommand();

    void addStudent(String studentType, String name, String country, String lodging);
    boolean isInBounds (long latitude, long longitude);
}
