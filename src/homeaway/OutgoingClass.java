package homeaway;


import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class OutgoingClass extends StudentsClassAbstract implements Outgoing, Students, Serializable {

    private LinkedList<Services> allVisitedServices;

    OutgoingClass(String type, String name, String country, Services lodging) {
        super(type, name, country, lodging);
    }

    public void addVisitedService(Services service){
        allVisitedServices.addLast(service);
    }

    public Iterator<Services> getAllVisitedServices(){
        return allVisitedServices.iterator();
    }

}
