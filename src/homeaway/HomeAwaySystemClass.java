package homeaway;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
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

    public Services getWhereService(){

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


    public Services getStudentLocationInfo(String studentName){
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
    public boolean serviceNameExists(String name, TypesOfService types) {
        return loadedArea.serviceExists(name, types);
    }

    // Sem parametros
    private boolean serviceNameExists(String serviceName) {
        return false;
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
    public void addService(String serviceType, long latitude, long longitude, Double price, Double value, String serviceName)
            throws InvalidServiceTypeException, InvalidLocationException, InvalidPriceMenuException, InvalidRoomPriceException,
            InvalidTicketPriceException, InvalidDiscountException, InvalidCapacityException, ServiceAlreadyExistsException{
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
        if (serviceNameExists(serviceName, serviceTypeEnum)) {
            throw new ServiceAlreadyExistsException();
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
        return loadedArea.getVisitedLocationsIterator(studentName);
    }

    public Iterator<Services> getServicesByTagIterator(String tag){
        return loadedArea.getServicesByTagIterator(tag);
    }

    public boolean lodgingExists (String name){
        return loadedArea.lodgingExists(name);
    }

    public boolean lodgingIsFull(String name){
        return loadedArea.isItFull(name);
    }

    public Iterator<Services> getRankedServicesIterator(int stars,String type,String studentName){
        return loadedArea.getRankedServicesIterator(stars,type,studentName);
    }
    public  Services findMostRelevantService(String studentName, String serviceType){
        return loadedArea.findMostRelevantService(studentName, serviceType);
    }

    public void removeStudent(String studentName) throws StudentDoesNotExistsException{
        if (!studentExists(studentName)) {
            throw new StudentDoesNotExistsException();
        }
        loadedArea.removeStudent(studentName);
    }

    public void goStudentToLocation(String studentName, String locationName)
            throws UnknownLocationException, StudentDoesNotExistsException, InvalidServiceException, StudentAlreadyThereException, EatingIsFullException{
        if (!serviceNameExists(locationName))
            throw new UnknownLocationException();
        if (!studentExists(studentName))
            throw new StudentDoesNotExistsException();
        if (!isEatingOrLeisureService(locationName))
            throw new InvalidServiceException();
        if (isStudentAtLocation(studentName, locationName))
            throw new StudentAlreadyThereException();
        if (isEatingServiceFull(locationName))
            throw new EatingIsFullException();

        loadedArea.goStudentToLocation(studentName,locationName);
    }

    public void moveStudentToLocation(String studentName, String locationName){
        if (!serviceNameExists(locationName))
            throw new LodgingNotExistsException();
        if (!studentExists(studentName))
            throw new StudentDoesNotExistsException();
        if (isStudentHome(studentName, locationName))
            throw new StudentHomeException();
        if (lodgingIsFull(locationName))
            throw new LodgingIsFullException();
        if (!isAcceptable(studentName, locationName))
            throw new MoveNotAcceptableException();

        loadedArea.moveStudentToLocation(studentName,locationName);
    }

    private boolean isAcceptable(String studentName, String locationName) {
        return loadedArea.isAcceptableMove(studentName, locationName);
    }

    private boolean isStudentHome(String studentName, String locationName) {
        return loadedArea.isStudentHome(studentName, locationName);
    }

    private boolean isCorrectOrder(String order){
        return !order.equals(">") && !order.equals("<");
    }

    public Iterator<Students> usersCommand(String order, String serviceName){
        if (!isCorrectOrder(order)) throw new IllegalArgumentException(String.format("Unknown %s!"));
        if (!serviceNameExists(serviceName)) throw new IllegalArgumentException(String.format("%s does not exist!"));
        if (!isEatingOrLeisureService(serviceName)) throw new IllegalArgumentException(String.format("%s is not a valid service!"));

        return loadedArea.getAllStudentsIterator();
    }

    public boolean studentExists (String name){
        return loadedArea.studentExists(name);
    }

    public void starCommand(int rating,String serviceName,String tag){
        loadedArea.starCommand(rating,serviceName,tag);
    }
    public Iterator<Services> getServicesByRankingIterator(){
        return loadedArea.getServicesByRankingIterator();
    }

    public Iterator<Students> getAllStudentsIterator(){
        return loadedArea.getAllStudentsIterator();
    }


    public Iterator<Students> getStudentsByCountryIterator() {
        return null;
    }

    public void addStudent (String studentType, String name, String country, String lodging)
            throws InvalidStudentTypeException, LodgingNotExistsException, LodgingIsFullException, StudentAlreadyExistsException {
        if (StudentTypes.fromString(studentType) == null) {
            throw new InvalidStudentTypeException();
        } if (!lodgingExists(lodging)) {
            throw new LodgingNotExistsException();
        } if (lodgingIsFull(lodging)){
            throw new LodgingIsFullException();
        } if (studentExists(name)){
            throw new StudentAlreadyExistsException();
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
