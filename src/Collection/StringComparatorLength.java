package Collection;

import java.util.Comparator;

class StringComparatorLength implements Comparator<String> {

    public int compare(String a, String b) {

        if (a.length() > b.length())
            return 1;
        else if (a.length() < b.length())
            return -1;
        else
            return 0;
    }
}
