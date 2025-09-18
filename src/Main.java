import laba_3.Bus;
import laba_4.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Лаба 3
//        Bus first_bus = new Bus(54, 400, 0);
//        Bus second_bus = new Bus(45, 500, 0);
//        int count_people = 55;
//        int profit_count = 0;
//        int profit_board = 11001;
//        while(profit_count * first_bus.get_ticket_value() < profit_board){
//            profit_count++;
//        }
//
//        first_bus.set_occupied_places(profit_count);
//        second_bus.set_occupied_places(count_people - profit_count);
//
//        System.out.println("Выручка первого автобуса: " + first_bus.calculate_occupied_places_price());
//        System.out.println("Выручка второго автобуса: " + second_bus.calculate_occupied_places_price());

//        Лаба 4

        String[][] name_gender = {{"Николай", "М"}, {"Павел", "М"}, {"Екатерина", "Ж"}, {"Валерий", "М"}, {"София", "Ж"},
                {"Дарья", "Ж"}, {"Михаил", "М"}, {"Алина", "Ж"}, {"Геннадий", "М"}, {"Тимофей", "М"}, {"Мария", "Ж"},
                {"Виктория", "Ж"}, {"Никита", "М"}, {"Светлана", "Ж"}, {"Валерия", "Ж"}, {"Дмитрий", "М"}, {"Кристина", "Ж"},
                {"Иван", "М"}, {"Елена", "Ж"}, {"Игорь", "М"}, {"Полина", "Ж"}, {"Александр", "М"}};
        String[] school_lessons = {"математика", "русский язык", "история", "английский язык", "физика", "химия", "физ-ра"};
        String[] regions = {"школа", "город", "область"};
        String[] university_lessons = {"линейная алгебра", "история", "исностранный язык", "дискретная математика", "программирование"};
        String[] course_works = {"курсовая 1", "курсовая 2", "курсовая 3"};
        int rand_number = 0;
        ArrayList<Schooler> schoolers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5000; i++) {
            rand_number = random.nextInt(name_gender.length);
            HashMap<String, Integer> marks = new HashMap<>();
            HashMap<String, Integer> olympiads = new HashMap<>();
            for (String schoolLesson : school_lessons) {
                marks.put(schoolLesson, random.nextInt(2, 6));
            }
            for (String region : regions) {
                olympiads.put(region, random.nextInt(0, 3));
            }
            Schooler schooler = new Schooler(name_gender[rand_number][0], name_gender[rand_number][1], random.nextInt(6, 19), marks, olympiads);
            schoolers.add(schooler);
        }

        for (int i = 0; i < 5000; i++) {
            rand_number = random.nextInt(name_gender.length);
            HashMap<String, Integer> marks = new HashMap<>();
            HashMap<String, Integer> works = new HashMap<>();
            for (String university_lesson : university_lessons) {
                marks.put(university_lesson, random.nextInt(2, 6));
            }
            for (String course_work : course_works) {
                // 1 = отсутствие оценки, 2-5 = оценки за курсовые
                works.put(course_work, random.nextInt(1, 6));
            }
            Student student = new Student(name_gender[rand_number][0], name_gender[rand_number][1], random.nextInt(18, 25), marks, works);
            students.add(student);
        }
        System.out.println("Информация о девочках, получивших первое место на олимпиадах любого уровня: ");
        for (Schooler man : schoolers) {
            if (man.get_olympiads().containsValue(2) && man.get_gender().contains("Ж")) {
                System.out.println(man.get_official_name());
            }
        }
        System.out.println();
        System.out.println("Информация о студентах с оценками за курсовую: ");
        for (Student man : students) {
            if (man.get_works().containsValue(2) || man.get_works().containsValue(3) || man.get_works().containsValue(4) || man.get_works().containsValue(5)) {
                System.out.println(man.get_official_name());
            }
        }
        System.out.println();
        System.out.println("Информация об обучающихся с повышенной стипендией: ");
        for (Schooler man : schoolers) {
            if (man.deserve_bonus()) {
                System.out.println(man.get_official_name());
            }
        }
        for (Student man : students) {
            if (man.deserve_bonus()) {
                System.out.println(man.get_official_name());
            }
        }
    }

}