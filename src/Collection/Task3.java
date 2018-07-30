package Collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 */
public class Task3 {
    public static void main(String[] args) {
        File file = new File("task.txt");

        HashMap<String, Integer> words = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str = "";
            while ((str = reader.readLine()) != null) {
                String[] arr = str.split(" ");
                for (String s : arr)
                {
                    if(!words.containsKey(s))words.put(s, 1);
                    else words.put(s, words.get(s)+1);
                }
            }
            for (Map.Entry s : words.entrySet()) System.out.println(s.getKey() + " : " + s.getValue());
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
