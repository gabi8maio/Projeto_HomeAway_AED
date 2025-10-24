package homeaway;

import dataStructures.*;

public interface Outgoing {
    void addVisitedService(Services services);
    Iterator<Services> getAllVisitedServices();
}
