package homeaway;


import dataStructures.DoublyLinkedList;

import java.io.Serializable;
import dataStructures.*;

public class OutgoingClass extends StudentsClassAbstract implements Outgoing, Students, Serializable {

    private DoublyLinkedList<Services> allVisitedServices;

    OutgoingClass(String type, String name, String country, Services lodging) {
        super(type, name, country, lodging);
        allVisitedServices = new DoublyLinkedList<>();
        allVisitedServices.addLast(lodging);
    }

    public void addVisitedService(Services service){
        if(allVisitedServices.indexOf(service) == -1)
            allVisitedServices.addLast(service);
    }

    public Iterator<Services> getAllVisitedServices(){
        return allVisitedServices.iterator();
    }

    public boolean hasVisitedLocation() {
        return !allVisitedServices.isEmpty();
    }
}
