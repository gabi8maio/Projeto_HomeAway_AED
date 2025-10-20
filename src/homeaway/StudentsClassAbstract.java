package homeaway;

public abstract class StudentsClassAbstract {

    private String name;
    private String type;
    private String country;
    private String lodging;


    public StudentsClassAbstract(String type, String name, String country, String lodging){
        this.type = type;
        this.name = name;
        this.country = country;
        this.lodging = lodging;

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public String getLodging() {
        return lodging;
    }

}
