package individual_2;

public class Car {
    int price;
    String brand;
    String model;
    int year;
    String condition;
    double mileage;
    String color;
    String id;
    int serial_number;

    public Car(){};

    public Car(int price, String brand, String model, int year, String condition, float mileage, String color, String id, int serial_number){
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.mileage = mileage;
        this.color = color;
        this.id = id;
        this.serial_number = serial_number;
    }

    public Car(Car other_car){
        this.price = other_car.price;
        this.brand = other_car.brand;
        this.model = other_car.model;
        this.year = other_car.year;
        this.condition = other_car.condition;
        this.mileage = other_car.mileage;
        this.color = other_car.color;
        this.id = other_car.id;
        this.serial_number = other_car.serial_number;
    }

    public int get_price() {
        return price;
    }

    public void set_price(int price) {
        this.price = price;
    }

    public String get_brand() {
        return brand;
    }

    public void set_brand(String brand) {
        this.brand = brand;
    }

    public String get_model() {
        return model;
    }

    public void set_model(String model) {
        this.model = model;
    }

    public int get_year() {
        return year;
    }

    public void set_year(int year) {
        this.year = year;
    }

    public String get_condition() {
        return condition;
    }

    public void set_condition(String condition) {
        this.condition = condition;
    }

    public double get_mileage() {
        return mileage;
    }

    public void set_mileage(double mileage) {
        this.mileage = mileage;
    }

    public String get_color() {
        return color;
    }

    public void set_color(String color) {
        this.color = color;
    }

    public String get_id() {
        return id;
    }

    public void set_id(String id) {
        this.id = id;
    }

    public int get_serial_number() {
        return serial_number;
    }

    public void set_serial_number(int serial_number) {
        this.serial_number = serial_number;
    }
}
