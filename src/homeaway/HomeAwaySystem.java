package homeaway;

public interface HomeAwaySystem {
    void addTemporaryArea(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude);

    boolean hasArea(String name);

    String getTempAreaName();
    String saveArea();
    void loadArea(String name);
}
