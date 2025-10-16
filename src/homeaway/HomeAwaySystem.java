package homeaway;

public interface HomeAwaySystem {
    void addTemporaryArea(Area area);

    boolean hasArea(String name);

    String getTempAreaName();
    void saveArea();
    void loadArea(String name);
}
