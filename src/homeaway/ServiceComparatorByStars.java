package homeaway;

import dataStructures.Comparator;

import java.io.Serializable;

public class ServiceComparatorByStars implements Comparator<Services>, Serializable {


    @Override
    public int compare(Services o1, Services o2) {
        // Comparar por stars (descendente)
        int starsCompare = Integer.compare(o2.getAverageStars(), o1.getAverageStars());
        if (starsCompare != 0)
            return starsCompare;
        // Se stars iguais, comparar por lastUpdatedOrder (mais recente primeiro)
        return
    }
}
