package homeaway;

public class BookishClass extends StudentsClassAbstract implements Outgoing, Students {

    BookishClass (String type, String name, String country, String lodging) {
        super(type, name, country, lodging);
    }

    @Override
    public int compareTo(Students o) {
        return 0;
    }
}
