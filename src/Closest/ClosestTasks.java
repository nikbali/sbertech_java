package Closest;

import java.util.*;

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

    public static <T extends Comparable<? super T> & CalcDistance<? super T>>  T closestByKeyGenerics(List<T> list, T key)
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
            else if(key.calcDistance(list.get(index)) < key.calcDistance(list.get(index-1)))
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


        List<ClassForTest> list = new ArrayList<>();
        list.add(new ClassForTest(2));
        list.add(new ClassForTest(3));
        list.add(new ClassForTest(5));
        list.add(new ClassForTest(200));
        list.add(new ClassForTest(22));
        list.add(new ClassForTest(8));
        list.add(new ClassForTest(100));

        System.out.println(closestByKeyGenerics(list, new ClassForTest(1000)));




    }



}