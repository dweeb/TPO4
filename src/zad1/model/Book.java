package zad1.model;

public class Book {
    private int idBook;
    private String author;
    private String title;
    private int year;
    public Book(int idBook, String author, String title, int year){
        this.idBook = idBook;
        this.author = author;
        this.title = title;
        this.year = year;
    }
    public int getIdBook(){return idBook;}
    public String getAuthor(){return author;}
    public String getTitle(){return title;}
    public int getYear(){return year;}
}
