package homeaway;

public class HomeAwaySystemClass implements HomeAwaySystem{

    Area tempArea;

    public HomeAwaySystemClass(){

    }

    public void addTemporaryArea(Area tempArea){
        this.tempArea = tempArea;
    }

    public boolean hasArea(String name){
        return false;
    }

}
