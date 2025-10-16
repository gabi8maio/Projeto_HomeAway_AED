package homeaway;

import dataStructures.DoublyLinkedList;
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
    public String getTempAreaName(){
        return tempArea.getName();
    }

    @Override
    public String saveArea(){
        if(tempArea == null) throw new NoSuchElementException();
        store(tempArea.getName(), tempArea);
        savedAreas.addFirst(tempArea);
    }

    @Override
    public void loadArea(String name){
        //if(hasArea) throw new NoSuchElementException();
        Area areaToLoad = load(name);
        loadedArea = areaToLoad;
    }


    public boolean hasArea(String name){
        for(int i = 0; i < savedAreas.size(); i++)
            if(savedAreas.get(i).getName().equals(name))
                return true;
        return false;
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

}
