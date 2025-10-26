package homeaway;

import dataStructures.DoublyLinkedList;

import java.io.Serializable;

public class LodgingClass extends ServicesClassAbstract implements Lodging, Serializable {

    public LodgingClass(long latitude, long longitude, double price, int value, String serviceName) {
        super(latitude,longitude,price,value,serviceName);

    }

    @Override
    public String getServiceType() {
        return TypesOfService.LODGING.toString();
    }
}
