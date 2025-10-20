package homeaway;



public class OutgoingClass extends StudentsClassAbstract implements Outgoing, Students {


    OutgoingClass(String type, String name, String country, String lodging) {
        super(type, name, country, lodging);
    }

    @Override
    public int compareTo(Students o) {
        return 0;
    }
}
