package homeaway;

import dataStructures.DoublyLinkedList;

public class LodgingClass extends ServicesClassAbstract implements Lodging{

    public DoublyLinkedList<Students> studentsThere;


    public LodgingClass(long latitude, long longitude, Double price, Double value, String serviceName) {
        super(latitude,longitude,price,value,serviceName);
        studentsThere = new DoublyLinkedList<>();
    }

    @Override
    public String getServiceType() {
        return "";
    }

    @Override
    public long getLatitude() {
        return 0;
    }

    @Override
    public long getLongitude() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getValue() {
        return super.getValue();
    }

    public boolean isFull(){
        return super.getValue() == studentsThere.size();
    }
}
