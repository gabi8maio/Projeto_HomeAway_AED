package homeaway;

import java.io.Serializable;

public abstract class ServicesClassAbstract implements Services, ServicesChange, Serializable {

    private final long latitude;
    private final long longitude;
    private final double price;
    private final double value;
    private final String serviceName;
    private int lastUpdateCounter;
    private int averageStars;
    private int totalStars;
    private int rating;

    public ServicesClassAbstract(long latitude, long longitude, Double price, double value, String serviceName) {
        this.serviceName = serviceName;
        this.value = value;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public int compareTo(Services o) {
        return 0;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public double getServicePrice() {
        return price;
    }

    @Override
    public long getLatitude() {
        return latitude;
    }

    @Override
    public long getLongitude() {
        return longitude;
    }

    @Override
    public double getValue() {
        return value;
    }

    public int getLastUpdatedOrder() {
        return lastUpdateCounter;
    }

    public int getAverageStars() {
        return averageStars;
    }

    public float getTotalStars() {
        return totalStars;
    }

    public int getRatingCount() {
        return rating;
    }

    public void updateCounterRating() {
        lastUpdateCounter++;
    }

    public void addRating(int stars, int counter) {
        totalStars += stars;
        rating++;
        lastUpdateCounter = counter;
    }
}

