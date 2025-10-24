package homeaway;

import java.io.Serializable;

public interface Services extends Comparable<Services>, ServicesChange {

    String getServiceName();
    double getServicePrice();
    String getServiceType();
    long getLatitude();
    long getLongitude();
    double getValue();
    int getLastUpdatedOrder();
    int getAverageStars();
    float getTotalStars();
    int getRatingCount();
}
