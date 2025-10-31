package homeaway;

import java.io.Serializable;

public interface Students extends Comparable<Students>, StudentsChange, Serializable {

    /**
     * @return - The name of the student
     */
    String getName();

    /**
     * @return - The type of the student
     */
    String getType();

    /**
     * @return - The country where the student was born
     */
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
