package individual_1;

import java.util.ArrayList;

public class Event {
    private String season;
    private int year;
    private String city;
    private ArrayList<Winner> winners;

    public Event(){};

    public Event(String season, int year, String city, ArrayList<Winner> winners){
        this.season = season;
        this.year = year;
        this.city = city;
        this.winners = winners;
    }

    public Event(Event other_event){
        this.season = other_event.season;
        this.year = other_event.year;
        this.city = other_event.city;
        this.winners = other_event.winners;
    }

    public String get_season() {
        return season;
    }

    public void set_season(String season) {
        this.season = season;
    }

    public int get_year() {
        return year;
    }

    public void set_year(int year) {
        this.year = year;
    }

    public String get_city() {
        return city;
    }

    public void set_city(String city) {
        this.city = city;
    }

    public ArrayList<Winner> get_winners() {
        return winners;
    }

    public void set_winners(ArrayList<Winner> winners) {
        this.winners = winners;
    }
}
