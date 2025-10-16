package homeaway;

public interface HomeAwaySystem {
    void addTemporaryArea(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude);

    boolean hasArea(String name);
    boolean serviceNameExists(String name);
    void addService(String serviceType,long latitude,long longitude,Double price,Double value,String serviceName);
    String getTempAreaName();
    String saveArea();
    void loadArea(String name);
}
