package HomeWork;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;


public class Lesson3 {
    public static void main(String[] args) throws IOException {
        oddIntArray(randIntArray());
        minMaxAvg(randIntArray());
        textArr();
    }

    public static ArrayList<Integer> randIntArray() {
    /*
    Пусть дан произвольный список целых чисел, удалить из него четные числа
    (в языке уже есть что-то готовое для этого)
     */
        Random rnd = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(rnd.nextInt(10));
        }
        System.out.printf("\nСписок: " + arr);
        return arr;
    }

    public static void oddIntArray(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); ) {
            if (arr.get(i) % 2 == 0) {
                arr.remove(i);
            } else {
                i++;
            }
        }
        System.out.printf("\nCписок нечетных чисел: " + arr);
    }

    public static void minMaxAvg(ArrayList<Integer> arr) {
    /*
    Задан целочисленный список ArrayList.
    Найти минимальное, максимальное и среднее арифметическое из этого списка.
     */
        System.out.println("\nМинимальное число: " + Collections.min(arr));
        System.out.println("Максимальное число: " + Collections.max(arr));
        double avg = 0;
        for (double num : arr) {
            avg += num;
        }
        System.out.println("Среднее арифметическое чисел: " + avg / arr.size());
    }

    public static void textArr() throws IOException {
    /*
    Создать список типа ArrayList<String>.Поместить в него как строки, так и целые числа.
    Пройти по списку, найти и удалить целые числа.
     */
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите " + (i + 1) + " из 5 элемент: ");
            String s = reader.readLine();
            list.add(s);
        }
        System.out.println(list);
        for (int j = 0; j < list.size(); j++) {
            if (StringUtils.isNumeric(list.get(j))) {
                list.set(j, "");
            }
        }
        System.out.println(list);
    }
}
