package homeaway;

import java.io.Serializable;

public class ThriftyClass extends StudentsClassAbstract implements Thrifty, Students, Serializable {

    ThriftyClass(String studentType, String name, String country, String lodging) {
        super (studentType, name, country, lodging);
    }

}
