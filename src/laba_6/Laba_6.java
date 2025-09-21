package laba_6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Laba_6 {
    // Выдумал следующее: классы - это дикт, где ключи - номер класса, значение - список учеников класса
    // Каждый ученик - дикт с полями имя, фамилия и т.д.
    public HashMap<String, ArrayList<HashMap<String, Object>>> task_1(int mark, HashMap<String, ArrayList<HashMap<String, Object>>>  classes) {
        HashMap<String, ArrayList<HashMap<String, Object>>> result = new HashMap<>();
        ArrayList<HashMap<String, Object>> std = new ArrayList<>();
        for (String key : classes.keySet()) {
            for (HashMap<String, Object> man : classes.get(key)) {
                if ((int) man.get("mark") == mark) {
                    if (result.containsKey(key)) {
                        std = result.get(key);
                        std.add(man);
                        result.put(key, std);
                    }
                    std.clear();
                    std.add(man);
                    result.put(key, std);
                }
            }
        }
        return result;
    }
    public HashMap<String, ArrayList<HashMap<String, Object>>> task_2(HashMap<String, ArrayList<HashMap<String, Object>>>  classes){
        HashMap<String, ArrayList<HashMap<String, Object>>> result = new HashMap<>();
        ArrayList<HashMap<String, Object>> std = new ArrayList<>();
        HashMap<String, Object> mean = new HashMap<>();
        HashMap<String, ArrayList<HashMap<String, Object>>> base = classes;
        int marks_count = 0, marks_value = 0;
        float marks_mean = 0, min_mean_mark = 6;
        String min_class_id = "1";

        for(String key : base.keySet()){
            for(HashMap<String, Object> man : base.get(key)){
                marks_value += (int)man.get("mark");
                marks_count++;
            }
            marks_mean = (float)marks_value/marks_count;
            mean.put("marks_mean", marks_mean);
            std = base.get(key);
            std.add(mean);
            mean.clear();
            marks_count = 0;
            marks_value = 0;
        }
        while(!base.isEmpty()){
            for(String key : base.keySet()){
                std = base.get(key);
                if((float)std.getLast().get("marks_mean") <= min_mean_mark){
                    min_mean_mark = (float)std.getLast().get("marks_mean");
                    min_class_id = key;
                }
            }
            std = base.get(min_class_id);
            result.put(min_class_id, std);
            base.remove(min_class_id);
            min_mean_mark = 6;
        }
        return result;
    }
    public ArrayList<HashMap<String, Object>> task_3(String lesson, HashMap<String, ArrayList<HashMap<String, Object>>>  classes){
        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> buffer = new HashMap<>();
        for(String key : classes.keySet()){
            for(HashMap<String, Object> man : classes.get(key)){
                if(man.get("lesson").equals(lesson)){
                    result.add(man);
                }
            }
        }
        for(int i = 0; i < result.toArray().length; i++){
            for(int j = i+1; j < result.toArray().length - 1; j++){
                if(result.get(i).get("second_name").toString().compareTo(result.get(j).get("second_name").toString()) > 0){
                    buffer = result.get(i);
                    result.add(i, result.get(j));
                    result.add(j, buffer);
                }
            }
        }
        return result;
    }

//    public HashMap<String, ArrayList<HashMap<String, Object>>> task_4(HashMap<String, ArrayList<HashMap<String, Object>>>  classes){
//
//    }
}
