package homeaway;

import java.io.Serializable;

public class BookishClass extends StudentsClassAbstract implements Outgoing, Students, Serializable {

    BookishClass (String type, String name, String country, String lodging) {
        super(type, name, country, lodging);
    }


}
