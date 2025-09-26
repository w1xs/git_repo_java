package laba_4_5;

public class Learner implements Learner_interface {
    String name;
    String second_name;
    String gender;
    int age;
    int learning_rate = 0;

    Learner() {
    }



    Learner(String name, String second_name, String gender, int age) {
        this.name = name;
        this.second_name = second_name;
        this.gender = gender;
        this.age = age;
    }
    @Override
    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }
    @Override
    public String get_second_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @Override
    public String get_gender() {
        return gender;
    }

    public void set_gender(String gender) {
        this.gender = gender;
    }
    @Override
    public int get_age() {
        return age;
    }

    public void set_age(int age) {
        this.age = age;
    }

    @Override
    public int get_learning_rate(){
        return this.learning_rate;
    }

    @Override
    public String get_official_name() {
        return "Учащийся/аяся " + this.name;
    }


}
