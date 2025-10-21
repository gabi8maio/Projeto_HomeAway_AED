package homeaway;

public interface Services extends Comparable<Services> {

    String getServiceName();
    double getServicePrice();
    String getServiceType();
    long getLatitude();
    long getLongitude();
    double getValue();
}
