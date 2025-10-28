package homeaway;

import dataStructures.Iterator;
import dataStructures.TwoWayIterator;

import java.io.Serializable;

public interface Services extends Comparable<Services>, ServicesChange {

    String getServiceName();
    double getServicePrice();
    String getServiceType();
    long getLatitude();
    boolean didEvaluationChanged();
    long getLongitude();
    int getValue();
    int getLastUpdatedOrder();
    int getAverageStars();
    float getTotalStars();
    int getRatingCount();
    Iterator<String> getTags();
    TwoWayIterator<Students> getStudentsThere();
    String isFull();

    boolean isThereAnyStudents();
}
