package homeaway;

public abstract class ServicesClassAbstract implements Services, ServicesChange {

    private final long latitude;
    private final long longitude;
    private final Double price;
    private final Double value;
    private final String serviceName;


    public ServicesClassAbstract(String serviceType, long latitude, long longitude, Double price, Double value, String serviceName){
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

}
