package homeaway;

import java.io.Serializable;

public abstract class StudentsClassAbstract implements Students, Serializable {

    private final String name;
    private final String type;
    private final String country;
    private final Services lodging;
    private Services placeNow;


    public StudentsClassAbstract(String type, String name, String country, Services lodging){
        this.type = type;
        this.name = name;
        this.country = country;
        this.lodging = lodging;
        this.placeNow = lodging;

    }

    public String getName() {
        return name;
    }

    public int compareTo(Students o1){
        return this.getName().compareTo(o1.getName());
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public  Services getPlaceHome() {
        return placeNow;
    }

    public void setPlaceHome(Services newPlace) {
        placeNow = newPlace;
    }

    public void setPlaceGo(Services newPlace) {
        placeNow = newPlace;
    }

    public Services getLodging() {
        return lodging;
    }

}
