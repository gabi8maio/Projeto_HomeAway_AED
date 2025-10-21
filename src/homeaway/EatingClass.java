package homeaway;

public class EatingClass extends ServicesClassAbstract implements Eating{

    public EatingClass(long latitude, long longitude, Double price, Double value, String serviceName){
        super(latitude,longitude,price,value,serviceName);
    }

    @Override
    public String getServiceType() {
        return TypesOfService.EATING.toString();
    }
}
