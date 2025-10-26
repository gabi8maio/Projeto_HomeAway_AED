package homeaway;

import dataStructures.Iterator;

import java.io.Serializable;

public interface Services extends Comparable<Services>, ServicesChange {

    String getServiceName();
    double getServicePrice();
    String getServiceType();
    long getLatitude();
    long getLongitude();
    int getValue();
    int getLastUpdatedOrder();
    int getAverageStars();
    float getTotalStars();
    int getRatingCount();
    Iterator<String> getTags();
    String isFull();
}
