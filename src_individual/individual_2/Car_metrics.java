package individual_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Car_metrics {

    public static int get_max_price(ArrayList<Car> cars){
        return cars.stream().max(Comparator.comparing(Car::get_price)).get().get_price();
    }

    public static int get_min_price(ArrayList<Car> cars){
        return cars.stream().min(Comparator.comparing(Car::get_price)).get().get_price();
    }

    public static double get_mean_price(ArrayList<Car> cars){
        double all_prices = cars.stream().mapToInt(Car::get_price).sum();
        long count_cars = cars.size();
        return (double) all_prices / count_cars;
    }

    public static String get_popular_color(ArrayList<Car> cars){
        HashMap<String, Integer> colors = new HashMap<>();
        String popular_color = "";
        int most_popular = 0;
        for(Car car : cars){
            if(colors.containsKey(car.get_color())){
                colors.put(car.get_color(), colors.get(car.get_color()) + 1);
            }
            else{
                colors.put(car.get_color(), 1);
            }
        }
        for(String color : colors.keySet()){
            if(colors.get(color) > most_popular){
                most_popular = colors.get(color);
                popular_color = color;
            }
        }

        return popular_color;
    }

    public static long get_count_good_car(ArrayList<Car> cars){
        return cars.stream().filter((C) -> C.get_condition().equals("clean vehicle")).count();
    }

    public static long get_count_fine_car(ArrayList<Car> cars){
        return cars.stream().filter((C) -> C.get_condition().equals("salvage insurance")).count();
    }

    public static double get_mean_mileage(ArrayList<Car> cars){
        double all_mileage = cars.stream().mapToDouble(Car::get_mileage).sum();
        long count_cars = cars.size();
        return (double) all_mileage / count_cars;
    }
}
