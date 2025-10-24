package homeaway;

import java.util.Iterator;

public interface Outgoing {
    void addVisitedService(Services services);
    Iterator<Services> getAllVisitedServices();
}
