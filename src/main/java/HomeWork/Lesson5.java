package HomeWork;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Lesson5 {
    public static void main(String[] args) {
        phoneBook();
        sortByTree();
    }

    public static void phoneBook() {
    /*
    1. Реализуйте структуру телефонной книги с помощью HashMap,
    учитывая, что 1 человек может иметь несколько телефонов.
    */
        Object name;
        do {
            HashMap<Object, Object> phoneMap = new HashMap<>();
            phoneMap.put("111111111", "Иванов");
            phoneMap.put("222222222", "Петров");
            phoneMap.put("333333333", "Сидоров");
            phoneMap.put("444444444", "Иванов");
            phoneMap.put("555555555", "Иванов");
            phoneMap.put("666666666", "Петров");
            phoneMap.put("777777777", "Иванов");
            phoneMap.put("888888888", "Сидоров");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите фамилию для поиска в справочнике: ");
            name = scanner.next();
            if (!name.equals("й")) {
                for (HashMap.Entry<Object, Object> phoneMapEntry : phoneMap.entrySet()) {
                    if (phoneMapEntry.getValue().equals(name)) {
                        System.out.println(phoneMapEntry.getKey());
                    }
                }
            } else {
                System.out.println("Конец программы\n");
            }
        } while (!name.equals("й"));
    }

    public static void sortByTree() {
    /*
    Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина,
    Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова,
    Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников,
    Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся имена
    с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
    */
        String s = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, " +
                "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, " +
                "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        s = s.replace(",", "");
        String[] arr = s.split(" ");
        ArrayList names = new ArrayList();
        for (int i = 0; i < arr.length; i += 2) {
            names.add(arr[i]);
        }
        TreeMap<Object, Integer> map = new TreeMap<>();
        for (Object name : names) {
            if (map.containsKey(name)) {
                int count = map.get(name) + 1;
                map.put(name, count);
            } else {
                map.put(name, 1);
            }
        }
        System.out.println(names);
        map.entrySet().stream().sorted(Map.Entry.<Object, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }
}


