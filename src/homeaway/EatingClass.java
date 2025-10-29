package homeaway;

import java.io.Serializable;

public class EatingClass extends ServicesClassAbstract implements Eating, Serializable {

    private final double price;


    public EatingClass(long latitude, long longitude, double price, int value, String serviceName){
        super(latitude,longitude,value, serviceName);
        this.price = price;

    }

    @Override
    public String getServiceType() {
        return TypesOfService.EATING.toString();
    }

    public double getPrice() {
        return price;
    }

}
