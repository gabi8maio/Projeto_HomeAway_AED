package homeaway;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.exceptions.NoSuchElementException;

import java.io.*;

public class HomeAwaySystemClass implements HomeAwaySystem{


    Area tempArea;
    Area loadedArea; // NS se devemos ter isto ou usar apenas a tempArea como a loaded
    DoublyLinkedList<Area> savedAreas;

    public HomeAwaySystemClass(){
        savedAreas = new DoublyLinkedList<>();
    }

    @Override
    public void addTemporaryArea(String name, long topLatitude, long bottomLatitude, long leftLongitude, long rightLongitude){
        Area area = new AreaClass(name, topLatitude, bottomLatitude, leftLongitude, rightLongitude);
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
    public void loadArea(String name){
        //if(hasArea) throw new NoSuchElementException();
        Area areaToLoad = load(name);
        loadedArea = areaToLoad;
    }

    @Override
    public boolean hasArea(String name){
        for(int i = 0; i < savedAreas.size(); i++)
            if(savedAreas.get(i).getName().equals(name))
                return true;
        return false;
    }

    @Override
    public boolean serviceNameExists(String name) {
        return loadedArea.serviceExists(name);
    }

    @Override
    public void addService(String serviceType, long latitude, long longitude, Double price, Double value, String serviceName) {
        loadedArea.createService( serviceType,  latitude,  longitude,  price,  value,  serviceName);
    }

    private void store(String fileName, Area area){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(area);
            oos.flush();
            oos.close();
        }catch (IOException e){
            System.out.println("Erro de escrita");
        }
    }
    private Area load(String name){
        Area area = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
            area = (Area) ois.readObject();
            ois.close();
        }catch (IOException e){
            throw new Exception() ; // mudar
        }finally {
            return area;
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
