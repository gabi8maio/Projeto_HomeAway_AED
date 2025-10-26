package homeaway;

import java.io.Serializable;

public class LeisureClass extends ServicesClassAbstract implements Leisure, Serializable {



    public LeisureClass(long latitude, long longitude, double price, int value, String serviceName){
        super(latitude,longitude,price,value,serviceName);
    }

    @Override
    public String getServiceType() {
        return TypesOfService.LEISURE.toString();
    }

}
