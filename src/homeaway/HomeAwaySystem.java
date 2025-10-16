package homeaway;

public interface HomeAwaySystem {
    void addTemporaryArea(Area area);

    boolean hasArea(String name);

    String getTempAreaName();
    String saveArea();
    void loadArea(String name);
}
