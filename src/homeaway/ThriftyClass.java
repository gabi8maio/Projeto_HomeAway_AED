package homeaway;

public class ThriftyClass extends StudentsClassAbstract implements Thrifty, Students {

    private Eating cheapestEatingService;
    private Lodging cheapestLodgingService;
    private double cheapestEatingPrice;
    private double cheapestLodgingPrice;

    private static final long serialVersionUID = 0L;

    ThriftyClass(String studentType, String name, String country, Services lodging) {
        super (studentType, name, country, lodging);
        cheapestEatingService = null;
        cheapestLodgingService = (Lodging) lodging;
        cheapestEatingPrice = Integer.MAX_VALUE;
        cheapestLodgingPrice = getPrice(lodging);
    }

    public boolean isMoreExpensiveThanCheapest(Services services){
        if(!services.getServiceType().equalsIgnoreCase(TypesOfService.EATING.toString())) return false;

        if (getPrice(services) <= cheapestEatingPrice) {
            cheapestEatingPrice = getPrice(services);  // Atualiza o preço mais barato
            return false; // Não é mais caro - é mais barato
        } else {
            return true; // É mais caro que o mais barato atual
        }

    }

    private double getPrice (Services service) {
        double price = 0;
        if (service instanceof Leisure) {
            price = ((Leisure)service).getPrice();
        } else if (service instanceof Lodging) {
            price = ((Lodging)service).getPrice();
        } else if (service instanceof Eating) {
            price = ((Eating)service).getPrice();
        }
        return price;
    }

}
