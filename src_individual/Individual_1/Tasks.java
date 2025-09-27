package individual_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Tasks {

    private static Boolean correct_int(String input) {
        if (input.matches("^\\d+")) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static void task_1(ArrayList<Event> events, String year){
        int count_countries = 0;
        ArrayList<String> countries;
        ArrayList<Winner> gold;
        ArrayList<Winner> silver;
        ArrayList<Winner> bronze;
        Boolean f = Boolean.TRUE;

        if(!correct_int(year)){
            System.out.println("Год введен с ошибкой");
            return;
        }

        for(Event event : events){
            if(event.get_year() == Integer.parseInt(year)){
                f = Boolean.FALSE;
                countries = new ArrayList<String>();
                gold = new ArrayList<Winner>();
                silver = new ArrayList<Winner>();
                bronze = new ArrayList<Winner>();
                count_countries = 0;
                System.out.println("Год олимпиады: " + event.get_year());
                System.out.println("Вид олипиады: " + event.get_season());
                for(Winner winner : event.get_winners()){
                    if(!countries.contains(winner.get_country_code())){
                        countries.add(winner.get_country_code());
                        count_countries++;
                    }

                    if(winner.get_medal().equals("Gold")){
                        gold.add(winner);
                    }
                    if(winner.get_medal().equals("Silver")){
                        silver.add(winner);
                    }
                    if(winner.get_medal().equals("Bronze")){
                        bronze.add(winner);
                    }
                }
                System.out.println("Количество стран участниц: " + count_countries);
                System.out.println("Список стран участниц: ");
                System.out.println(countries.toString());
                System.out.println("Список золотых медалистов: ");
                for(Winner winner: gold){
                    System.out.println(winner.toString());
                    System.out.println();
                }
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Список серебрянных медалистов: ");
                for(Winner winner: silver){
                    System.out.println(winner.toString());
                    System.out.println();
                }
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Список бронзовых медалистов: ");
                for(Winner winner: bronze){
                    System.out.println(winner.toString());
                    System.out.println();
                }
            }
        }

        if(f){
            System.out.println("Олимпиады по этому году не найдены");
            return;
        }
    }

    public static void task_2(ArrayList<Event> events, String sport_type){
        HashMap<Integer, ArrayList<String>> result_by_years = new LinkedHashMap<>();
        ArrayList<String> std;
        ArrayList<String> competitions = new ArrayList<String>();
        boolean find = false;
        boolean noted = true;

        for(Event event : events){
            noted = true;
            for(Winner winner : event.get_winners()){
                if(winner.get_sport_type().equals(sport_type)){
                    find = true;
                    noted = false;
                    if(competitions.isEmpty()){
                        competitions.add(winner.get_competition_name());
                    }
                    if(!competitions.contains(winner.get_competition_name())){
                        competitions.add(winner.get_competition_name());
                    }
                    if(!result_by_years.containsKey(event.get_year())){
                        std = new ArrayList<>();
                        std.add(winner.get_competition_name());
                        result_by_years.put(event.get_year(), std);
                    }
                    else{
                        std = result_by_years.get(event.get_year());
                        if(!std.contains(winner.get_competition_name())){
                            std.add(winner.get_competition_name());
                            result_by_years.put(event.get_year(), std);
                        }
                    }
                }
            }
            if(!noted){
                System.out.println("Год проведения: " + event.get_year());
                System.out.println("Город проведения: " + event.get_city());
                System.out.println();
            }
        }

        if(!find){
            System.out.println("Указанного вида спорта не было на олимпийских играх");
            return;
        }

        System.out.println("Общий список соревнований: ");
        System.out.println(competitions.toString());
        System.out.println();
        System.out.println("Результат по годам");
        for(Integer year : result_by_years.keySet()){
            System.out.println("Год: " + year);
            System.out.println("Соревнования: " + result_by_years.get(year).toString());
            System.out.println();
        }
    }

    public static void task_3(ArrayList<Event> events){
        HashMap<Integer, ArrayList<HashMap<String, Object>>> result = new LinkedHashMap<>();
        ArrayList<Event> events_buffer = new ArrayList<Event>();
        ArrayList<HashMap<String, Object>> std = new ArrayList<>();
        HashMap<String, Object> person_data_for_result = new LinkedHashMap<>();
        ArrayList<String> medals_of_winer = new ArrayList<>();
        ArrayList<String> competitions_of_winer = new ArrayList<>();
        ArrayList<Integer> years_of_winer = new ArrayList<>();
        int count_win = 0;
        boolean noted = false;

        events_buffer = events;
        for(Event event_out : events){
            for(Winner winner_main : event_out.get_winners()){

                noted = false;
                for(int key : result.keySet()){
                    for(HashMap<String, Object> person : result.get(key)){
                        if(winner_main.get_name().equals(person.get("name")) && winner_main.get_second_name().equals(person.get("second_name"))){
                            noted = true;
                        }
                    }
                }

                if(!noted){
                    medals_of_winer = new ArrayList<>();
                    competitions_of_winer = new ArrayList<>();
                    years_of_winer = new ArrayList<>();
                    count_win = 0;
                    for(Event event : events_buffer){
                        for(Winner winner : event.get_winners()){

                            if(winner.get_name().equals(winner_main.get_name()) && winner.get_second_name().equals(winner_main.get_second_name())){
                                count_win += 1;
                                years_of_winer.add(event.get_year());
                                competitions_of_winer.add(winner.get_competition_name());
                                medals_of_winer.add(winner.get_medal());
                            }

                        }
                    }

                    if(count_win > 1){
                        person_data_for_result = new HashMap<>();
                        person_data_for_result.put("name", winner_main.get_name());
                        person_data_for_result.put("second_name", winner_main.get_second_name());
                        person_data_for_result.put("years_of_win", years_of_winer);
                        person_data_for_result.put("competitions", competitions_of_winer);
                        person_data_for_result.put("medals", medals_of_winer);
                        if(result.containsKey(count_win)){
                            std = result.get(count_win);
                            std.add(person_data_for_result);
                            result.put(count_win, std);
                        }
                        else{
                            std = new ArrayList<>();
                            std.add(person_data_for_result);
                            result.put(count_win, std);
                        }
                    }
                }
            }
        }


        for(int win_number : result.keySet()){
            System.out.println("Список спортсменов с числом побед: " + win_number);
            for(HashMap<String, Object> person : result.get(win_number)){
                System.out.println("Имя спортсмена: " + person.get("name"));
                System.out.println("Список соревнований спортсмена: " + person.get("competitions"));
                System.out.println("Годы проведения соревнований: " + person.get("years_of_win"));
                System.out.println("Полученные спортсменом медали: " + person.get("medals"));
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void task_4(ArrayList<Event> events, String competition_name){
        int sport_year_begin = 0;
        int sport_year_end = 0;
        int comp_year_begin = 0;
        int comp_year_end = 0;
        String sport_name = "";
        boolean find_begin = false;
        boolean f = false;

        for(Event event : events){
            for(Winner winner : event.get_winners()){
                if(winner.get_competition_name().equals(competition_name)){
                    sport_name = winner.get_sport_type();
                    if(!f){
                        comp_year_begin = event.get_year();
                        comp_year_end = event.get_year();
                    }
                    if(event.get_year() > comp_year_end){
                        comp_year_end = event.get_year();
                    }
                    f = true;
                }
            }
        }

        if(f){
            for(Event event : events){
                for(Winner winner : event.get_winners()){
                    if(winner.get_sport_type().equals(sport_name)){
                        if(!find_begin){
                            find_begin = true;
                            sport_year_end = event.get_year();
                            sport_year_begin = event.get_year();
                        }
                        if(event.get_year() > sport_year_end){
                            sport_year_end = event.get_year();
                        }
                    }
                }
            }
            //Я не понял условия, там написано "определите, когда он присутстсвовал на олимпийских играх", но соревнование - это оно
            //При этом на 1 предложение выше написано "...укажите вид спорта, к которому он относится", хотя опять же соревнование - это оно
            //Очевидно, что нужено найти вид спорта, к которому относится соревнование, а вот для чего нужно выводить временные рамки не очевидно.
            //Я вывел для всего.
            System.out.println("Совервнование относится к виду спорта: " + sport_name);
            System.out.println("Вид спорта " + sport_name + " присутствовал на олимпийских играх с " + sport_year_begin + " до " + sport_year_end);
            System.out.println("Соревнование " + competition_name + " присутствовал на олимпийских играх с " + comp_year_begin + " до " + comp_year_end);
        }
        else{
            System.out.println("Вида спорта с таким соревнованием не найдено");
        }
    }
}
