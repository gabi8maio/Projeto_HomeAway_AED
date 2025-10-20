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
        if(tempArea == null) throw new NoSuchElementException();
        String tempAreaName = tempArea.getName();
        store(tempAreaName, tempArea);
        savedAreas.addFirst(tempArea);
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
        return loadedArea.lodgingExists();
    }

    public boolean lodgingIsFull(String name){
        return loadedArea.isItFull(name);
    }

    public boolean studentExists (String name){
        return loadedArea.studentExists(name);
    }

    public void addStudent (String studentType, String name, String country, String lodging){
        loadedArea.addStudent(studentType, name, country, lodging);
    }
}
