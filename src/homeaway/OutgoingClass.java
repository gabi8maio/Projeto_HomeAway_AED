package homeaway;


import dataStructures.DoublyLinkedList;

import java.io.Serializable;
import dataStructures.*;

public class OutgoingClass extends StudentsClassAbstract implements Outgoing, Students, Serializable {

    private DoublyLinkedList<Services> allVisitedServices;

    OutgoingClass(String type, String name, String country, Services lodging) {
        super(type, name, country, lodging);
        allVisitedServices = new DoublyLinkedList<Services>();
    }

    public void addVisitedService(Services service){
        allVisitedServices.addLast(service);
    }

    public Iterator<Services> getAllVisitedServices(){
        return allVisitedServices.iterator();
    }

}
