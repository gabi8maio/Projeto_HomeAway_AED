package homeaway;
import dataStructures.*;
import dataStructures.exceptions.InvalidPositionException;

import java.io.InvalidObjectException;
import java.io.Serializable;


public class AreaClass implements Area, Serializable {

    private long topLatitude;
    private long bottomLatitude;
    private long leftLongitude;
    private long rightLongitude;
    private String areaName;
    private DoublyLinkedList<Services> services;
    private SortedDoublyLinkedList<Services> servicesByRank;
    private SortedList<Students> allStudents;
    private DoublyLinkedList<Students> studentsByCountry;
    //private ListInArray</*ListDoubluy...*/> leisureServices; // Tirar estas tres var, e meter apenas uma
    //private ListInArray<Services> eatingServices;
    //private ListInArray<Services> lodgingServices;

//sss
    @SuppressWarnings("unchecked")
    public AreaClass(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude){

        // Isto parece uma javardice aqui ns
        //Comparator<Students> studentComparatorByName = (s1, s2) -> s1.getName().compareTo(s2.getName());
       // Comparator<Services> serviceComparatorByRank = (s1, s2) ->
         //       s1.getServicePrice().compareTo(s2.getServicePrice());


        areaName = name;
        this.topLatitude = topLatitude;
        this.bottomLatitude = bottomLatitude;
        this.leftLongitude = leftLongitude;
        this.rightLongitude = rightLongitude;
        services = new DoublyLinkedList<>();
        //lodgingServices = new ListInArray<>(100);
        //leisureServices = new ListInArray<>(100);
        //eatingServices = new ListInArray<>(100);
        studentsByCountry = new DoublyLinkedList<>();
        allStudents = new SortedDoublyLinkedList<>((Comparator<Students>) new studentComparatorByName()); // Need to change
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
        Iterator<Services> it = services.iterator();
        while (it.hasNext()) {
            Services s = it.next();
            if (s.getServiceName().equals(serviceName)) return true;
        }
        return false;
    }

    public void createService(String serviceType, long latitude, long longitude, Double price, Double value, String serviceName) {

        Services newService = null;
        TypesOfService type = TypesOfService.fromString(serviceType);

        switch (type) {
            case LODGING:
                newService = new LodgingClass(latitude, longitude, price, value, serviceName);
                lodgingServices.addLast(newService);
                break;
            case EATING:
                newService = new EatingClass(latitude, longitude, price, value, serviceName);
                eatingServices.addLast(newService);
                break;
            case LEISURE:
                newService = new LeisureClass(latitude, longitude, price, value, serviceName);
                leisureServices.addLast(newService);
                break;
        }
        services.addLast(newService);
    }

    public boolean serviceExists(String serviceName) {
        Iterator<Services> it = services.iterator();
        while (it.hasNext()) {
            Services s = it.next();
            if (s.getServiceName().equals(serviceName)) return true;
        }
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
        Iterator<Services> iterator = lodgingServices.iterator();
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

    public boolean isInBounds (long latitude, long longitude) {
        return latitude >= this.bottomLatitude && latitude <= this.topLatitude &&
                longitude >= this.rightLongitude && longitude <= this.leftLongitude;
    }
}
