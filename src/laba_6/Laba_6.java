package laba_6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Laba_6 {
    public static Boolean correct_int(String input) {
        if (input.matches("^\\d+")) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
    // Выдумал следующее: классы - это дикт, где ключи - номер класса, значение - список учеников класса
    // Каждый ученик - дикт с полями имя, фамилия и т.д.
    public static void task_1(int mark, HashMap<String, ArrayList<HashMap<String, Object>>>  classes) {
        HashMap<String, ArrayList<HashMap<String, Object>>> result = new HashMap<>();
        ArrayList<HashMap<String, Object>> std = new ArrayList<>();
        for (String key : classes.keySet()) {
            for (HashMap<String, Object> man : classes.get(key)) {
                std = new ArrayList<>();
                if (Integer.parseInt(man.get("mark").toString()) == mark) {
                    if (result.containsKey(key)) {
                        std = result.get(key);
                        std.add(man);
                        result.put(key, std);
                    }
                    std.add(man);
                    result.put(key, std);
                }
            }
        }
        System.out.println("Список учеников с оценкой: " + mark);
        for(String key : result.keySet()){
            System.out.println("Класс №" + key);
            for(HashMap<String, Object> man : result.get(key)){
                System.out.println(man.get("name") + " " + man.get("second name") + " по предмету " + man.get("lesson"));
            }
        }
        return;
    }
    public static void task_2(HashMap<String, ArrayList<HashMap<String, Object>>>  classes){
        LinkedHashMap<String, ArrayList<HashMap<String, Object>>> result = new LinkedHashMap<>();
        ArrayList<HashMap<String, Object>> std = new ArrayList<>();
        HashMap<String, Object> mean = new HashMap<>();
        HashMap<String, ArrayList<HashMap<String, Object>>> base = classes;
        int marks_count = 0, marks_value = 0;
        float marks_mean = 0, min_mean_mark = 6;
        String min_class_id = "1";

        for(String key : base.keySet()){
            mean = new HashMap<>();
            for(HashMap<String, Object> man : base.get(key)){
                marks_value += Integer.parseInt(man.get("mark").toString());
                marks_count++;
            }
            marks_mean = (float)marks_value/marks_count;
            mean.put("marks_mean", String.valueOf(marks_mean));
            std = base.get(key);
            std.add(mean);
            marks_count = 0;
            marks_value = 0;
        }
        while(!base.isEmpty()){
            for(String key : base.keySet()){
                std = base.get(key);
                if(Float.parseFloat((String) std.getLast().get("marks_mean")) < min_mean_mark){
                    min_mean_mark = Float.parseFloat((String) std.getLast().get("marks_mean"));
                    min_class_id = key;
                }
            }
            std = base.get(min_class_id);
            result.put(min_class_id, std);
            base.remove(min_class_id);
            min_mean_mark = 6;
        }
        System.out.println("Классы, отсортированные по средней успеваемости: ");
        for(String key : result.keySet()){
            System.out.println("Класс №" + key + ". Средняя успеваемость: " + result.get(key).getLast().get("marks_mean").toString());
            result.get(key).removeLast();
            for(HashMap<String, Object> man : result.get(key)){
                System.out.println(man.get("name") + " " + man.get("second name"));
            }
        }
        return;
    }
    public static void task_3(String lesson, HashMap<String, ArrayList<HashMap<String, Object>>>  classes){
        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> buffer = new HashMap<>();
        for(String key : classes.keySet()){
            for(HashMap<String, Object> man : classes.get(key)){
                if(man.get("lesson").equals(lesson)){
                    result.add(man);
                }
            }
        }
        if(result.isEmpty()){
            System.out.println("Учеников с введенным предметом нет");
            return;
        }
        for(int i = result.toArray().length - 1; i >= 1; i--){
            for(int j = 0; j < i; j++){
                if(result.get(i).get("second name").toString().compareTo(result.get(j).get("second name").toString()) < 0){
                    buffer = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, buffer);
                }
            }
        }
        System.out.println("Список учеников всех классов для предмета: " + lesson);
        for(HashMap<String, Object> man : result){
            System.out.println(man.get("name") + " " + man.get("second name"));
        }
        return;
    }
    public static void task_4(int class_number, HashMap<String, ArrayList<HashMap<String, Object>>>  classes){
        HashMap<String, ArrayList<HashMap<String, Object>>> result = new HashMap<>();
        ArrayList<HashMap<String, Object>> std = new ArrayList<>();
        HashMap<String, Object> rebuild_man = new HashMap<>();
        ArrayList<HashMap<String, Object>> base = classes.get(Integer.toString(class_number));

        if(!classes.containsKey(Integer.toString(class_number))){
            System.out.println("Ошибка: Класса с таким номером нет");
            return;
        }

        for(HashMap<String, Object> man : base){
            rebuild_man = new HashMap<>();
            std = new ArrayList<>();
            if(result.containsKey(man.get("lesson"))){
                std = result.get(man.get("lesson"));
                rebuild_man.put("name", man.get("name"));
                rebuild_man.put("second name", man.get("second name"));
                rebuild_man.put("mark", man.get("mark"));
                std.add(rebuild_man);
                result.put(man.get("lesson").toString(), std);
            }
            else{
                rebuild_man.put("name", man.get("name"));
                rebuild_man.put("second name", man.get("second name"));
                rebuild_man.put("mark", man.get("mark"));
                std.add(rebuild_man);
                result.put(man.get("lesson").toString(), std);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("git_repo_java/src/laba_6/task_4.txt"))) {
            writer.write("Ведомость класса №" + class_number);
            writer.newLine();
            for (String key : result.keySet()) {
                writer.write("Предмет: " + key);
                writer.newLine();
                for(HashMap<String, Object> man : result.get(key)){
                    writer.write("  " + man.get("name") + " " + man.get("second name") + " оценка: " + man.get("mark"));
                    writer.newLine();
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void task_5(String name, String second_name, HashMap<String, ArrayList<HashMap<String, Object>>>  classes){
        for(String key : classes.keySet()){
            for(HashMap<String, Object> man : classes.get(key)){
                if(man.get("name").equals(name) && man.get("second name").equals(second_name)){
                    System.out.println(name + " " + second_name + " учится в " + key + " классе");
                    return;
                }
            }
        }
        System.out.println("Ученик с такими именем и фамилией не был найден");
        return;
    }
    public static void task_6(HashMap<String, ArrayList<HashMap<String, Object>>> classes){
        HashMap<String, ArrayList<HashMap<String, Object>>> result = new HashMap<>();
        ArrayList<HashMap<String, Object>> std = new ArrayList<>();
        HashMap<String, Object> rebuild_man = new HashMap<>();
        HashMap<String, Object> mean_mark = new HashMap<>();
        int marks_count = 0, marks_value = 0;
        float marks_mean = 0, max_mean_mark = 0;
        String max_mean_mark_lesson = "000";
        for(String key : classes.keySet()){
            for(HashMap<String, Object> man : classes.get(key)){
                std = new ArrayList<>();
                rebuild_man = new HashMap<>();
                if(result.containsKey(man.get("lesson"))){
                    std = result.get(man.get("lesson"));
                    rebuild_man.put("name", man.get("name"));
                    rebuild_man.put("second name", man.get("second name"));
                    rebuild_man.put("mark", man.get("mark"));
                    std.add(rebuild_man);
                    result.put(man.get("lesson").toString(), std);
                }
                else{
                    rebuild_man.put("name", man.get("name"));
                    rebuild_man.put("second name", man.get("second name"));
                    rebuild_man.put("mark", man.get("mark"));
                    std.add(rebuild_man);
                    result.put(man.get("lesson").toString(), std);
                }
            }
        }
        for(String key : result.keySet()){
            for(HashMap<String, Object> man : result.get(key)){
                marks_value += Integer.parseInt(man.get("mark").toString());
                marks_count++;
            }
            marks_mean = (float)marks_value/marks_count;
//            System.out.println("Предмет " + key + " оценка " + marks_mean);
            if(marks_mean > max_mean_mark){
                max_mean_mark = marks_mean;
                max_mean_mark_lesson = key;
            }
            marks_value = 0;
            marks_count = 0;
        }
        System.out.println("Предмет с самой высокой успеваемостью: " + max_mean_mark_lesson);
        return;
    }
}
