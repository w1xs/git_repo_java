package laba_1;

import java.util.Scanner;

public class Laba_1 {

    private static Boolean correct_int(String input) {
        if (input.matches("^\\d+")) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static void task_1() { //задача 1
        Scanner console_in = new Scanner(System.in);
        String[] animals = {"крысы", "коровы", "тигра", "зайца", "дракона", "змеи", "лошади", "овцы",
                "обезьяны", "курицы", "собаки", "свиньи"};
        System.out.println("Введите нужный год: ");
        String year_str = console_in.next();
        if (correct_int(year_str) && !year_str.isEmpty()) {
            int year_int = Integer.parseInt(year_str);
            if (year_int >= 1996) {
                System.out.println("По китайскому календарю, это год " + animals[(Math.abs(year_int - 1996) % 12)]);
            } else {
                System.out.println("По китайскому календарю, это год " + animals[12 - (Math.abs(year_int - 1996) % 12)]);
            }
        } else {
            System.out.println("Неверный ввод");
        }
    }

    public static void task_2() {//задача 2
        String output;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(Integer.toString(i) + " x " + Integer.toString(j) + " = " + Integer.toString(j * i));
            }
        }

        System.out.print("   ");
        for (int i = 1; i < 10; i++) {
            output = String.format("%3d", i);
            System.out.print(output);
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            output = String.format("%3d", i);
            System.out.print(output);
            for (int j = 1; j < 10; j++) {
                output = String.format("%3d", i * j);
                System.out.print(output);
            }
            System.out.println();
        }
        return;
    }

    private static Boolean is_good(int num) {
        int count = 0, left_sum = 0, right_sum = 0;
        char ch = '0';
        String row = Integer.toString(num);
        count = 6 - row.length();
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                row = "0" + row;
            }
        }
        for (int i = 0; i < row.length(); i++) {
            ch = row.charAt(i);
            if (i <= 2) {
                left_sum += (ch - '0');
            } else {
                right_sum += (ch - '0');
            }
        }
        return left_sum == right_sum;
    }

    public static void task_3() { //задача 5
        Scanner console_in = new Scanner(System.in);
        String min_str, max_str;
        int min_int, max_int, count = 0;

        System.out.println("Введите меньший номер билета:");
        min_str = console_in.next();
        System.out.println("Введите больший номер билета:");
        max_str = console_in.next();
        if (!correct_int(min_str) || !correct_int(max_str) || max_str.length() > 6) {
            System.out.println("Неверный ввод");
            return;
        }

        min_int = Integer.parseInt(min_str);
        max_int = Integer.parseInt(max_str);

        for (int i = min_int; i < max_int; i++) {
            if (is_good(i)) {
                count++;
            }
        }
        System.out.println("Количество счастливых билетов = " + Integer.toString(count));
        return;
    }

    public static void task_4() { //задача 6
        String value_str;
        int value_int, count_thousand = 0, count_hundreds = 0, count_fiveth = 0;

        Scanner console_in = new Scanner(System.in);
        System.out.println("Введите сумму");
        value_str = console_in.next();
        if (!correct_int(value_str)) {
            System.out.println("Неверный ввод");
            return;
        }
        value_int = Integer.parseInt(value_str);
        if (value_int % 50 != 0) {
            System.out.println("Указанную сумму выдать невозжно");
            return;
        }
        while (value_int > 0) {
            if (value_int / 1000 > 0) {
                value_int -= 1000;
                count_thousand++;
            } else {
                if (value_int / 100 > 0) {
                    value_int -= 100;
                    count_hundreds++;
                } else {
                    value_int -= 50;
                    count_fiveth++;
                }
            }
        }
        System.out.println("Выдано купюр номиналом в тысячу: " + Integer.toString(count_thousand));
        System.out.println("Выдано купюр номиналом в сто: " + Integer.toString(count_hundreds));
        System.out.println("Выдано купюр номиналом в пятьдесят: " + Integer.toString(count_fiveth));
        return;
    }
}
