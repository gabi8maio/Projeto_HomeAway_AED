package homeaway;

public class ThriftyClass extends StudentsClassAbstract implements Thrifty, Students {

    ThriftyClass(String studentType, String name, String country, String lodging) {
        super (studentType, name, country, lodging);
    }

    @Override
    public int compareTo(Students o) {
        return 0;
    }


}
