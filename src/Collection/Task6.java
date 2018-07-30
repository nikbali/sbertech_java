package Collection;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке
 */
public class Task6 {
    public static void main(String[] args) {
        File file = new File("task.txt");
        ArrayList<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in)))
        {
            String str = "";
            while ((str = reader.readLine()) != null)
            {
                lines.add(str);
            }
            while (true)
            {
                try
                {
                    System.out.println("Введите номер строки или Exit: ");
                    String res = console.readLine();
                    if(res.equals("Exit")) break;
                    System.out.println(lines.get(Integer.parseInt(res)));
                }
                catch (Exception ex)
                {
                    System.out.println("Хрень вввел, введи число от 0 до " + (lines.size() - 1));
                }

            }

        }
        catch (IOException ex)
        {
            ex.getMessage();
        }
    }
}
