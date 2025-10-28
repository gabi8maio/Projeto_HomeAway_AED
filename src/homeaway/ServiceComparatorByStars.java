package homeaway;

import dataStructures.Comparator;

import java.io.Serializable;

public class ServiceComparatorByStars implements Comparator<Services>, Serializable {


    @Override
    public int compare(Services o1, Services o2) {
        // First compare by stars DESCENDING (higher stars first)
        int starCompare = Integer.compare(o2.getAverageStars(), o1.getAverageStars());
        if (starCompare != 0) {
            return starCompare;
        }
        // If stars are equal, compare by lastUpdateOrder DESCENDING (newer first)
        return Integer.compare(o1.getLastUpdatedOrder(), o2.getLastUpdatedOrder());
    }

}
