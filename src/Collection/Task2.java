package Collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Задание 2: Выведите на экран список различных слов файла,
 * отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
 */
public class Task2 {
    public static void main(String[] args) {
        File file = new File("task.txt");
        Comparator<String> comp = new StringComparatorLength().thenComparing(new StringComparatorStandart());
        TreeSet<String> words = new TreeSet<>(comp);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String str = "";
            while ((str = reader.readLine()) != null) {
                String[] arr = str.split(" ");
                for (String s : arr) {
                    words.add(s);
                }
            }
            for (String s : words) System.out.println(s);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}

