package homeaway;
import dataStructures.*;
import dataStructures.exceptions.InvalidPositionException;

import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class AreaClass implements Serializable {

    private long topLatitude;
    private long bottomLatitude;
    private long leftLongitude;
    private long rightLongitude;
    private String areaName;
    private DoublyLinkedList<Services> services;
    private SortedDoublyLinkedList<Services> servicesByRank;
    private SortedList<Students> allStudents;
    private DoublyLinkedList<Students> studentsByCountry;
    int updateCounter;
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
        allStudents = new SortedDoublyLinkedList<>(new studentComparatorByName()); // Need to change
        servicesByRank = new SortedDoublyLinkedList<>(new ServiceComparatorByStars()); // Need to change

    }


    public Iterator<Services> getServicesIterator() {
        return services.iterator();
    }

    public String getName() {
        return areaName;
    }


    public void removeStudent(String studentName) {
        Students student = findStudentElem(studentName);
        if(student == null) throw new InvalidPositionException(); // Isto em principio n vai acontecer
        allStudents.remove(student);
    }

    //TODO: utilizar iterador filtrado
    private Students findStudentElem(String name){
        Iterator<Students> it = allStudents.iterator();
        while (it.hasNext()) {
            Students s = it.next();
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
       return null;
    }
    private Services findServicesElem(String name){
        Iterator<Services> it = services.iterator();
        while (it.hasNext()) {
            Services s = it.next();
            if (s.getServiceName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public boolean isServiceMoreExpensiveForThrifty(String studentName, String serviceName){
        Students student = findStudentElem(studentName);
        Services newService = findServicesElem(serviceName);
        if(student instanceof Thrifty thrifty){
            return thrifty.isMoreExpensiveThanCheapest(newService);
        }
        return false;
    }


    public String goStudentToLocation(String studentName, String serviceName){
        Students student = findStudentElem(studentName);
        Services newService = findServicesElem(serviceName);

        assert student != null; // Deixamos??
        assert newService != null;

        if (student instanceof Bookish bookish && newService instanceof Leisure) bookish.addVisitedService(newService);
        else if (student instanceof Outgoing outgoing) outgoing.addVisitedService(newService);


        Services previousService = student.getPlaceNow();
        previousService.removeStudentsThere(student);    // Remove from previous Service
        newService.addStudentsThere(student);               // Add on new Service
        student.setPlaceGo(newService);
        return student.getName();

    }

    public void moveStudentToLocation(String studentName, String serviceName){
        Students student = findStudentElem(studentName);
        Services service = findServicesElem(serviceName);



        assert student != null; // Deixamos??
        student.setPlaceGo(service);
    }

    public String studentExists(String name) {
        Iterator<Students> it = allStudents.iterator();
        while (it.hasNext()) {
            Students s = it.next();
            if (s.getName().equalsIgnoreCase(name)) return s.getName();
        }
        return null;
    }

    public Students getStudent(String name) {
        Iterator<Students> it = allStudents.iterator();
        while (it.hasNext()) {
            Students s = it.next();
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public Iterator<Students> getAllStudentsIterator(){
        return allStudents.iterator();
    }

    public Iterator<Students> getStudentsByCountryIterator(String country){
        ListInArray<Students> tempList = new ListInArray<>(studentsByCountry.size()); // mudar sercalhar pra students by country
        Iterator<Students> iterator = studentsByCountry.iterator();
        while (iterator.hasNext()) {
            Students student = iterator.next();
            if (student.getCountry().equalsIgnoreCase(country)) tempList.addLast(student);
        }
        return tempList.iterator();
    }

    public boolean lodgingExists(String serviceName) {
        Iterator<Services> it = services.iterator();
        while (it.hasNext()) {
            Services s = it.next();
            if (s.getServiceName().equalsIgnoreCase(serviceName)) return true;
        }
        return false;
    }

    public void createService(String serviceType, long latitude, long longitude, double price, int value, String serviceName) {

        Services newService = null;
        TypesOfService type = TypesOfService.fromString(serviceType);

        switch (type) {
            case LODGING:
                newService = new LodgingClass(latitude, longitude, price, value, serviceName);
                break;
            case EATING:
                newService = new EatingClass(latitude, longitude, price, value, serviceName);
                break;
            case LEISURE:
                newService = new LeisureClass(latitude, longitude, price, value, serviceName);
                break;
        }
        services.addLast(newService);
    }

    // By type btw
    public String serviceExists(String serviceName) {

        Iterator<Services> it = services.iterator();
        while (it.hasNext()) {
            Services s = it.next();
            if((s.getServiceName().equalsIgnoreCase(serviceName))) return s.getServiceName();
        }
        return null;
    }

    public boolean isEatingOrLeisureService(String serviceName) {
        Iterator<Services> it = services.iterator();
        while (it.hasNext()) {
            Services s = it.next();
            if((s.getServiceName().equalsIgnoreCase(serviceName)) &&
                    (s.getServiceType().equalsIgnoreCase(TypesOfService.LEISURE.toString()) ||
                    s.getServiceType().equalsIgnoreCase(TypesOfService.EATING.toString()))) return true;
        }
        return false;
    }

    public boolean isStudentAtLocation(String studentName,String locationName){
        Iterator<Students> it = allStudents.iterator();
        while (it.hasNext()) {
            Students s = it.next();
            if((s.getName().equalsIgnoreCase(studentName))&&s.getPlaceNow().getServiceName().equalsIgnoreCase(locationName)) return true;
        }
        return false;
    }

    public boolean isEatingServiceFull(String serviceName){
        Iterator<Services> it = services.iterator();
        while (it.hasNext()) {
            Services s = it.next();
            if((s.getServiceName().equalsIgnoreCase(serviceName)) && s.isFull() != null ) return true;
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

    public boolean isLodging(Services service) {
        return service instanceof Lodging lodging;
    }

    public boolean isAlreadyThere() {
        return false;
    }

    public String isItFull(String name) {
        Iterator<Services> iterator = services.iterator();
        while(iterator.hasNext()) {
            Services service = iterator.next();
            if(service.getServiceName().equals(name))
                    return service.isFull();
        }
        return null;
    }

    public Students getStudentLocationInfo(String studentName){
        Iterator<Students> it = allStudents.iterator();
        while (it.hasNext()) {
            Students s = it.next();
            if((s.getName().equalsIgnoreCase(studentName))) return s;
        }
        return null;
    }

    public Iterator<Services> getVisitedLocationsIterator(String studentName){
        Students student = findStudentElem(studentName);
        if(student instanceof Outgoing outgoing) return outgoing.getAllVisitedServices();
        if(student instanceof Bookish bookish) return bookish.getAllVisitedServices();
        return null;
    }

    public void starCommand(int rating, String serviceName,String tag){
        Services service = findServicesElem(serviceName);
        assert service != null;
        service.addTag(tag); // ADd a  tag
        int oldUpdateCounter = service.getLastUpdatedOrder();
        int oldStars = service.getAverageStars();
        float newTotal = service.getTotalStars();
        int newCount = service.getRatingCount();
        int newStars = Math.round((newTotal + rating) / (newCount + 1));
        if(oldStars != newStars){
            updateCounter++;
            service.updateCounterRating();
            service.addRating(rating,updateCounter);
        }else
            service.addRating(rating,oldUpdateCounter);
    }

    public Iterator<Services> getServicesByRankingIterator(){
        return servicesByRank.iterator();
    }

    public Services findMostRelevantService(String studentName, String serviceType){
        Students student = getStudent(studentName);
        Services relevantService = null;

        if (student.getType().equals(StudentTypes.THRIFTY.toString())) {
            // Para thrifty: serviço mais barato
            relevantService = findCheapestService(serviceType);
        } else {
            // Para bookish e outgoing: serviço com melhor avaliação
            relevantService = findBestRatedService(serviceType);
        }

        return relevantService;
    }

    private Services findCheapestService(String serviceType) {
        Services cheapest = null;
        Iterator<Services> it = getServicesIterator();
        while (it.hasNext()) {
            Services service = it.next();
                if (service.getServiceType().equals(serviceType)) {
                    if (cheapest == null || service.getServicePrice() < cheapest.getServicePrice()) {
                        cheapest = service;
                    } else if (service.getServicePrice() == cheapest.getServicePrice()) {
                        // Em caso de empate: primeiro serviço inserido
                        if (service.getLastUpdatedOrder() < cheapest.getLastUpdatedOrder()) {
                            cheapest = service;
                        }
                    }
                }
        }
        return cheapest;
    }

    private Services findBestRatedService(String serviceType) {
        Services bestRated = null;
        Iterator<Services> it = getServicesIterator();
        while (it.hasNext()) {
            Services service = it.next();
            if (service.getServiceType().equals(serviceType)) {
                if (bestRated == null || service.getAverageStars() > bestRated.getAverageStars()) {
                    bestRated = service;
                } else if (service.getAverageStars() == bestRated.getAverageStars()) {
                    // Em caso de empate: mais tempo com esta média (lastUpdatedOrder mais antigo)
                    if (service.getLastUpdatedOrder() < bestRated.getLastUpdatedOrder()) {
                        bestRated = service;
                    }
                }
            }
        }
        return bestRated;
    }

    private boolean hasServicesOfType(String serviceType) {
        Iterator<Services> it = getServicesIterator();
        while (it.hasNext()) {
            Services service = it.next();
            if (service.getServiceType().equals(serviceType)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<Services> getServicesByTagIterator(String tag){
        Iterator<Services> it = services.iterator();
        DoublyLinkedList<Services> iteratorWithServices = new DoublyLinkedList<>();
        while (it.hasNext()) {
            Services s = it.next();
            Iterator<String> it2 = s.getTags();
            while (it.hasNext()){
                String tagService = it2.next();
                if(tagService.equals(tag)) iteratorWithServices.addLast(s);
            }
        }
        return null;
    }

    public Iterator<Services> getRankedServicesIterator(int stars,String type,String studentName){

        // 5. Ordenar por distância Manhattan e depois por lastUpdatedOrder
        Students student = findStudentElem(studentName);
        assert student != null;
        Services studentLocation = student.getPlaceNow();

        // Converter SortedDoublyLinkedList para array temporário
        Iterator<Services> iterator = servicesByRank.iterator();
        ListInArray<Services> tempList = new ListInArray<>(100);

        while (iterator.hasNext()) {
            Services service = iterator.next();
            if (service.getServiceType().equals(type) && service.getAverageStars() == stars) {
                tempList.addLast(service);
            }
        }

        // Calcular distância Manhattan para cada serviço
        // Bubble sort para ordenar por distância
        for (int i = 0; i < tempList.size() - 1; i++) {
            for (int j = 0; j < tempList.size() - i - 1; j++) {
                Services s1 = tempList.get(j);
                Services s2 = tempList.get(j + 1);

                long dist1 = calculateManhattanDistance(studentLocation, s1);
                long dist2 = calculateManhattanDistance(studentLocation, s2);

                if (dist1 > dist2) {
                    // Trocar
                    tempList.add(j, s2);
                    tempList.add(j + 1, s1);
                } else if (dist1 == dist2) {
                    // Distância igual, ordenar por lastUpdatedOrder (mais recente primeiro)
                    if (s1.getLastUpdatedOrder() < s2.getLastUpdatedOrder()) {
                        tempList.add(j, s2);
                        tempList.add(j + 1, s1);
                    }
                }
            }
        }

        // Ordenar por distância (mais perto primeiro) e depois por lastUpdatedOrder (mais recente primeiro)
        for (int i = 0; i < tempList.size() - 1; i++) {
            for (int j = 0; j < tempList.size() - i - 1; j++) {
                Services s1 = tempList.get(j);
                Services s2 = tempList.get(j + 1);

                long dist1 = calculateManhattanDistance(studentLocation, s1);
                long dist2 = calculateManhattanDistance(studentLocation, s2);

                if (dist1 > dist2 ||
                        (dist1 == dist2 && s1.getLastUpdatedOrder() < s2.getLastUpdatedOrder())) {
                    // Trocar diretamente usando set
                    tempList.remove(j);
                    tempList.add(j, s2);
                    tempList.remove(j + 1);
                    tempList.add(j + 1, s1);
                }
            }
        }
        return tempList.iterator();
    }

    private long calculateManhattanDistance(Services s1, Services s2) {
        return Math.abs(s1.getLatitude() - s2.getLatitude()) +
                Math.abs(s1.getLongitude() - s2.getLongitude());
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
        Services service = findServicesElem(lodging);
        StudentTypes type = StudentTypes.fromString(studentType);
        switch (type) {
            case OUTGOING -> newStudent = new OutgoingClass (studentType, name, country, service);
            case BOOKISH -> newStudent = new BookishClass(studentType, name, country, service);
            case THRIFTY -> newStudent = new ThriftyClass(studentType, name, country, service);
        }
        assert service != null;
        service.addStudentsThere(newStudent);
        allStudents.add(newStudent);
        studentsByCountry.addLast(newStudent);
    }

    public boolean isInBounds (long latitude, long longitude) {
        return latitude >= this.bottomLatitude && latitude <= this.topLatitude &&
                longitude >= this.leftLongitude && longitude <= this.rightLongitude;
    }

    public boolean isStudentHome(String studentName, String locationName) {
        Iterator <Students> it = getAllStudentsIterator();
        while (it.hasNext() ) {
            Students student = it.next();
            if (student.getName().equals(studentName) && student.getPlaceHome().equals(locationName))
                return true;
        }
        return false;
    }

    public boolean isAcceptableMove(String studentName, String locationName) {
        Students student = findStudentElem(studentName);
        Services service = findServicesElem(locationName);
        return student != null && service != null && student.getPlaceHome().getServicePrice() > service.getServicePrice();
    }


}
