package Closest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClosestTasks {
    public static Integer  closestByKey(List<Integer> list, Integer key)
    {
        Collections.sort(list);
        int index = Collections.binarySearch(list, key);

        if(index < 0)
        {
            index = Math.abs(index) - 1;

            if(index == list.size())
            {
                return list.get(list.size() - 1);
            }
            else if (index == 0)
            {
                return list.get(0);
            }
            else if(Math.abs(list.get(index) - key) < Math.abs(list.get(index - 1) - key))
            {
                return list.get(index);
            }
            else
            {
                return list.get(index - 1);
            }
        }
        return list.get(index);
    }

    public static void main(String[] args) {
        System.out.println(closestByKey(Arrays.asList(2,3,4,8,100), 5));
    }
}
