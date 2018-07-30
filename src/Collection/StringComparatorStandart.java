package Collection;

import java.util.Comparator;

class StringComparatorStandart implements Comparator<String> {
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }
