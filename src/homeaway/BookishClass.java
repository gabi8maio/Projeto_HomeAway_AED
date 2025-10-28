package homeaway;

import java.io.Serializable;
import dataStructures.*;

public class BookishClass extends StudentsClassAbstract implements Bookish, Students, Serializable {

    private TwoWayList<Services> visitedLeisureServices;

    BookishClass (String type, String name, String country, Services lodging) {
        super(type, name, country, lodging);
        visitedLeisureServices = new DoublyLinkedList<>();
    }

    public void addVisitedService(Services services){
        visitedLeisureServices.addLast(services);
    }

    public Iterator<Services> getAllVisitedServices(){
        return visitedLeisureServices.iterator();
    }


}
