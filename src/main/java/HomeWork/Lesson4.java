package HomeWork;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Lesson4 {
    public static void main(String[] args) {
        reversedList();
        stringSaver();
    }

    public static void stringSaver() {
    /*
    Реализовать консольное приложение, которое:
    Принимает от пользователя и “запоминает” строки.
    Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
    Если введено revert, удаляет предыдущую введенную строку из памяти.
     */
        Scanner in = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String a;
        System.out.println("\n\nМеню:");
        System.out.println("01 - print");
        System.out.println("02 - revert");
        System.out.println("03 - exit");
        System.out.println("Введите строки или номер команды: \n");
        do {
            a = in.next();
            if (!a.equals("01") && !a.equals("02") && !a.equals("03")) {
                stack.push(a);
            } else if (a.equals("01")) {
                for (int i = stack.size() - 1; i >= 0; i--) {
                    System.out.println(stack.elementAt(i));
                }
            } else if (a.equals("02")) {
                stack.pop();
                for (int i = 0; i < stack.size(); i++) {
                    System.out.println(stack.elementAt(i));
                }
            }
        } while (!a.equals("03"));
    }


    public static void reversedList() {
    /*
    Пусть дан LinkedList с несколькими элементами.
    Реализуйте метод, который вернет “перевернутый” список.
     */

        LinkedList<String> str = new LinkedList<>();
        Collections.addAll(str, "AUDI", "BMW", "MB", "LANCIA", "ALFA", "FIAT");
        System.out.printf("Заданный список: " + str);
        Collections.reverse(str);
        System.out.printf("\nПеревернутый список: " + str);
    }
}

