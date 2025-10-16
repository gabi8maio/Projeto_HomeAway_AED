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
    public void addTemporaryArea(Area tempArea){
        this.tempArea = tempArea;
    }
    @Override
    public String getTempAreaName(){
        return tempArea.getName();
    }

    @Override
    public void saveArea(){
        if(tempArea == null) throw new NoSuchElementException();
        store(tempArea.getName(), tempArea);
        savedAreas.addFirst(tempArea);
    }

    @Override
    public void loadArea(String name){
        //if(hasArea == null) throw new NoSuchElementException();
        Area areaToLoad = load(name);
        loadedArea = areaToLoad;
    }


    public boolean hasArea(String name){
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
