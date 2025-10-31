package homeaway;

public interface Thrifty {

    /**
     * @param services Service
     * @return - returns True If the Service given is cheaper than the one stored
     */
    boolean isMoreExpensiveThanCheapest(Services services);
}
