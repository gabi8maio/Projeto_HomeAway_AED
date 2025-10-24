package homeaway;

import dataStructures.*;

public interface Bookish {
    void addVisitedService(Services services);
    Iterator<Services> getAllVisitedServices();
}
