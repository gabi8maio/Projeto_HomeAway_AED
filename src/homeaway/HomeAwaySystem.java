package homeaway;

import dataStructures.Iterator;
import homeaway.Exeptions.*;

public interface HomeAwaySystem {
    void addTemporaryArea(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude) throws BoundsAlreadyExistException, InvalidBoundsException;

    Iterator<Services> getServiceIterator();
    boolean hasArea(String name);
    String serviceNameExists(String name);
    void addService(String serviceType,long latitude,long longitude,double price,int value,String serviceName) throws InvalidServiceTypeException, InvalidLocationException, InvalidPriceMenuException, InvalidRoomPriceException,
            InvalidTicketPriceException, InvalidDiscountException, InvalidCapacityException, ServiceAlreadyExistsException;
    String getTempAreaName();
    String saveArea() throws SystemBoundsNotDefinedException;
    String loadArea(String name) throws BoundsDoesNotExistException;
    void removeStudent(String studentName) throws StudentDoesNotExistsException;
    boolean lodgingExists(String name);
    String lodgingIsFull(String name);
    Students getStudentLocationInfo(String studentName);
    Iterator<Services> getVisitedLocationsIterator(String studentName);
    void starCommand(int rating,String serviceName, String tag);
    Iterator<Services> getServicesByRankingIterator();
    Iterator<Services> getServicesByTagIterator(String tag);
    Services findMostRelevantService(String studentName, String serviceType);
    Iterator<Services> getRankedServicesIterator(int stars, String type, String studentName);
    String studentExists(String name);
    void moveStudentToLocation(String studentName, String locationName) throws LodgingNotExistsException, StudentDoesNotExistsException, StudentHomeException,LodgingIsFullException, MoveNotAcceptableException;
    String goStudentToLocation(String studentName, String locationName) throws UnknownLocationException, StudentDoesNotExistsException, InvalidServiceException, StudentAlreadyThereException, EatingIsFullException;
    Iterator<Students> usersCommand(String order, String serviceName);
    boolean isServiceMoreExpensiveForThrifty(String studentName, String serviceName);
    Iterator<Students> getAllStudentsIterator();
    Iterator<Students> getStudentsByCountryIterator(String country);
    void addStudent(String studentType, String name, String country, String lodging)throws InvalidStudentTypeException, LodgingNotExistsException, LodgingIsFullException, StudentAlreadyExistsException;
    boolean hasBounds();
    Iterator <Students> getStudents(String argument) throws NoStudentsException, NoStudentsFromCountryException;
}
