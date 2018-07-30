package Collection;

import java.io.*;
import java.util.HashSet;

/**
 * Задание 1: Подсчитайте количество различных слов в файле.
 */
public class Task1 {
    public static void main(String[] args) {
        File file = new File("task.txt");
        HashSet<String> words = new HashSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String str = "";
            while ((str = reader.readLine()) != null)
            {
                String[]  arr = str.split(" ");
                for(String s: arr)
                {
                    words.add(s);
                }
            }
            System.out.println("Количество различных слов: " + words.size());
        }
        catch (IOException ex)
        {
            ex.getMessage();
        }
    }
}
