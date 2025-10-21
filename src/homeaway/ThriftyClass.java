package homeaway;

public class ThriftyClass extends StudentsClassAbstract implements Thrifty, Students {

    ThriftyClass(String studentType, String name, String country, String lodging) {
        super (studentType, name, country, lodging);
    }

}
