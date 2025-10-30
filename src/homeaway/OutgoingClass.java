package homeaway;


import dataStructures.DoublyLinkedList;

import java.io.Serializable;
import dataStructures.*;

public class OutgoingClass extends StudentsClassAbstract implements Outgoing, Students{

    private DoublyLinkedList<Services> allVisitedServices;

    private static final long serialVersionUID = 0L;

    OutgoingClass(String type, String name, String country, Services lodging) {
        super(type, name, country, lodging);
        allVisitedServices = new DoublyLinkedList<Services>();
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
