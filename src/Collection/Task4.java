package Collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;

/**
 *     Задание 4: Выведите на экран все строки файла в обратном порядке.
 */
public class Task4 {
    public static void main(String[] args) {
        File file = new File("task.txt");
        Stack<String> words = new Stack<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String str = "";
            while ((str = reader.readLine()) != null)
            {
                words.push(str);
            }
            System.out.println("Вывод в обратном порядке:");
            while (!words.empty()) System.out.println(words.pop());
        }
        catch (IOException ex)
        {
            ex.getMessage();
        }
    }
}
