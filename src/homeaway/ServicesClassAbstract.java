package homeaway;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.TwoWayIterator;
import dataStructures.TwoWayList;

import java.io.Serializable;
import java.lang.reflect.Type;

public abstract class ServicesClassAbstract implements Services, ServicesChange, Serializable {

    private final long latitude;
    private final long longitude;
    private final double price;
    private int numOfPeople;
    private final String serviceName;
    private int lastUpdateCounter;
    private int averageStars;
    private int totalStars;
    private int rating;
    int studentsThereLodging;

    public TwoWayList<Students> studentsThere;
    private DoublyLinkedList<String> tags;

    public ServicesClassAbstract(long latitude, long longitude, double price, int numOfPeople, String serviceName) {
        this.serviceName = serviceName;
        this.numOfPeople = numOfPeople;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
        tags = new DoublyLinkedList<>();
        studentsThere = new DoublyLinkedList<>();
        studentsThereLodging = 0;
    }

    public void addStudentsThere(Students newStudent){
        studentsThere.addLast(newStudent);
    }

    public void removeStudentsThere(Students student){
        int position = studentsThere.indexOf(student);
        if (position != -1) {
            studentsThere.remove(position);
        }
    }

    public void addStudentsThereLodging(){
        studentsThereLodging++;
    }
    public void removeStudentsThereLodging(){
        studentsThereLodging--;
    }



    public String isFull(){
        if(getServiceType().equalsIgnoreCase(TypesOfService.LODGING.toString()))
            if(getValue() == studentsThereLodging) return getServiceName();

        if(getValue() == studentsThere.size()) return getServiceName();
        return null;
    }

    @Override
    public int compareTo(Services o) {
        return 0;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public double getServicePrice() {
        return price;
    }

    @Override
    public long getLatitude() {
        return latitude;
    }

    @Override
    public long getLongitude() {
        return longitude;
    }

    @Override
    public int getValue() {
        return numOfPeople;
    }


    public int getLastUpdatedOrder() {
        return lastUpdateCounter;
    }

    public int getAverageStars() {
        return averageStars;
    }

    public float getTotalStars() {
        return totalStars;
    }

    public int getRatingCount() {
        return rating;
    }

    public Iterator<String> getTags(){
        return tags.iterator();
    }

    public TwoWayIterator<Students> getStudentsThere(){
        return studentsThere.twoWayiterator();
    }

    public void addTag(String tag){
        tags.addLast(tag);
    }

    public void updateCounterRating() {
        lastUpdateCounter++;
    }

    public void addRating(int stars, int counter) {
        totalStars += stars;
        rating++;
        lastUpdateCounter = counter;
    }
}

