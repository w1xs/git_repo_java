package laba_4;

public class Book {
    private String name;
    private String author;

    public Book(){};

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public Book(Book other_book){
        this.name = other_book.name;
        this.author = other_book.author;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_author() {
        return author;
    }

    public void set_author(String author) {
        this.author = author;
    }
}
