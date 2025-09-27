package laba_3;

public class Bus {
    int count_places;
    int ticket_value;
    int occupied_places;

    public Bus() {
    }



    public Bus(int count_places, int ticket_value, int occupied_places) {
        this.count_places = count_places;
        this.ticket_value = ticket_value;
        this.occupied_places = occupied_places;
    }

    public void set_count_places(int value) {
        this.count_places = value;
    }

    public void set_ticket_value(int value) {
        this.ticket_value = value;
    }

    public void set_occupied_places(int value) {
        this.occupied_places = value;
    }

    public int get_count_places() {
        return this.count_places;
    }

    public int get_ticket_value() {
        return this.ticket_value;
    }

    public int get_occupied_places() {
        return this.occupied_places;
    }

    public int calculate_free_places() {
        return this.count_places - this.occupied_places;
    }

    public int calculate_bus_fullness() {
        return Math.round(((this.count_places - this.occupied_places) / (float) this.count_places * 100));
    }

    public int calculate_occupied_places_price() {
        return this.occupied_places * this.ticket_value;
    }

}
