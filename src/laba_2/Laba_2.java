package laba_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Laba_2 {
    public static void task_1() { //задача 1
        int[] arr = new int[20];
        int count = 0, sum = 0;
        String num;
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(0, 1000);
        }
        for (int i = 0; i < 20; i++) {
            num = Integer.toString(arr[i]);
            StringBuilder stringBuilder = new StringBuilder(num);
            if (num.equals(stringBuilder.reverse().toString())) {
                count++;
                sum += arr[i];
                System.out.println(num);
            }
        }
        System.out.println("Количество: " + count + " Сумма: " + sum);
    }

    public static void task_2() { //задача 2
        int[] arr = new int[20];
        int max = 0;
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            arr[i] = random.nextInt(0, 1000);
        }
        for (int i = 0; i < 20; i++) {
            if (arr[i] % 2 == 0 && arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static void task_3() {
        int[] base = new int[20];
        ArrayList<Integer> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            base[i] = random.nextInt(0, 1000);
        }

        for (int i = 0; i < 20; i++) {
            if (base[i] % 10 == 3) {
                result.add(base[i]);
            }
        }
        result.sort(Collections.reverseOrder());
        System.out.println(result);
    }

    public static void task_4() {
        int[][] matrix = new int[8][8];
        int count = 0;
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = random.nextInt(-10, 10);
            }
        }
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                if (matrix[i][j] < matrix[i - 1][j] && matrix[i][j] < matrix[i + 1][j] && matrix[i][j] < matrix[i][j + 1] && matrix[i][j] < matrix[i][j - 1]) {
                    count++;
                    System.out.println("Локальный минимум: " + matrix[i][j] + " Строка: " + i + " Стобец: " + j);
                }
            }
        }
        System.out.println("Количесво локальных минимумов: " + count);

    }

}
