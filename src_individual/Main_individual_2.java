import Individual_1.*;
import individual_2.Car;
import individual_2.Car_metrics;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

//        Индивиудальная работа №2, задача 27
        LinkedHashMap<Integer, ArrayList<Car>> cars = new LinkedHashMap<Integer, ArrayList<Car>>();
        LinkedHashMap<Integer, ArrayList<Car>> cars_by_year = new LinkedHashMap<Integer, ArrayList<Car>>();
        ArrayList<Car> std = new ArrayList<>();
        String output_line = "";
        int min_year = 0;
        String line;

        try (BufferedReader reader = new BufferedReader( new FileReader("src/data/data_auto.txt"))){
            line = reader.readLine();
            while(line != null){
                Car car = new Car();
                line = reader.readLine();
                car.set_price(Integer.parseInt(line.strip()));
                line = reader.readLine();
                car.set_brand(line.strip());
                line = reader.readLine();
                car.set_model(line.strip());
                line = reader.readLine();
                car.set_year(Integer.parseInt(line.strip()));
                line = reader.readLine();
                car.set_condition(line.strip());
                line = reader.readLine();
                // В исходных данных, пробег идет в милях, а мне нужен в км
                car.set_mileage(Double.parseDouble(line.strip()) * 1.61);
                line = reader.readLine();
                car.set_color(line.strip());
                line = reader.readLine();
                car.set_id(line.strip());
                line = reader.readLine();
                car.set_serial_number(Integer.parseInt(line.strip()));
                line = reader.readLine();

                if(cars.containsKey(car.get_year())){
                    std = cars.get(car.get_year());
                    std.add(car);
                    cars.put(car.get_year(), std);
                }
                else{
                    std = new ArrayList<>();
                    std.add(car);
                    cars.put(car.get_year(), std);
                }
            }
        }
        catch (IOException e){
            System.out.println("Произошла ошибка считывания: " + e.toString());
            System.exit(228);
        }

        min_year = cars.sequencedKeySet().getFirst();

        for(Integer key: cars.keySet()){
            if(key < min_year){
                min_year = key;
            }
        }

        cars_by_year.put(min_year, cars.get(min_year));

        for(int i = min_year; i < min_year + 300; i++){
            if(cars.containsKey(i)){
                cars_by_year.put(i, cars.get(i));
            }
        }

        System.out.println("Данные по годам:");
        System.out.println("Год || Средняя цена || Минимальная цена || Максимальная цена || Лучший цвет || Clean vehicle || Salvage insurance || Средний пробег");
        for(int key : cars_by_year.keySet()){
            System.out.printf("%4d ", key);
            System.out.printf("%12.3f ", Car_metrics.get_mean_price(cars.get(key)));
            System.out.printf("%16d ", Car_metrics.get_min_price(cars_by_year.get(key)));
            System.out.printf("%20d ", Car_metrics.get_max_price(cars_by_year.get(key)));
            System.out.printf("%18s ", Car_metrics.get_popular_color(cars_by_year.get(key)));
            System.out.printf("%12d ", Car_metrics.get_count_good_car(cars_by_year.get(key)));
            System.out.printf("%16d ", Car_metrics.get_count_fine_car(cars_by_year.get(key)));
            System.out.printf("%24.3f ", Car_metrics.get_mean_mileage(cars_by_year.get(key)));
            System.out.println();
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/result.txt"))){
            writer.write("Данные по годам:");
            writer.newLine();
            writer.write("Год || Средняя цена || Минимальная цена || Максимальная цена || Лучший цвет || Clean vehicle || Salvage insurance || Средний пробег");
            writer.newLine();
            for(int key : cars_by_year.keySet()){
                output_line = String.format("%4d ", key);
                writer.write(output_line);
                output_line = String.format("%12.3f ", Car_metrics.get_mean_price(cars.get(key)));
                writer.write(output_line);
                output_line = String.format("%16d ", Car_metrics.get_min_price(cars_by_year.get(key)));
                writer.write(output_line);
                output_line = String.format("%20d ", Car_metrics.get_max_price(cars_by_year.get(key)));
                writer.write(output_line);
                output_line = String.format("%18s ", Car_metrics.get_popular_color(cars_by_year.get(key)));
                writer.write(output_line);
                output_line = String.format("%12d ", Car_metrics.get_count_good_car(cars_by_year.get(key)));
                writer.write(output_line);
                output_line = String.format("%16d ", Car_metrics.get_count_fine_car(cars_by_year.get(key)));
                writer.write(output_line);
                output_line = String.format("%24.3f ", Car_metrics.get_mean_mileage(cars_by_year.get(key)));
                writer.write(output_line);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println("Ошибка записи в файл: " + e);
            System.exit(229);
        }
    }
}