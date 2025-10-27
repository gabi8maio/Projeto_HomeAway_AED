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
        cheapestEatingPrice = Integer.MAX_VALUE;
        cheapestLodgingPrice = lodging.getServicePrice();
    }

    public boolean isMoreExpensiveThanCheapest(Services services){
        if(!services.getServiceType().equalsIgnoreCase(TypesOfService.EATING.toString())) return false;

        if (services.getServicePrice() <= cheapestEatingPrice) {
            cheapestEatingPrice = services.getServicePrice();  // Atualiza o preço mais barato
            return false; // Não é mais caro - é mais barato
        } else {
            return true; // É mais caro que o mais barato atual
        }

    }

}
