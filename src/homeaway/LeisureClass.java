package homeaway;

import java.io.Serializable;

public class LeisureClass extends ServicesClassAbstract implements Leisure, Serializable {

    private final double price;



    public LeisureClass(long latitude, long longitude, double price, int value, String serviceName){
        super(latitude,longitude,value, serviceName);
        this.price = price * (1-((double) value /100));
    }

    @Override
    public String getServiceType() {
        return TypesOfService.LEISURE.toString();
    }

    public double getPrice (){
        return this.price;
    }


}
