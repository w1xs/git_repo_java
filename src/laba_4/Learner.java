package laba_4;

public class Learner {
    String name;
    String gender;
    int age;

    Learner() {
    }



    Learner(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_gender() {
        return gender;
    }

    public void set_gender(String gender) {
        this.gender = gender;
    }

    public int get_age() {
        return age;
    }

    public void set_age(int age) {
        this.age = age;
    }

    public String get_official_name() {
        return "Учащийся/аяся " + this.name;
    }
}
