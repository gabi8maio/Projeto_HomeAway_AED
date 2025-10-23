package homeaway;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.exceptions.*;
import homeaway.Exeptions.*;

import java.io.*;

import static homeaway.TypesOfService.EATING;
import static homeaway.TypesOfService.LODGING;

public class HomeAwaySystemClass implements HomeAwaySystem {


    Area tempArea;
    Area loadedArea; // NS se devemos ter isto ou usar apenas a tempArea como a loaded
    DoublyLinkedList<Area> savedAreas;

    public HomeAwaySystemClass() {
        savedAreas = new DoublyLinkedList<>();
    }

    @Override
    public void addTemporaryArea(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude) throws BoundsAlreadyExistException, InvalidBoundsException {
        for (int i = 0; i < savedAreas.size(); i++) {
            if (savedAreas.get(i).getName().equals(name))
                throw new BoundsAlreadyExistException();
        }
        if (!(topLatitude >= bottomLatitude || leftLongitude >= rightLongitude))
            throw new InvalidBoundsException();
        Area area = new AreaClass(name, topLatitude, bottomLatitude, leftLongitude, rightLongitude);
        this.tempArea = area;
        loadedArea = area;
    }

    @Override
    public String saveArea() {
        if (loadedArea == null) throw new NoSuchElementException();
        String tempAreaName = loadedArea.getName();
        store(tempAreaName, loadedArea);
        savedAreas.addFirst(loadedArea);
        return tempAreaName;
    }

    @Override
    public void addService(String serviceType, long latitude, long longitude, Double price, Double value, String serviceName)
            throws InvalidServiceTypeException, InvalidLocationException,InvalidPriceMenuException, InvalidRoomPriceException, InvalidTicketPriceException,
            InvalidDiscountException, InvalidCapacityException, ServiceAlreadyExistsException{
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
        if (serviceNameExists(serviceName)) {
            throw new ServiceAlreadyExistsException();
        }

        loadedArea.createService(serviceType, latitude, longitude, price, value, serviceName);
    }


    @Override
    public Iterator<Services> getServiceIterator() {
        return loadedArea.getServicesIterator();
    }

    @Override
    public String getTempAreaName() {
        return tempArea.getName();
    }


    @Override
    public void loadArea(String name) {
        //if(hasArea) throw new NoSuchElementException();
        load(name);
    }


    @Override
    public boolean serviceNameExists(String name) {
        return loadedArea.serviceExists(name);
    }


    private static void store(String fileName, Area area) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(area);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro de escrita");
        }
    }

    private void load(String name) {
        loadedArea = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
            loadedArea = (Area) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new EmptyStackException(); // mudar
        }
    }

    public boolean lodgingExists(String name) {
        return loadedArea.lodgingExists(name);
    }

    public boolean lodgingIsFull(String name) {
        return loadedArea.isItFull(name);
    }

    public void removeStudent(String studentName) {
        loadedArea.removeStudent(studentName);
    }

    public boolean studentExists(String name) {
        return loadedArea.studentExists(name);
    }

    public Iterator<Students> getAllStudentsIterator() {
        return loadedArea.getAllStudentsIterator();
    }

    @Override
    public Iterator<Students> getStudentsByCountryIterator(String country) {
        return null;
    }

    public void addStudent(String studentType, String name, String country, String lodging) {
        loadedArea.addStudent(studentType, name, country, lodging);
    }
}

