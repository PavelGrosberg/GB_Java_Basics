package HomeWork;

import java.util.Scanner;


public class Lesson1 {
    public static void main(String[] args) {
        findMaxMin();
        isLeap();
        findNum();

    }

    private static void findMaxMin() {

        // Задать одномерный массив и найти в нем минимальный и максимальный элементы

        int[] array = {1, 2, 3, 4, -3, 9, -1, -7, 5};
        int max = array[0];
        int min = array[0];
        for (int i : array)
            if (i > max) {
                max = i;
            }
        for (int j : array)
            if (j < min) {
                min = j;
            }
        System.out.printf("Максимальный элемент: " + max);
        System.out.printf("\nМинимальный элемент: " + min);
    }

    private static void isLeap() {

        // Написать метод, который определяет, является ли год високосным,
        // и возвращает boolean (високосный - true, не високосный - false).
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите год: ");
        int year = in.nextInt();
        boolean leap;
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            leap = true;
        } else {
            leap = false;
        }
        if (leap) {
            System.out.printf(year + " год является високосным!\n");
        } else {
            System.out.printf(year + " год НЕ является високосным!\n");
        }
    }

    private static void findNum() {

//        Дан массив nums = [3,2,2,3] и число val = 3.
//        Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//        Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
//        а остальные - равны ему.
        int val = 3;
        int[] array = {3, 2, 2, 3};
        int[] array1 = array;

        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
        numToEnd(array, array1, val);
    }

    public static void numToEnd(int[] array, int[] array1, int num) {
        int j = 0;
        for (int k : array1) {
            if (k != num) {
                array[j] = k;
                j++;
            }
        }
        for (int i = j; i < array.length; i++) {
            array[i] = num;
        }
        for (int k : array) {
            System.out.print(k + " ");
        }

    }
}
