package laba_4;

import java.util.HashMap;
import java.util.Map;

public class Student extends Learner{
    Map<String, Integer> marks = new HashMap<>();
    Map<String, Integer> works = new HashMap<>();

    Student(){};
    public Student(String name, String gender, int age, Map<String, Integer> marks, Map<String, Integer> works){
        super(name, gender, age);
        this.marks = marks;
        this.works = works;
    }

    public Map<String, Integer> get_marks() {
        return marks;
    }

    public void set_marks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public Map<String, Integer> get_works() {
        return works;
    }

    public void set_works(Map<String, Integer> works) {
        this.works = works;
    }

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
    public String get_official_name() {
        return "Студент/ка " + this.name;
    }
}
