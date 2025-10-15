package homeaway;

import dataStructures.DoublyIterator;
import dataStructures.TwoWayDoublyIterator;

public interface Area {

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
    Service whereIsStudent();
    TwoWayDoublyIterator locationStudentIterator();
    DoublyIterator rankServicesIterator();
    long getDistance();
    DoublyIterator rankedCommand();
    Service findCommand();
}
