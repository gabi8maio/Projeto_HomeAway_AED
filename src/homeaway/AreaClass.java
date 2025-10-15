package homeaway;
import dataStructures.*;


public class AreaClass {

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

    public AreaClass(){

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
