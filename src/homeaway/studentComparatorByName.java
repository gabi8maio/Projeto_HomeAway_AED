package homeaway;

import dataStructures.*;
import java.io.Serializable;

public class studentComparatorByName<Students extends Comparable<Students>> implements Comparator<Students>, Serializable {


    @Override
    public int compare(Students o1, Students o2) {
        return o1.compareTo(o2);
    }
}
