package homeaway;

import java.io.Serializable;

public class EatingClass extends ServicesClassAbstract implements Eating, Serializable {

    public EatingClass(long latitude, long longitude, double price, int value, String serviceName){
        super(latitude,longitude,price,value,serviceName);
    }

    @Override
    public String getServiceType() {
        return TypesOfService.EATING.toString();
    }
}
