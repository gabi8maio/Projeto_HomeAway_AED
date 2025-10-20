package homeaway;
import dataStructures.*;
import dataStructures.exceptions.InvalidPositionException;

import java.io.InvalidObjectException;
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

        // Isto parece uma javardice aqui ns
        Comparator<Students> studentComparatorByName = (s1, s2) ->
                s1.getName().compareTo(s2.getName());
       // Comparator<Services> serviceComparatorByRank = (s1, s2) ->
         //       s1.getServicePrice().compareTo(s2.getServicePrice());

        areaName = name;
        this.topLatitude = topLatitude;
        this.bottomLatitude = bottomLatitude;
        this.leftLongitude = leftLongitude;
        this.rightLongitude = rightLongitude;
        services = new DoublyLinkedList<>();
        LodgingServices = new ListInArray<>(100);
        LeisureServices = new ListInArray<>(100);
        EatingServices = new ListInArray<>(100);
        studentsByCountry = new DoublyLinkedList<>();
        allStudents = new SortedDoublyLinkedList<>(studentComparatorByName); // Need to change
        servicesByRank = new SortedDoublyLinkedList<>(null); // Need to change

    }

    @Override
    public Iterator<Services> getServicesIterator() {
        return services.iterator();
    }

    public String getName() {
        return areaName;
    }

    @Override
    public void removeStudent(String studentName) {
        Students student = findStudentElem(studentName);
        if(student == null) throw new InvalidPositionException(); // Isto em principio n vai acontecer
        allStudents.remove(student);
    }
    private Students findStudentElem(String name){
        Iterator<Students> it = allStudents.iterator();
        while (it.hasNext()) {
            Students s = it.next();
            if (s.getName().equals(name)) return s;
        }
       return null;
    }

    public boolean studentExists(String name) {
        Iterator<Students> it = allStudents.iterator();
        while (it.hasNext()) {
            Students s = it.next();
            if (s.getName().equals(name)) return true;
        }
        return false;
    }

    public Iterator<Students> getAllStudentsIterator(){
        return allStudents.iterator();
    }

    public Iterator<Students> getStudentsByCountryIterator(){
        return studentsByCountry.iterator();
    }

    public boolean lodgingExists(String serviceName) {
        if(LodgingServices == null) return false;
        for(int i = 0; i < LodgingServices.size(); i++)
            if(LodgingServices.get(i).getServiceName().equals(serviceName)) return true;
        return false;
    }

    public void createService(String serviceType, long latitude, long longitude, Double price, Double value, String serviceName) {

        Services newService = null;
        TypesOfService type = TypesOfService.fromString(serviceType);

        switch (type) {
            case LODGING:
                newService = new LodgingClass(latitude, longitude, price, value, serviceName);
                LodgingServices.addLast(newService);
                break;
            case EATING:
                newService = new EatingClass(latitude, longitude, price, value, serviceName);
                EatingServices.addLast(newService);
                break;
            case LEISURE:
                newService = new LeisureClass(latitude, longitude, price, value, serviceName);
                LeisureServices.addLast(newService);
                break;
        }
        services.addFirst(newService);
    }

    public boolean serviceExists(String serviceName) {
        if(services == null) return false;
        for(int i = 0; i < services.size(); i++)
            if(services.get(i).getServiceName().equals(serviceName)) return true;
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

    public boolean isItFull(String name) {
        Iterator<Services> iterator = LodgingServices.iterator();
        while(iterator.hasNext()) {
            Services service = iterator.next();
            if(service.getServiceName().equals(name))
                if (service instanceof Lodging lodging) // If it's Lodging
                    return lodging.isFull();
        }
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

    public void addStudent(String studentType, String name, String country, String lodging) {
        Students newStudent = null;
        StudentTypes type = StudentTypes.fromString(studentType);
        switch (type) {
            case OUTGOING -> newStudent = new OutgoingClass (studentType, name, country, lodging);
            case BOOKISH -> newStudent = new BookishClass(studentType, name, country, lodging);
            case THRIFTY -> newStudent = new ThriftyClass(studentType, name, country, lodging);
        }
        allStudents.add(newStudent);
    }
}
