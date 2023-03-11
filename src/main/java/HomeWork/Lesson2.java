package HomeWork;

import java.io.FileWriter;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println(isPolyndrome("level"));
        Text();
    }

    public static boolean isPolyndrome(String str) {
    /*
    Напишите метод, который принимает на вход строку (String) и определяет
    является ли строка палиндромом (возвращает boolean значение).
    */
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void Text() {
    /*
    Напишите метод, который составит строку, состоящую из 100
    повторений слова TEST и метод, который запишет эту строку
    в простой текстовый файл, обработайте исключения.
     */
        StringBuilder sb = new StringBuilder();
        sb.append("TEST".repeat(100));
        try {
            try (FileWriter file = new FileWriter("TestFile.txt")) {
                file.write(String.valueOf(sb));
                file.flush();
                System.out.println("File Created and Save");
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
