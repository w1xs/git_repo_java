package laba_7;

import java.util.ArrayList;
import java.util.Arrays;

public class Laba_7 {
    public static void task_1(ArrayList<Integer> data){
        long count_minus_days = data.stream().filter((x) -> x < 0).count();
        System.out.println("Количество дней с отрицательной температурой: " + count_minus_days);
        long count_hot_days = data.stream().filter((x) -> x > 10).count();
        if(count_hot_days != 0){
            System.out.println("Да, были дни, когда температура была выше 10 градусов");
        }
        else{
            System.out.println("Нет, не было дней, когда температура была выше 10 градусов");
        }
        int max_temp_f_week = data.stream().limit(7).max(Integer::compare).get();
        System.out.println("Максимальная температура на первой неделе марта: " + max_temp_f_week);
    }
    public static void task_2(String data){
        Comparator_for_laba_7 comparator_for_laba_7 = new Comparator_for_laba_7();
        long count_words = Arrays.stream(data.split("[, \n]+")).filter(s -> s.endsWith("es")).count();
        System.out.println("Количество слов, заканчивающихся на \"es\": " + count_words);
        System.out.println("Слова предложения, упорядоченные по возрастанию длинны: ");
        Arrays.stream(data.split("[, \n]+")).sorted(comparator_for_laba_7::string_length_compare).filter(s -> !s.matches("\\d+")).forEach((e) -> System.out.println(e + " "));
    }
}
