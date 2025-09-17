package laba_4;


import java.util.HashMap;
import java.util.Map;

public class Schooler extends Learner {
    Map<String, Integer> marks = new HashMap<>();
    Map<String, Integer> olympiads = new HashMap<>();

    Schooler() {
    }



    public Schooler(String name, String gender, int age, Map<String, Integer> marks, Map<String, Integer> olympiads) {
        super(name, gender, age);
        this.marks = marks;
        this.olympiads = olympiads;
    }

    public Map<String, Integer> get_marks() {
        return marks;
    }

    public void set_marks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public Map<String, Integer> get_olympiads() {
        return olympiads;
    }

    public void set_olympiads(Map<String, Integer> olympiads) {
        this.olympiads = olympiads;
    }

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
    public String get_official_name(){
        return "Школьник/ница " + this.name;
    }
}
