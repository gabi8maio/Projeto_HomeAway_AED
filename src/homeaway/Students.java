package homeaway;

import java.io.Serializable;

public interface Students extends Comparable<Students>, StudentsChange, Serializable {
    String getName();
    String getType();
    String getCountry();
    Services getPlaceHome();
    Services getPlaceNow();
}
