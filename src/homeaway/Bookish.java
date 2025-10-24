package homeaway;

import java.util.Iterator;

public interface Bookish {
    void addVisitedService(Services services);
    Iterator<Services> getAllVisitedServices();
}
