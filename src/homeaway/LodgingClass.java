package homeaway;

import dataStructures.DoublyLinkedList;

import java.io.Serializable;

public class LodgingClass extends ServicesClassAbstract implements Lodging, Serializable {

    public DoublyLinkedList<Students> studentsThere;

    public LodgingClass(long latitude, long longitude, Double price, Double value, String serviceName) {
        super(latitude,longitude,price,value,serviceName);
        studentsThere = new DoublyLinkedList<>();
    }

    @Override
    public String getServiceType() {
        return TypesOfService.LODGING.toString();
    }

    public boolean isFull(){
        return super.getValue() == studentsThere.size();
    }
}
