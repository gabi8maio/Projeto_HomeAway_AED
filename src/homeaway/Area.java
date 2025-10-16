package homeaway;

import dataStructures.DoublyIterator;
import dataStructures.TwoWayDoublyIterator;

public interface Area {

    String getName();
    void removeStudent();
    boolean studentExists();
    boolean lodgingExists();
    void createService();
    boolean serviceExists();
    boolean isPriceValid();
    boolean isValueValid();
    DoublyIterator<Services> serviceIterator();
    boolean isLodging();
    boolean isAlreadyThere();
    boolean IsItFull();
    void changedLodging();
    Services whereIsStudent();
    TwoWayDoublyIterator locationStudentIterator();
    DoublyIterator rankServicesIterator();
    long getDistance();
    DoublyIterator rankedCommand();
    Services findCommand();
}
