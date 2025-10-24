package homeaway;

public interface Students extends Comparable<Students>, StudentsChange {
    String getName();
    String getType();
    String getCountry();
    Services getPlaceHome();
    Services getPlaceNow();
}
