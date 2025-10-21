package homeaway;

public class LeisureClass extends ServicesClassAbstract implements Leisure{

    public LeisureClass(long latitude, long longitude, Double price, Double value, String serviceName){
        super(latitude,longitude,price,value,serviceName);
    }

    @Override
    public String getServiceType() {
        return TypesOfService.LEISURE.toString();
    }

}
