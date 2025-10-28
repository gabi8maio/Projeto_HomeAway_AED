package homeaway;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.TwoWayIterator;
import dataStructures.exceptions.NoSuchElementException;
import homeaway.Exeptions.*;

import java.io.*;

public class HomeAwaySystemClass implements HomeAwaySystem, Serializable{

    AreaClass tempArea;
    AreaClass loadedArea; // NS se devemos ter isto ou usar apenas a tempArea como a loaded
    DoublyLinkedList<AreaClass> savedAreas;

    public HomeAwaySystemClass(){
        savedAreas = new DoublyLinkedList<>();
    }


    @Override
    public void addTemporaryArea(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude)
            throws BoundsAlreadyExistException, InvalidBoundsException {
        if (hasArea(name)) {
            throw new BoundsAlreadyExistException();
        }
        if (topLatitude <= bottomLatitude || rightLongitude <= leftLongitude) {
            throw new InvalidBoundsException();
        }
        AreaClass area = new AreaClass(name, topLatitude, bottomLatitude, leftLongitude, rightLongitude);
        this.tempArea = area;
        loadedArea = area;
    }

    @Override
    public Iterator<Services> getServiceIterator() {
        return loadedArea.getServicesIterator();
    }

    @Override
    public String getTempAreaName(){
        return tempArea.getName();
    }

    @Override
    public String saveArea() throws SystemBoundsNotDefinedException{
        if(loadedArea == null)
            throw new SystemBoundsNotDefinedException();
        String tempAreaName = loadedArea.getName();
        store(tempAreaName, loadedArea);
        savedAreas.addFirst(loadedArea);
        return tempAreaName;
    }


    public Students getStudentLocationInfo(String studentName) throws StudentDoesNotExistsException {
        String studentExistsName = studentExists(studentName);
        if (studentExistsName == null){
            throw new StudentDoesNotExistsException(studentName);
        }
        return loadedArea.getStudentLocationInfo(studentName);
    }

    @Override
    public boolean hasArea(String name){

        if (loadedArea != null && loadedArea.getName().equalsIgnoreCase(name)) {
            return true;
        }

        // 2. Verificar se existe ficheiro com esse nome na pasta "data"
        String filename = name.replace(" ", "_") + ".dat";
        File file = new File("data", filename);
        return file.exists();
    }

    @Override
    public String serviceNameExists(String name) {
        return loadedArea.serviceExists(name);
    }

    private boolean isEatingOrLeisureService(String serviceName){
        return loadedArea.isEatingOrLeisureService(serviceName);
    }

    private boolean isStudentAtLocation(String studentName,String locationName){
        return loadedArea.isStudentAtLocation(studentName,locationName);
    }

    private boolean isEatingServiceFull(String locationName){
        return loadedArea.isEatingServiceFull(locationName);
    }



    @Override
    public void addService(String serviceType, long latitude, long longitude, double price, int value, String serviceName)
            throws InvalidServiceTypeException, InvalidLocationException, InvalidPriceMenuException, InvalidRoomPriceException, InvalidTicketPriceException, InvalidDiscountException, InvalidCapacityException, ServiceAlreadyExistsException{
        TypesOfService serviceTypeEnum = TypesOfService.fromString(serviceType); // Podemos fazer isto?
        if (serviceTypeEnum == null) {
            throw new InvalidServiceTypeException();
        }
        if (!loadedArea.isInBounds(latitude, longitude)) { // Meti ao calhas
            throw new InvalidLocationException();
        }

        if (price <= 0) {
            switch (serviceTypeEnum) {
                case EATING:
                    throw new InvalidPriceMenuException();
                case LODGING:
                    throw new InvalidRoomPriceException();
                case LEISURE:
                    throw new InvalidTicketPriceException();
            }
        }

        // Validar  value conforme o tipo de serviço
        if (serviceTypeEnum.equals(TypesOfService.LEISURE)) {
            if (value < 0 || value > 100) {
                throw new InvalidDiscountException();
            }
        } else { // eating ou lodging
            if (value <= 0) {
                throw new InvalidCapacityException();
            }
        }

        // Validar se nome já existe
        String previousServiceName = serviceNameExists(serviceName);
        if (previousServiceName != null) {
            throw new ServiceAlreadyExistsException(previousServiceName);
        }

        loadedArea.createService( serviceType,  latitude,  longitude,  price,  value,  serviceName);

    }


    private static void store(String fileName, AreaClass area){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(area);
            oos.flush();
            oos.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println("Erro de escrita");
        }
    }
    public String loadArea (String name) throws BoundsDoesNotExistException{
         loadedArea = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
            loadedArea = (AreaClass) ois.readObject();
            ois.close();
            return loadedArea.getName();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace(); // See what's actually wrong
            throw new BoundsDoesNotExistException();
        }
    }

    public Iterator<Services> getVisitedLocationsIterator(String studentName){
        String name = studentExists(studentName);
        if (name == null)
            throw new StudentDoesNotExistsException(studentName);
        if(isThrifty(studentName))
            throw new StudentIsThriftyException(name);
        if (!hasVisitedLocation(name))
            throw new NoVisitedLocationsException(name);
        return loadedArea.getVisitedLocationsIterator(studentName);
    }

    private boolean hasVisitedLocation(String name) {
        return loadedArea.hasVisitedLocation(name);
    }

    private boolean isThrifty(String studentName) {
        return loadedArea.isThrifty(studentName);
    }

    public Iterator<Services> getServicesByTagIterator(String tag){
        return loadedArea.getServicesByTagIterator(tag);
    }

    public boolean lodgingExists (String name){
        return loadedArea.lodgingExists(name);
    }

    public String lodgingIsFull(String name){
        return loadedArea.isItFull(name);
    }

    public Iterator<Services> getRankedServicesIterator(int stars,String type,String studentName){
        if (stars > 5 || stars < 0)
            throw new InvalidEvaluationException();
        String name = studentExists(studentName);
        if (name == null)
            throw new StudentDoesNotExistsException(studentName);
        TypesOfService serviceTypeEnum = TypesOfService.fromString(type); // Podemos fazer isto?
        if (serviceTypeEnum == null) {
            throw new InvalidServiceTypeException();
        }
        if (!hasServicesOfType(type))
            throw new NoTypeServicesException(type);
        return loadedArea.getRankedServicesIterator(stars,type,studentName);
    }

    private boolean hasServicesOfType(String type) {
        return loadedArea.hasServiceOfType(type);
    }

    public  Services findMostRelevantService(String studentName, String serviceType){
        return loadedArea.findMostRelevantService(studentName, serviceType);
    }

    public void removeStudent(String studentName) throws StudentDoesNotExistsException{
        String studentExistsName = studentExists(studentName);
        if (studentExists(studentName) != null){
            throw new StudentAlreadyExistsException(studentExistsName);
        }
        loadedArea.removeStudent(studentName);
    }

    public Students goStudentToLocation(String studentName, String locationName) throws UnknownLocationException, StudentDoesNotExistsException, InvalidServiceException, StudentAlreadyThereException, EatingIsFullException{
        String serviceName = serviceNameExists(locationName);
        if (serviceName == null)
            throw new UnknownLocationException(locationName);
        String studentExistsName = studentExists(studentName);
        if (studentExistsName == null){
            throw new StudentDoesNotExistsException(studentName);
        }
        if (!isEatingOrLeisureService(locationName))
            throw new InvalidServiceException(locationName);
        if (isStudentAtLocation(studentName, locationName))
            throw new StudentAlreadyThereException();
        if (isEatingServiceFull(locationName))
            throw new EatingIsFullException();

        return loadedArea.goStudentToLocation(studentName,locationName);
    }

    public boolean isServiceMoreExpensiveForThrifty(String studentName, String serviceName){
        return loadedArea.isServiceMoreExpensiveForThrifty(studentName, serviceName);
    }

    public Students moveStudentToLocation(String studentName, String locationName)
    throws LodgingNotExistsException, StudentDoesNotExistsException, StudentHomeException,LodgingIsFullException, MoveNotAcceptableException{

        String serviceName = serviceNameExists(locationName);
        if (serviceName == null)
            throw new LodgingNotExistsException(locationName);
        String studentNameReal = studentExists(studentName);
        if (studentExists(studentName) == null){
            throw new StudentDoesNotExistsException(studentName);
        }
        if (isStudentHome(studentName, serviceName))
            throw new StudentHomeException(studentNameReal);
        String fullLodging = lodgingIsFull(serviceName);
        if (fullLodging != null) {
            throw new LodgingIsFullException(fullLodging);
        }
        if (!isAcceptable(studentName, serviceName))
            throw new MoveNotAcceptableException(studentNameReal);

        return loadedArea.moveStudentToLocation(studentName,serviceName);
    }

    private boolean isAcceptable(String studentName, String locationName) {
        return loadedArea.isAcceptableMove(studentName, locationName);
    }

    private boolean isStudentHome(String studentName, String locationName) {
        return loadedArea.isStudentHome(studentName, locationName);
    }

    private boolean isCorrectOrder(String order){
        return order.equals(">") || order.equals("<");
    }

    public TwoWayIterator<Students> usersCommand(String order, String serviceName) throws NoStudentsOnServiceException, ServiceDoesNotExistException, ServiceNotControlEntryExitException{
        String service = serviceNameExists(serviceName);
        if (service == null)
            throw new ServiceDoesNotExistException(serviceName);
        if (!isThereAnyStudent(serviceName)) {
            throw new NoStudentsOnServiceException(service);
        }
        if (!isCorrectOrder(order)) {
            throw new OrderNotExistsException();
        }
        if (!isEatingOrLodgingService(serviceName))
            throw new ServiceNotControlEntryExitException(service);
        return loadedArea.getStudentsByService(service);
    }

    private boolean isThereAnyStudent(String serviceName) {
        return loadedArea.isThereAnyStudents(serviceName);
    }

    private boolean isEatingOrLodgingService(String serviceName) {
        return loadedArea.isEatingOrLodgingService(serviceName);
    }

    public String studentExists (String name){
        return loadedArea.studentExists(name);
    }

    public void starCommand(int rating,String serviceName,String tag) throws InvalidEvaluationException, ServiceDoesNotExistException{
        if(rating < 1 || rating > 5)
            throw new InvalidEvaluationException();
        if(serviceNameExists(serviceName) == null)
            throw  new ServiceDoesNotExistException(serviceName);


        loadedArea.starCommand(rating,serviceName,tag);
    }



    public Iterator<Services> getServicesByRankingIterator() throws NoServicesInSystemException{
        Iterator<Services> rankingIterator = loadedArea.getServicesByRankingIterator();
        if (!rankingIterator.hasNext()) {
            throw new NoServicesInSystemException();
        }
        return rankingIterator;
    }

    public Iterator<Students> getAllStudentsIterator(){
        return loadedArea.getAllStudentsIterator();
    }

    @Override
    public Iterator<Students> getStudentsByCountryIterator(String country) {
        return loadedArea.getStudentsByCountryIterator(country);
    }

    public boolean hasBounds() {
        return loadedArea != null;
    }


    public Iterator<Students> getStudentsByCountryIterator() {
        return null;
    }

    public void addStudent (String studentType, String name, String country, String lodging)
    {
        if (StudentTypes.fromString(studentType) == null) {
            throw new InvalidStudentTypeException();
        } if (!lodgingExists(lodging)) {
            throw new LodgingNotExistsException(lodging);
        }
        String fullLodging = lodgingIsFull(lodging);
        if (fullLodging != null) {
            throw new LodgingIsFullException(fullLodging);
        }
        String studentExistsName = studentExists(name);
         if (studentExists(name) != null){
            throw new StudentAlreadyExistsException(studentExistsName);
        }
        loadedArea.addStudent(studentType, name, country, lodging);
    }

    @Override
    public Iterator<Students> getStudents(String argument) throws NoStudentsException, NoStudentsFromCountryException {
        if (argument.equals("all")) {
             Iterator <Students> it = getAllStudentsIterator();
             if (!it.hasNext())
                 throw new NoStudentsException();
             else
                 return it;

        } else {
            // The argument will be the country now
            Iterator<Students> countryStudentIterator = getStudentsByCountryIterator(argument);

            if (!countryStudentIterator.hasNext()) {
                throw new NoStudentsFromCountryException();
            }else
                return countryStudentIterator;
        }
    }
}
