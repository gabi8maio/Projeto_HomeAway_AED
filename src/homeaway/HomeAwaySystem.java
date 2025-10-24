package homeaway;

import dataStructures.Iterator;
import homeaway.Exeptions.*;

public interface HomeAwaySystem {
    void addTemporaryArea(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude) throws BoundsAlreadyExistException, InvalidBoundsException;

    Iterator<Services> getServiceIterator();
    boolean hasArea(String name);
    boolean serviceNameExists(String name, TypesOfService types);
    void addService(String serviceType,long latitude,long longitude,Double price,Double value,String serviceName) throws InvalidServiceTypeException, InvalidLocationException, InvalidPriceMenuException, InvalidRoomPriceException,
            InvalidTicketPriceException, InvalidDiscountException, InvalidCapacityException, ServiceAlreadyExistsException;
    String getTempAreaName();
    String saveArea() throws SystemBoundsNotDefinedException;
    String loadArea(String name) throws BoundsDoesNotExistException;
    void removeStudent(String studentName) throws StudentDoesNotExistsException;
    boolean lodgingExists(String name);
    boolean lodgingIsFull(String name);
    Services getStudentLocationInfo(String studentName);
    Iterator<Services> getVisitedLocationsIterator(String studentName);
    void starCommand(int rating,String serviceName);
    Iterator<Services> getServicesByRankingIterator();
    Iterator<Services> getRankedServicesIterator(int stars, String type, String studentName);
    boolean studentExists(String name);
    void moveStudentToLocation(String studentName, String locationName);
    void goStudentToLocation(String studentName, String locationName);
    Iterator<Students> usersCommand(String order, String serviceName);
    Iterator<Students> getAllStudentsIterator();
    Iterator<Students> getStudentsByCountryIterator(String country);
    void addStudent(String studentType, String name, String country, String lodging)throws InvalidStudentTypeException, LodgingNotExistsException, LodgingIsFullException, StudentAlreadyExistsException;

    Iterator <Students> getStudents(String argument) throws NoStudentsException, NoStudentsFromCountryException;
}
