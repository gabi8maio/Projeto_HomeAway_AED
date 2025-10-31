package homeaway;

import dataStructures.Iterator;
import dataStructures.TwoWayIterator;

import java.io.Serializable;

public interface Services extends Comparable<Services>, ServicesChange, Serializable {

    String getServiceName();

    String getServiceType();
    long getLatitude();
    long getLongitude();
    int getNumOfInsertion();
    int getValue();
    int getLastUpdatedOrder();
    int getAverageStars();

    /**
     * @return - An iterator of the tags that a service was tagged with
     */
    Iterator<String> getTags();
    TwoWayIterator<Students> getStudentsThere();
    String isFull();

    boolean isThereAnyStudents();
}
