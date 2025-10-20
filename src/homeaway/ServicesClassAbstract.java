package homeaway;

public abstract class ServicesClassAbstract implements Services, ServicesChange{

    private final long latitude;
    private final long longitude;
    private final double price;
    private final double value;
    private final String serviceName;


    public ServicesClassAbstract(long latitude, long longitude, Double price, double value, String serviceName){
        this.serviceName = serviceName;
        this.value = value;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    @Override
    public int compareTo(Services o) {
        return 0;
    }

    @Override
    public String getServiceName() {
        return "";
    }

    @Override
    public int getServicePrice() {
        return 0;
    }

    public double getValue(){
        return value;
    }

}
