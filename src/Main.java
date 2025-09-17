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

        for(int i = 0; i < 40; i++){
            rand_number = random.nextInt(name_gender.length);
            HashMap<String, Integer> marks = new HashMap<>();
            HashMap<String, Integer> olympiads = new HashMap<>();
            for(int j = 0; j < school_lessons.length; j++){
                marks.put(school_lessons[j], random.nextInt(2, 5));
            }
            for(int j = 0; j < regions.length; j++){
                olympiads.put(regions[j], random.nextInt(0, 2));
            }
            Schooler schooler = new Schooler(name_gender[rand_number][0], name_gender[rand_number][1], random.nextInt(6, 18), marks, olympiads);
            schoolers.add(schooler);
        }

        for(int i = 0; i < 40; i++){
            rand_number = random.nextInt(name_gender.length);
            HashMap<String, Integer> marks = new HashMap<>();
            HashMap<String, Integer> works = new HashMap<>();
            for(int j = 0; j < university_lessons.length; j++){
                marks.put(university_lessons[j], random.nextInt(2, 5));
            }
            for(int j = 0; j < course_works.length; j++){
                works.put(regions[j], random.nextInt(2, 5));
            }
            Student student = new Student(name_gender[rand_number][0], name_gender[rand_number][1], random.nextInt(18, 24), marks, works);
            students.add(student);
        }

        for(Schooler man : schoolers){
            if(man.get_marks())
        }
}