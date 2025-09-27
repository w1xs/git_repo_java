package laba_2;

import java.util.*;

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

    public static void task_3() { //задача 4
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

    public static void task_4() { //задача 5
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
    public static void task_5(){ //задача 8
        int[] base =  {-2, -5, -2, -4, 3, -6, -2, -1, 5, 1, 1,
                0, -1, 0, 3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11};
        ArrayList<Integer> filtered = new ArrayList<Integer>();
        String output;
        int count_up = 0, count_warm = 0, max_count_warm = 0, k = 0;

       for(int i = 0; i < base.length-1; i++){
           if(base[i] < 0 && base[i + 1] > 0){
               count_up++;
           }
       }
       for(int i = 0; i < base.length; i++){
           if(base[i] > 0){
               k = i;
               while(base[k] > 0 && k < base.length - 1){
                   count_warm++;
                   k++;
               }
               if(count_warm > max_count_warm){
                   max_count_warm = count_warm;
               }
               count_warm = 0;
           }
       }


        for(int i = 0; i < base.length; i++){
            if(!filtered.contains(base[i])){
                filtered.add(base[i]);
            }
        }
        filtered.sort(Collections.reverseOrder());
        System.out.println("Temperature");
        for(int i = 0; i < 14; i++){
            output = String.format("%3d", filtered.get(i));
            System.out.print(output);
            for(int j = 0; j < base.length; j++){
                if(base[j] == filtered.get(i)){
                    output = String.format("%3s", "+");
                    System.out.print(output);
                }
                else{
                    output = String.format("%3s", " ");
                    System.out.print(output);
                }
            }
            System.out.println();
        }
        output = String.format("%3s", " ");
        System.out.print(output);
        for(int i = 1; i <= base.length; i++){
            output = String.format("%3d", i);
            System.out.print(output);
        }
        System.out.println(" Date");
        System.out.println("Число дней с изменением температуры: " + count_up);
        System.out.println("Маскимальное число дней с положительной температурой: " + max_count_warm);
    }
}
