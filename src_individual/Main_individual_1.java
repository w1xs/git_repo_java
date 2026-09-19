import individual_1.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

//        Индивиудальная работа №1, задача 48

        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Winner> winners;
        ArrayList<Winner> std;
        String[] line_values;
        String line;
        // обработка данных по зимним играм
        try (BufferedReader reader = new BufferedReader( new FileReader("src/data/data_olimpic_winter.csv"))){
            line = reader.readLine();
            while (line != null){
                line_values = line.split(",");
                Winner winner = new Winner();
                winner.set_name(line_values[4].substring(0, line_values[4].length()-1).strip());
                winner.set_second_name(line_values[3].substring(1).strip());
                winner.set_gender(line_values[6].strip());
                winner.set_country_code(line_values[5].strip());
                winner.set_sport_type(line_values[2].strip());
                winner.set_competition_name(line_values[7].strip());
                winner.set_medal(line_values[8].strip());

                if(events.isEmpty()){
                    Event event = new Event();
                    std = new ArrayList<Winner>();
                    event.set_season("winter");
                    event.set_city(line_values[1].strip());
                    event.set_year(Integer.parseInt(line_values[0].strip()));
                    std.add(winner);
                    event.set_winners(std);
                    events.add(event);
                }

                if(events.getLast().get_year() != Integer.parseInt(line_values[0].strip()) && !events.getLast().get_city().equals(line_values[1].strip())){
                    Event event = new Event();
                    std = new ArrayList<Winner>();
                    event.set_season("winter");
                    event.set_city(line_values[1].strip());
                    event.set_year(Integer.parseInt(line_values[0].strip()));
                    std.add(winner);
                    event.set_winners(std);
                    events.add(event);
                }
                else{
                    std = events.getLast().get_winners();
                    std.add(winner);
                    events.getLast().set_winners(std);
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e){
            System.out.println("Произошла ошибка считывания: " + e.toString());
            System.exit(228);
        }

        //обработка данных по летним играм
        //в csv файле есть косяк: у некоторых спортсменов указано только фамилия, буду фиксить
        String[] male_names = {"Jones", "Carl", "Gustav", "Rudy", "Gendric"};
        String[] female_names = {"Judy", "Carla", "Nikole", "Helen", "Sky"};
        Random random = new Random();
        try (BufferedReader reader = new BufferedReader( new FileReader("src/data/data_olimpic_summer.csv"))){
            line = reader.readLine();
            while (line != null){
                line_values = line.split(",");
                Winner winner = new Winner();
                if(line_values.length == 12){
                    winner.set_name(line_values[4].substring(0, line_values[4].length()-1).strip());
                    winner.set_second_name(line_values[3].substring(1).strip());
                    winner.set_gender(line_values[6].strip());
                    winner.set_country_code(line_values[5].strip());
                    winner.set_sport_type(line_values[2].strip());
                    winner.set_competition_name(line_values[7].substring(1).strip() + ", " + line_values[8].strip() + ", " + line_values[9].strip() + ", " + line_values[10].substring(0, line_values[10].length()-1).strip());
                    winner.set_medal(line_values[11].strip());
                }
                if(line_values.length == 11){
                    winner.set_name(line_values[4].substring(0, line_values[4].length()-1).strip());
                    winner.set_second_name(line_values[3].substring(1).strip());
                    winner.set_gender(line_values[6].strip());
                    winner.set_country_code(line_values[5].strip());
                    winner.set_sport_type(line_values[2].strip());
                    winner.set_competition_name(line_values[7].substring(1).strip() + ", " + line_values[8].strip() + ", " + line_values[9].substring(0, line_values[9].length()-1).strip());
                    winner.set_medal(line_values[10].strip());
                }
                if(line_values.length == 10){
                    winner.set_name(line_values[4].substring(0, line_values[4].length()-1).strip());
                    winner.set_second_name(line_values[3].substring(1).strip());
                    winner.set_gender(line_values[6].strip());
                    winner.set_country_code(line_values[5].strip());
                    winner.set_sport_type(line_values[2].strip());
                    winner.set_competition_name(line_values[7].substring(1).strip() + ", " + line_values[8].substring(0, line_values[8].length()-1).strip());
                    winner.set_medal(line_values[9].strip());
                }
                if(line_values.length == 9){
                    winner.set_name(line_values[4].substring(0, line_values[4].length()-1).strip());
                    winner.set_second_name(line_values[3].substring(1).strip());
                    winner.set_gender(line_values[6].strip());
                    winner.set_country_code(line_values[5].strip());
                    winner.set_sport_type(line_values[2].strip());
                    winner.set_competition_name(line_values[7].strip());
                    winner.set_medal(line_values[8].strip());
                }
                if(line_values.length == 8){
                    winner.set_second_name(line_values[3].strip());
                    if(line_values[5].strip().equals("Men")){
                        winner.set_name(male_names[random.nextInt(male_names.length)]);
                    }
                    if(line_values[5].strip().equals("Women")){
                        winner.set_name(female_names[random.nextInt(female_names.length)]);
                    }
                    winner.set_gender(line_values[5].strip());
                    winner.set_country_code(line_values[4].strip());
                    winner.set_sport_type(line_values[2].strip());
                    winner.set_competition_name(line_values[6].strip());
                    winner.set_medal(line_values[7].strip());
                }

                if(events.isEmpty()){
                    Event event = new Event();
                    std = new ArrayList<Winner>();
                    event.set_season("summer");
                    event.set_city(line_values[1].strip());
                    event.set_year(Integer.parseInt(line_values[0].strip()));
                    std.add(winner);
                    event.set_winners(std);
                    events.add(event);
                }

                if(events.getLast().get_year() != Integer.parseInt(line_values[0].strip()) && !events.getLast().get_city().equals(line_values[1].strip())){
                    Event event = new Event();
                    std = new ArrayList<Winner>();
                    event.set_season("summer");
                    event.set_city(line_values[1].strip());
                    event.set_year(Integer.parseInt(line_values[0].strip()));
                    std.add(winner);
                    event.set_winners(std);
                    events.add(event);
                }
                else{
                    std = events.getLast().get_winners();
                    std.add(winner);
                    events.getLast().set_winners(std);
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e){
            System.out.println("Произошла ошибка считывания на строке 40: " + e.toString());
            System.exit(228);
        }


//        задача_1
//        Scanner console_in = new Scanner(System.in);
//        System.out.println("Введите год олимпиады: ");
//        String year = console_in.nextLine();
//        Tasks.task_1(events, year);



//        задача_2
//        Scanner console_in = new Scanner(System.in);
//        System.out.println("Введите вид спорта на английском: ");
//        String sport_type = console_in.nextLine();
//        Tasks.task_2(events, sport_type);


//        задача 3
//        Tasks.task_3(events);


//        задача 4
//        Scanner console_in = new Scanner(System.in);
//        System.out.println("Введите название соревнования на английском: ");
//        String competition_type = console_in.nextLine();
//        Tasks.task_4(events, competition_type);
    }
}