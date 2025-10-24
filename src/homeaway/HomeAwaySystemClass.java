package homeaway;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.exceptions.EmptyStackException;
import dataStructures.exceptions.NoSuchElementException;

import java.io.*;

public class HomeAwaySystemClass implements HomeAwaySystem, Serializable{

    AreaClass tempArea;
    AreaClass loadedArea; // NS se devemos ter isto ou usar apenas a tempArea como a loaded
    DoublyLinkedList<AreaClass> savedAreas;

    public HomeAwaySystemClass(){
        savedAreas = new DoublyLinkedList<>();
    }

    @Override
    public void addTemporaryArea(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude){
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
    public String saveArea(){
        if(loadedArea == null) throw new NoSuchElementException();
        String tempAreaName = loadedArea.getName();
        store(tempAreaName, loadedArea);
        savedAreas.addFirst(loadedArea);
        return tempAreaName;
    }

    @Override
    public String loadArea(String name){
        return load(name);
    }

    public String getStudentLocationInfo(String studentName){
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
        return loadedArea.serviceExists(serviceName);
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
    public void addService(String serviceType, long latitude, long longitude, Double price, Double value, String serviceName) {
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
    private String load(String name){
         loadedArea = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
            loadedArea = (AreaClass) ois.readObject();
            ois.close();
            return loadedArea.getName();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace(); // See what's actually wrong
            throw new RuntimeException("Failed to load area from file: " + name, e);
        }
    }

    public boolean lodgingExists (String name){
        return loadedArea.lodgingExists(name);
    }

    public boolean lodgingIsFull(String name){
        return loadedArea.isItFull(name);
    }

    public void removeStudent(String studentName){
        loadedArea.removeStudent(studentName);
    }

    public void moveStudentToLocation(String studentName, String locationName){
        if (!serviceNameExists(locationName)) throw new IllegalArgumentException(String.format("Unknown %s!", locationName));
        if (!studentExists(studentName)) throw new IllegalArgumentException(String.format("%s does not exist!", studentName));
        if (!isEatingOrLeisureService(locationName)) throw new IllegalArgumentException(String.format("%s is not a valid service!", locationName));
        if (isStudentAtLocation(studentName, locationName)) throw new IllegalArgumentException("Already there!");
        if (isEatingServiceFull(locationName)) throw new IllegalArgumentException(String.format("eating %s is full!", locationName));

    }

    public boolean studentExists (String name){
        return loadedArea.studentExists(name);
    }

    public Iterator<Students> getAllStudentsIterator(){
        return loadedArea.getAllStudentsIterator();
    }

    @Override
    public Iterator<Students> getStudentsByCountryIterator(String country) {
        return null;
    }

    public void addStudent (String studentType, String name, String country, String lodging){
        loadedArea.addStudent(studentType, name, country, lodging);
    }
}
