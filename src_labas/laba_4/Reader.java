package laba_4;

public class Reader {
    private String name;
    private int day_of_return;
    private int month_of_return;
    private Book book_to_return;

    public Reader(){}

    public Reader(String name, int day_of_return, int month_of_return, Book book){
        this.name = name;
        this.day_of_return = day_of_return;
        this.month_of_return = month_of_return;
        this.book_to_return = book;
    }

    public Reader(Reader other_reader){
        this.name = other_reader.name;
        this.day_of_return = other_reader.day_of_return;
        this.month_of_return = other_reader.month_of_return;
        this.book_to_return = other_reader.book_to_return;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public int get_day_of_return() {
        return day_of_return;
    }

    public void set_day_of_return(int day_of_return) {
        this.day_of_return = day_of_return;
    }

    public int get_month_of_return() {
        return month_of_return;
    }

    public void set_month_of_return(int month_of_return) {
        this.month_of_return = month_of_return;
    }

    public Book get_book_to_return() {
        return book_to_return;
    }

    public void set_book_to_return(Book book_to_return) {
        this.book_to_return = book_to_return;
    }

    public Boolean made_it_on_time(int current_day, int current_month){
        if(current_month == month_of_return && current_day > day_of_return){
            return Boolean.FALSE;
        }
        if(current_month > month_of_return){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
