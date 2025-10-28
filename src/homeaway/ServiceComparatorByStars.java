package homeaway;

import dataStructures.Comparator;

import java.io.Serializable;

public class ServiceComparatorByStars implements Comparator<Services>, Serializable {


    @Override
    public int compare(Services o1, Services o2) {
        // Comparar por stars (descendente)
        //int starsCompare = Integer.compare(o2.getAverageStars(), o1.getAverageStars());
        //if (starsCompare != 0) return starsCompare;
        if (o1.getAverageStars() != o2.getAverageStars()) {
            return o2.getAverageStars() - o1.getAverageStars();
        }
        return (int)(o1.getLastUpdatedOrder() - o2.getLastUpdatedOrder());
        // Se stars iguais, comparar por lastUpdatedOrder (mais recente primeiro)
        //return Integer.compare(o2.getLastUpdatedOrder(), o1.getLastUpdatedOrder());
    }
}
