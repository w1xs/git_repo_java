package laba_9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Laba_9 {
    public static void task_1(String input) {
        String result = "";
        for (char c : input.toCharArray()) {
            if (!((c >= 'A' && c <= 'Z') || (c >= 'А' && c <= 'Я'))) {
                result = result.concat(Character.toString(c));
            }
        }
        System.out.println(result);
    }

    public static void task_2(String input) {
        String[] word_arr = input.split("[ ]+");
        String result = "";
        for (String s : word_arr) {
            StringBuilder stringBuilder = new StringBuilder(s);
            result = result.concat(stringBuilder.reverse().toString()).concat(" ");
        }
        System.out.println(result);
    }

    public static void task_3(String input) {
        String[] word_arr = input.split("[, ]+");
        System.out.println("Число трехбуквенных слов: " + Arrays.stream(word_arr).filter((s) -> s.length() == 3).count());
    }

    public static void task_4(String input) {
        Boolean good = Boolean.TRUE;
        if (!input.matches(".*[A-Z].*")) {
            System.out.println("Пароль не содержит заглавных букв");
            good = Boolean.FALSE;
        }
        if (!input.matches(".*[a-z].*")) {
            System.out.println("Пароль не содержит строчных букв");
            good = Boolean.FALSE;
        }
        if (!input.matches(".*[#@$%^&*<>].*")) {
            System.out.println("Пароль не содержит специальных символов");
            good = Boolean.FALSE;
        }
        if (!input.matches(".*[,.!?;:\"'].*")) {
            System.out.println("Пароль не содержит знаков препинания");
            good = Boolean.FALSE;
        }
        if(input.length() < 8){
            System.out.println("Пароль короче 8ми символов");
            good = Boolean.FALSE;
        }
        if(input.length() > 12){
            System.out.println("Пароль длиннее 12ти символов");
            good = Boolean.FALSE;
        }
        if(good){
            System.out.println("Пароль хороший");
        }
    }

    public static void task_5(String input){
        String[] number_arr = input.split("[^0-9]");
        int result = 0;
        for(String number : number_arr){
            if(!number.isEmpty()){
                result += Integer.parseInt(number);
            }
        }
        System.out.println("Сумма чисел: " + result);
    }

    public static void task_6(String input_text, String word_to_find){
        String[] sentences_arr = input_text.split("[.!?]");
        String[] word_arr;
        for(String sentence : sentences_arr){
            sentence = sentence.strip();
            word_arr = sentence.split("[ ]+");
            for(String word : word_arr){
                if(word.equals(word_to_find)){
                    System.out.println(sentence);
                }
            }
        }
    }

    public static void task_7(String input){
        String[] word_arr;
        int telegram_value = 0;
        String result = "";
        if(!input.matches("[A-Za-zА-Яа-яё ,]+")){
            System.out.println("В предложении есть не указанный в условии символ");
            return;
        }
        input = input.replaceAll("[,]", " zpt");
        word_arr = input.split(" ");
        for(String word: word_arr){
            if(word.length() > 2){
                telegram_value += 10;
                result = result.concat(word + " ");
            }
        }
        System.out.println("Стоимость телеграммы: " + telegram_value);
        System.out.println("Обработанная телеграмма: " + result);
    }
}
