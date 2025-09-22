import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import laba_4_5.*;
import laba_6.Laba_6;
import laba_7.Laba_7;
import laba_4_5.comparator_classes.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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
//
//        String[][] name_gender = {{"Николай", "М"}, {"Павел", "М"}, {"Екатерина", "Ж"}, {"Валерий", "М"}, {"София", "Ж"},
//                {"Дарья", "Ж"}, {"Михаил", "М"}, {"Алина", "Ж"}, {"Геннадий", "М"}, {"Тимофей", "М"}, {"Мария", "Ж"},
//                {"Виктория", "Ж"}, {"Никита", "М"}, {"Светлана", "Ж"}, {"Валерия", "Ж"}, {"Дмитрий", "М"}, {"Кристина", "Ж"},
//                {"Иван", "М"}, {"Елена", "Ж"}, {"Игорь", "М"}, {"Полина", "Ж"}, {"Александр", "М"}};
//        String[] second_name_male = {"Иванов", "Петров", "Мухин", "Даванков", "Путин", "Никольский", "Ленин", "Кравцов", "Пушкин",
//                "Поляков", "Зайцев", "Волгин", "Семихатов", "Витюгин", "Заводов", "Рублев", "Расторгуев", "Левин", "Правин", "Лужин",
//                "Каменчук", "Попов", "Зимов", "Малышев", "Грушин", "Чайковский", "Корсаков", "Тронди", "Ронин"};
//        String[] second_name_female = {"Иванова", "Петрова", "Мухина", "Даванкова", "Путина", "Никольская", "Ленина", "Кравцова", "Пушкина",
//                "Полякова", "Зайцева", "Волгина", "Семихатова", "Витюгина", "Заводова", "Рублева", "Расторгуева", "Левина", "Правина", "Лужина",
//                "Каменчук", "Попова", "Зимова", "Малышева", "Грушина", "Чайковская", "Корсакова", "Трондина", "Ронина"};
//        String[] school_lessons = {"математика", "русский язык", "история", "английский язык", "физика", "химия", "физ-ра"};
//        String[] regions = {"школа", "город", "область"};
//        String[] university_lessons = {"линейная алгебра", "история", "исностранный язык", "дискретная математика", "программирование"};
//        String[] course_works = {"курсовая 1", "курсовая 2", "курсовая 3"};
//        int rand_number = 0;
//        ArrayList<Schooler> schoolers = new ArrayList<>();
//        ArrayList<Student> students = new ArrayList<>();
//        Random random = new Random();
//
//        for (int i = 0; i < 5000; i++) {
//            String second_name;
//            rand_number = random.nextInt(name_gender.length);
//            HashMap<String, Integer> marks = new HashMap<>();
//            HashMap<String, Integer> olympiads = new HashMap<>();
//            for (String schoolLesson : school_lessons) {
//                marks.put(schoolLesson, random.nextInt(2, 6));
//            }
//            for (String region : regions) {
//                olympiads.put(region, random.nextInt(0, 3));
//            }
//
//            if(name_gender[rand_number][1].contains("Ж")) {
//                second_name = second_name_female[random.nextInt(second_name_female.length)];
//            }
//            else {
//                second_name = second_name_male[random.nextInt(second_name_male.length)];
//            }
//
//            Schooler schooler = new Schooler(name_gender[rand_number][0], second_name, name_gender[rand_number][1], random.nextInt(6, 19), random.nextInt(1, 50), marks, olympiads);
//            schoolers.add(schooler);
//        }
//
//        for (int i = 0; i < 5000; i++) {
//            rand_number = random.nextInt(name_gender.length);
//            HashMap<String, Integer> marks = new HashMap<>();
//            HashMap<String, Integer> works = new HashMap<>();
//            String second_name;
//            for (String university_lesson : university_lessons) {
//                marks.put(university_lesson, random.nextInt(2, 6));
//            }
//            for (String course_work : course_works) {
//                // 1 = отсутствие оценки, 2-5 = оценки за курсовые
//                works.put(course_work, random.nextInt(1, 6));
//            }
//
//            if(name_gender[rand_number][1].contains("Ж")) {
//                second_name = second_name_female[random.nextInt(second_name_female.length)];
//            }
//            else {
//                second_name = second_name_male[random.nextInt(second_name_male.length)];
//            }
//
//            Student student = new Student(name_gender[rand_number][0], second_name, name_gender[rand_number][1], random.nextInt(18, 25), marks, works);
//            students.add(student);
//        }
//        System.out.println("Информация о девочках, получивших первое место на олимпиадах любого уровня: ");
//        for (Schooler man : schoolers) {
//            if (man.get_olympiads().containsValue(2) && man.get_gender().contains("Ж")) {
//                System.out.println(man.get_official_name());
//            }
//        }
//        System.out.println();
//        System.out.println("Информация о студентах с оценками за курсовую: ");
//        for (Student man : students) {
//            if (man.get_works().containsValue(2) || man.get_works().containsValue(3) || man.get_works().containsValue(4) || man.get_works().containsValue(5)) {
//                System.out.println(man.get_official_name());
//            }
//        }
//        System.out.println();
//        System.out.println("Информация об обучающихся с повышенной стипендией: ");
//        for (Schooler man : schoolers) {
//            if (man.deserve_bonus()) {
//                System.out.println(man.get_official_name());
//            }
//        }
//        for (Student man : students) {
//            if (man.deserve_bonus()) {
//                System.out.println(man.get_official_name());
//            }
//        }


//        Лаба 5
//
//
//        String[][] name_gender = {{"Николай", "М"}, {"Павел", "М"}, {"Екатерина", "Ж"}, {"Валерий", "М"}, {"София", "Ж"},
//                {"Дарья", "Ж"}, {"Михаил", "М"}, {"Алина", "Ж"}, {"Геннадий", "М"}, {"Тимофей", "М"}, {"Мария", "Ж"},
//                {"Виктория", "Ж"}, {"Никита", "М"}, {"Светлана", "Ж"}, {"Валерия", "Ж"}, {"Дмитрий", "М"}, {"Кристина", "Ж"},
//                {"Иван", "М"}, {"Елена", "Ж"}, {"Игорь", "М"}, {"Полина", "Ж"}, {"Александр", "М"}};
//        String[] second_name_male = {"Иванов", "Петров", "Мухин", "Даванков", "Путин", "Никольский", "Ленин", "Кравцов", "Пушкин",
//                "Поляков", "Зайцев", "Волгин", "Семихатов", "Витюгин", "Заводов", "Рублев", "Расторгуев", "Левин", "Правин", "Лужин",
//                "Каменчук", "Попов", "Зимов", "Малышев", "Грушин", "Чайковский", "Корсаков", "Тронди", "Ронин"};
//        String[] second_name_female = {"Иванова", "Петрова", "Мухина", "Даванкова", "Путина", "Никольская", "Ленина", "Кравцова", "Пушкина",
//                "Полякова", "Зайцева", "Волгина", "Семихатова", "Витюгина", "Заводова", "Рублева", "Расторгуева", "Левина", "Правина", "Лужина",
//                "Каменчук", "Попова", "Зимова", "Малышева", "Грушина", "Чайковская", "Корсакова", "Трондина", "Ронина"};
//        String[] school_lessons = {"математика", "русский язык", "история", "английский язык", "физика", "химия", "физ-ра"};
//        String[] regions = {"школа", "город", "область"};
//        String[] university_lessons = {"линейная алгебра", "история", "исностранный язык", "дискретная математика", "программирование"};
//        String[] course_works = {"курсовая 1", "курсовая 2", "курсовая 3"};
//        int rand_number = 0;
//        ArrayList<Schooler> schoolers = new ArrayList<>();
//        ArrayList<Student> students = new ArrayList<>();
//        ArrayList<Learner> high_payment = new ArrayList<>();
//        Random random = new Random();
//
//        for (int i = 0; i < 20000; i++) {
//            String second_name;
//            rand_number = random.nextInt(name_gender.length);
//            HashMap<String, Integer> marks = new HashMap<>();
//            HashMap<String, Integer> olympiads = new HashMap<>();
//            for (String schoolLesson : school_lessons) {
//                marks.put(schoolLesson, random.nextInt(2, 6));
//            }
//            for (String region : regions) {
//                olympiads.put(region, random.nextInt(0, 3));
//            }
//
//            if(name_gender[rand_number][1].contains("Ж")) {
//                second_name = second_name_female[random.nextInt(second_name_female.length)];
//            }
//            else {
//                second_name = second_name_male[random.nextInt(second_name_male.length)];
//            }
//
//            Schooler schooler = new Schooler(name_gender[rand_number][0], second_name, name_gender[rand_number][1], random.nextInt(6, 19), random.nextInt(1, 50), marks, olympiads);
//            schoolers.add(schooler);
//        }
//
//        for (int i = 0; i < 20000; i++) {
//            rand_number = random.nextInt(name_gender.length);
//            HashMap<String, Integer> marks = new HashMap<>();
//            HashMap<String, Integer> works = new HashMap<>();
//            String second_name;
//            for (String university_lesson : university_lessons) {
//                marks.put(university_lesson, random.nextInt(2, 6));
//            }
//            for (String course_work : course_works) {
//                // 1 = отсутствие оценки, 2-5 = оценки за курсовые
//                works.put(course_work, random.nextInt(1, 6));
//            }
//
//            if(name_gender[rand_number][1].contains("Ж")) {
//                second_name = second_name_female[random.nextInt(second_name_female.length)];
//            }
//            else {
//                second_name = second_name_male[random.nextInt(second_name_male.length)];
//            }
//
//            Student student = new Student(name_gender[rand_number][0], second_name, name_gender[rand_number][1], random.nextInt(18, 25), marks, works);
//            students.add(student);
//        }
//
//        // task 1
//        for (Schooler man : schoolers) {
//            if (man.deserve_bonus()) {
//                high_payment.add(man);
//            }
//        }
//        for (Student man : students) {
//            if (man.deserve_bonus()) {
//                high_payment.add(man);
//            }
//        }
//
//        Second_name_comparator second_name_comparator = new Second_name_comparator();
//        high_payment.sort(second_name_comparator);
//        System.out.println("Студенты и школьники, получающие повышенную стипендию, отсортированы по фамилии: ");
//        for(Learner man : high_payment){
//            System.out.println(man.get_official_name());
//        }
//
//        //task 2
//        Learning_rate_comparator learning_rate_comparator = new Learning_rate_comparator();
//        System.out.println();
//        System.out.println("Школьник с лучшей успеваемостью: ");
//        schoolers.sort(learning_rate_comparator);
//        System.out.println(schoolers.getLast().get_official_name());
//        System.out.println("Успеваемость равна" + " " + schoolers.getLast().get_learning_rate() + "%");
//        System.out.println("Студент с лучшей успеваемостью: ");
//        students.sort(learning_rate_comparator);
//        System.out.println(students.getLast().get_official_name());
//        System.out.println("Успеваемость равна" + " " + students.getLast().get_learning_rate() + "%");
//
//        //task 3
//        Learning_rate_then_school_number_comparator complicated_comparator = new Learning_rate_then_school_number_comparator();
//        schoolers.sort(complicated_comparator);
//        System.out.println();
//        System.out.println("Школьники, отсортированные по успеваемости, а затем по номеру школы");
//        for(Schooler man : schoolers){
//            System.out.println(man.get_official_name());
//        }
//
//        //task 4
//        System.out.println();
//        System.out.println("Список студентов по увеличению успеваемости: ");
//        for(Student man : students){
//            System.out.println(man.get_official_name());
//            System.out.println("Успеваемость равна" + " " + man.get_learning_rate() + "%");
//        }
//

//        Лаба 6
//        String line;
//        String[] line_parts;
//        HashMap<String, ArrayList<HashMap<String, Object>>>  classes = new HashMap<>();
//        ArrayList<HashMap<String, Object>> std = new ArrayList<>();
//        HashMap<String, Object> man = new HashMap<>();
//        try (BufferedReader reader = new BufferedReader( new FileReader("git_repo_java/src/laba_6/laba_6_data.txt"))){
//            line = reader.readLine();
//            while (line != null){
//                line_parts = line.split(" ");
//                man = new HashMap<>();
//                std = new ArrayList<>();
//                man.put("name", line_parts[1]);
//                man.put("second name", line_parts[0]);
//                man.put("lesson", line_parts[3]);
//                man.put("mark", line_parts[4]);
//                if(classes.containsKey(line_parts[2])){
//                    std = classes.get(line_parts[2]);
//                    std.add(man);
//                    classes.put(line_parts[2], std);
//                }
//                else{
//                    std.add(man);
//                    classes.put(line_parts[2], std);
//                }
//                line = reader.readLine();
//            }
//            reader.close();
//        }
//        catch (IOException e){
//            throw new RuntimeException(e);
//        }

//        вывод в консоль журнала классов
//        for(String key : classes.keySet()){
//            System.out.println("Номер класса: " + key);
//            for(HashMap<String, Object> schooler : classes.get(key)){
//                System.out.println(schooler.get("name").toString() + " " + schooler.get("second name").toString() + " оценка по предмету " + schooler.get("lesson").toString() + ": " + schooler.get("mark").toString());
//            }
//        }

//        запись журналов в файлы
//        for(String key : classes.keySet()){
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter("git_repo_java/src/laba_6/class_"+key+"_data.txt"))) {
//                writer.write("Журнал класса №" + key);
//                writer.newLine();
//                for(HashMap<String, Object> schooler : classes.get(key)){
//                    writer.write(schooler.get("name").toString() + " " + schooler.get("second name").toString() + " оценка по предмету " + schooler.get("lesson").toString() + ": " + schooler.get("mark").toString());
//                    writer.newLine();
//                }
//                writer.close();
//            }
//            catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


//        task_1
//        System.out.println("Введите оценку для составления списка учеников: ");
//        Scanner console_in = new Scanner(System.in);
//        String mark = console_in.next();
//        if(Laba_6.correct_int(mark)){
//            Laba_6.task_1(Integer.parseInt(mark), classes);
//        }
//        else{
//            System.out.println("Не верный ввод, повторите попытку.");
//        }

//        task_2
//        Laba_6.task_2(classes);

//        task_3
//        System.out.println("Введите название предмета для составления списка учеников: ");
//        Scanner console_in = new Scanner(System.in);
//        String lesson = console_in.next();
//        Laba_6.task_3(lesson, classes);

//        task_4
//        System.out.println("Доступные для составления списка учеников классы: ");
//        for(String key : classes.keySet()){
//            System.out.print(key + " ");
//        }
//        System.out.println();
//        System.out.println("Введите номер класса для составления списка учеников: ");
//        Scanner console_in = new Scanner(System.in);
//        String class_number = console_in.next();
//        if(Laba_6.correct_int(class_number)){
//            Laba_6.task_4(Integer.parseInt(class_number), classes);
//        }
//        else{
//            System.out.println("Не верный ввод");
//        }

//        task_5
//        Scanner console_in = new Scanner(System.in);
//        System.out.println("Введите имя ученика: ");
//        String name = console_in.next();
//        System.out.println("Введите фамилию ученика: ");
//        String second_name = console_in.next();
//        Laba_6.task_5(name, second_name, classes);

//        task_6
//        Laba_6.task_6(classes);


//        Лаба 7
//        task_1
//        Integer[] row_data = {-2, -5, -2, -4, 3, -6, -2,
//                -1, 5, 1, 1, 0, -1, 0, 3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11};
//        ArrayList<Integer> data = new ArrayList<>();
//        Collections.addAll(data, row_data);
//        Laba_7.task_1(data);

//        task_2
//        String data = "They used 233 features including 227 " +
//                "stylometric features and six novel social network-specific features " +
//                "like character-based ones numbers of alphabets, uppercase " +
//                "characters, special characters, word-based ones the total number of " +
//                "words, average word length, the number of words with 1 char, " +
//                "syntactic ones numbers of punctuation marks and functional " +
//                "words, the total number of sentences and many others";
//        Laba_7.task_2(data);

    }

}