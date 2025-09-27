package individual_1;

public class Winner {
    private String name;
    private String second_name;
    private String gender;
    private String country_code;
    private String sport_type;
    private String competition_name;
    private String medal;

    public Winner(){};

    public Winner(String name, String second_name, String gender, String country_code, String sport_type, String competition_name, String medal){
        this.name = name;
        this.second_name = second_name;
        this.gender = gender;
        this.country_code = country_code;
        this.sport_type = sport_type;
        this.competition_name = competition_name;
        this.medal = medal;
    }

    public Winner(Winner other_winner){
        this.name = other_winner.name;
        this.second_name = other_winner.second_name;
        this.gender = other_winner.gender;
        this.country_code = other_winner.country_code;
        this.sport_type = other_winner.sport_type;
        this.competition_name = other_winner.competition_name;
        this.medal = other_winner.medal;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_second_name() {
        return second_name;
    }

    public void set_second_name(String second_name) {
        this.second_name = second_name;
    }

    public String get_gender() {
        return gender;
    }

    public void set_gender(String gender) {
        this.gender = gender;
    }

    public String get_country_code() {
        return country_code;
    }

    public void set_country_code(String country_code) {
        this.country_code = country_code;
    }

    public String get_sport_type() {
        return sport_type;
    }

    public void set_sport_type(String sport_type) {
        this.sport_type = sport_type;
    }

    public String get_competition_name() {
        return competition_name;
    }

    public void set_competition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String get_medal() {
        return medal;
    }

    public void set_medal(String medal) {
        this.medal = medal;
    }

    @Override
    public String toString(){
        return "Имя и фамилия победителя: " + this.name + " " + this.second_name + "\n" + "Код страны победителя: " + this.country_code + "\n" + "Вид спорта: " + this.sport_type + " Название соревнования: " + this.competition_name + "\n" + "Завоеванная медаль: " + this.medal;
    }
}
