package homeaway;

import java.io.Serializable;

public interface Students extends Comparable<Students>, StudentsChange, Serializable {
    String getName();
    String getType();
    String getCountry();

    /**
     * @return - The Object with the Students Home
     */
    Services getPlaceHome();
    /**
     * @return - The Object with the place at the moment
     */
    Services getPlaceNow();
}
