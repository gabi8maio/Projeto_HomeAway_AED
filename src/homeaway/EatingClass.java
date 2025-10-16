package homeaway;

public class EatingClass extends ServicesClassAbstract implements Eating{

    public EatingClass(long latitude, long longitude, Double price, Double value, String serviceName){
        super(latitude,longitude,price,value,serviceName);
    }

    @Override
    public String getServiceType() {
        return "";
    }

    @Override
    public long getLatitude() {
        return 0;
    }

    @Override
    public long getLongitude() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
