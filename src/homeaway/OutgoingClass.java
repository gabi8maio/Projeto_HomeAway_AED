package homeaway;


import java.io.Serializable;

public class OutgoingClass extends StudentsClassAbstract implements Outgoing, Students, Serializable {


    OutgoingClass(String type, String name, String country, String lodging) {
        super(type, name, country, lodging);
    }


}
