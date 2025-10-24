package homeaway;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class BookishClass extends StudentsClassAbstract implements Bookish, Students, Serializable {

    private LinkedList<Services> visitedLeisureServices;

    BookishClass (String type, String name, String country, Services lodging) {
        super(type, name, country, lodging);
        visitedLeisureServices = new LinkedList<>();
    }

    public void addVisitedService(Services services){
        visitedLeisureServices.addLast(services);
    }

    public Iterator<Services> getAllVisitedServices(){
        return visitedLeisureServices.iterator();
    }


}
