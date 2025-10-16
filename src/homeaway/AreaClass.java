package homeaway;
import dataStructures.*;

import java.io.Serial;
import java.io.Serializable;


public class AreaClass implements Area, Serializable {

    public long topLatitude;
    public long bottomLatitude;
    public long leftLongitude;
    public long rightLongitude;
    public String areaName;
    public DoublyLinkedList<Services> services;
    public SortedDoublyLinkedList<Services> servicesByRank;
    public SortedDoublyLinkedList<Students> allStudents;
    public DoublyLinkedList<Students> studentsByCountry;
    public ListInArray<Services> LeisureServices;
    public ListInArray<Services> EatingServices;
    public ListInArray<Services> LodgingServices;

    public AreaClass(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude){
        areaName = name;
        this.topLatitude = topLatitude;
        this.bottomLatitude = bottomLatitude;
        this.leftLongitude = leftLongitude;
        this.rightLongitude = rightLongitude;
    }

    public String getName() {
        return areaName;
    }

    public void removeStudent() {
    }

    public boolean studentExists() {
        return false;
    }

    public boolean lodgingExists() {
        return false;
    }

    public void createService() {
    }

    public boolean serviceExists() {
        return false;
    }

    public boolean isPriceValid() {
        return false;
    }

    public boolean isValueValid() {
        return false;
    }

    public DoublyIterator<Services> serviceIterator() {
        return null;
    }

    public boolean isLodging() {
        return false;
    }

    public boolean isAlreadyThere() {
        return false;
    }

    public boolean IsItFull() {
        return false;
    }

    public void changedLodging() {
    }

    public Services whereIsStudent() {
        return null;
    }

    public TwoWayDoublyIterator locationStudentIterator() {
        return null;
    }

    public DoublyIterator rankServicesIterator() {
        return null;
    }

    public long getDistance() {
        return 0;
    }

    public DoublyIterator rankedCommand() {
        return null;
    }

    public Services findCommand() {
        return null;
    }
}
