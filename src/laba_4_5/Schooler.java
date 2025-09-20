package laba_4_5;


import java.util.HashMap;
import java.util.Map;

public class Schooler extends Learner implements Schooler_compare {
    int school_number;
    Map<String, Integer> marks = new HashMap<>();
    Map<String, Integer> olympiads = new HashMap<>();

    Schooler() {
    }



    public Schooler(String name, String second_name, String gender, int age, int school_number, Map<String, Integer> marks, Map<String, Integer> olympiads) {
        super(name, second_name, gender, age);
        this.school_number = school_number;
        this.marks = marks;
        this.olympiads = olympiads;
    }
    @Override
    public int get_school_number() {
        return school_number;
    }

    public void set_school_number(int school_number) {
        this.school_number = school_number;
    }
    @Override
    public Map<String, Integer> get_marks() {
        return marks;
    }

    public void set_marks(Map<String, Integer> marks) {
        this.marks = marks;
    }
    @Override
    public Map<String, Integer> get_olympiads() {
        return olympiads;
    }

    public void set_olympiads(Map<String, Integer> olympiads) {
        this.olympiads = olympiads;
    }
    @Override
    public Boolean deserve_bonus(){
        for(String key : marks.keySet()){
            switch (key){
                case "математика": if (marks.get(key) != 5) return Boolean.FALSE;
                case "русский язык": if (marks.get(key) != 5) return Boolean.FALSE;
                case "история": if (marks.get(key) != 5) return Boolean.FALSE;
                case "английский язык": if (marks.get(key) != 5) return Boolean.FALSE;
                default: if (marks.get(key) < 4) return Boolean.FALSE;
            }
        }

        // Для олипиад буду считать, что 2 - победитель, 1 - призовое место, 0 - участник

        if(olympiads.get("область") == 0 || olympiads.get("город") == 1 || olympiads.get("школа") == 2){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public int get_learning_rate(){
        int marks_value = 0;
        int olympiads_value = 0;
        float marks_rate = 0;
        float olympiads_rate = 0;
        int learning_rate = 0;
        for(String key : marks.keySet()){
            marks_value += marks.get(key);
        }
        marks_rate = ((marks.size() * 5 - marks_value) / marks.size() * 5) * 100;
        for(String key : olympiads.keySet()){
            olympiads_value += olympiads.get(key);
        }
        olympiads_rate = ((olympiads.size() * 2 - olympiads_value) / olympiads.size() * 2) * 100;

        learning_rate = (int)(marks_rate + olympiads_rate) / 2;
        return learning_rate;
    }

    @Override
    public String get_official_name(){
        return "Школьник/ница " + this.name +" " + this.second_name + " школы номер " + this.school_number;
    }
}
