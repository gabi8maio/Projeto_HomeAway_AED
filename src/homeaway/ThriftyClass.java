package homeaway;

import java.io.Serializable;

public class ThriftyClass extends StudentsClassAbstract implements Thrifty, Students, Serializable {

    private Eating cheapestEatingService;
    private Lodging cheapestLodgingService;
    private double cheapestEatingPrice;
    private double cheapestLodgingPrice;

    ThriftyClass(String studentType, String name, String country, Services lodging) {
        super (studentType, name, country, lodging);
        cheapestEatingService = null;
        cheapestLodgingService = (Lodging) lodging;
        cheapestEatingPrice = 0;
        cheapestLodgingPrice = lodging.getServicePrice();
    }

    public boolean isMoreExpensiveThanCheapest(Services services){
        return services.getServicePrice() > cheapestEatingPrice;
    }

}
