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

    public  Services getPlaceInTheMoment() {
        return placeNow;
    }

    public String setPlaceInTheMoment(Services newPlace) {
        if(newPlace.equals(lodging)) {
            placeNow = newPlace;
            return "home"; // Tem se de mudar
        }else {
            placeNow = newPlace;
            return newPlace.getServiceName();
        }
    }

    public void setPlaceGo(Services newPlace) {
        placeNow = newPlace;
    }

    public Services getLodging() {
        return lodging;
    }

}
