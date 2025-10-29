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

        // Se stars iguais, ordenar por lastUpdateOrder ASCENDENTE (mais antigo primeiro)
        // Isto faz com que serviços com lastUpdateOrder MAIOR fiquem no FINAL
        //if(o1.didEvaluationChanged()) return -1;
        return Integer.compare(o1.getLastUpdatedOrder(), o2.getLastUpdatedOrder());
    }
}
