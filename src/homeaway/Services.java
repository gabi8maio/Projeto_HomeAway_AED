package homeaway;

public interface Services extends Comparable<Services> {

    String getServiceName();
    int getServicePrice();
    String getServiceType();
    long getLatitude();
    long getLongitude();
    double getPrice();
    double getValue();
}
