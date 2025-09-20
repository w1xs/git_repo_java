package laba_4_5;

import java.util.HashMap;
import java.util.Map;

public class Student extends Learner implements Student_interface {
    Map<String, Integer> marks = new HashMap<>();
    Map<String, Integer> works = new HashMap<>();

    Student(){};
    public Student(String name, String second_name, String gender, int age, Map<String, Integer> marks, Map<String, Integer> works){
        super(name, second_name, gender, age);
        this.marks = marks;
        this.works = works;
    }
    @Override
    public Map<String, Integer> get_marks() {
        return marks;
    }

    public void set_marks(Map<String, Integer> marks) {
        this.marks = marks;
    }
    @Override
    public Map<String, Integer> get_works() {
        return works;
    }

    public void set_works(Map<String, Integer> works) {
        this.works = works;
    }
    @Override
    public Boolean deserve_bonus(){
        float mean_mark = 0;
        int count_marks = 0;
        int value_marks = 0;

        for(String key : marks.keySet()){
            value_marks += marks.get(key);
            count_marks ++;
        }
        mean_mark = (float)value_marks/count_marks;
        if(mean_mark <= 4.75){
            return Boolean.FALSE;
        }

        for(String key : works.keySet()){
            if(works.get(key) != 5){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public int get_learning_rate(){
        int marks_value = 0;
        int works_value = 0;
        float marks_rate = 0;
        float works_rate = 0;
        int learning_rate = 0;
        for(String key : marks.keySet()){
            marks_value += marks.get(key);
        }
        marks_rate = ((float) marks_value / (marks.size() * 5)) * 100;
        for(String key : works.keySet()){
            works_value += works.get(key);
        }
        works_rate = ((float) works_value / (works.size() * 5)) * 100;

        learning_rate = (int)(marks_rate + works_rate) / 2;
        return learning_rate;
    }

    @Override
    public String get_official_name() {
        return "Студент/ка " + this.name + " " + this.second_name;
    }
}
