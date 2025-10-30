package homeaway;


public class LodgingClass extends ServicesClassAbstract implements Lodging {
    private static final long serialVersionUID = 0L;

    private final double price;
    private final int value;


    public LodgingClass(long latitude, long longitude, double price, int value, String serviceName) {
        super(latitude,longitude,value, serviceName);

        this.price = price;
        this.value = value;

    }

    @Override
    public String getServiceType() {
        return TypesOfService.LODGING.toString();
    }

    public double getPrice() {
        return price;
    }

}
