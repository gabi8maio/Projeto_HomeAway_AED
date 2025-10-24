package homeaway;

import dataStructures.*;
import java.io.Serializable;

public class studentComparatorByName implements Comparator<Students>, Serializable {

    @Override
    public int compare(Students o1, Students o2) {
        return o1.compareTo(o2);
    }
}
