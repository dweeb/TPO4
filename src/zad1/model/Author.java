package zad1.model;

public class Author {
    private int idAuthor;
    private String name;
    public Author(int idAuthor, String name){
        this.idAuthor = idAuthor;
        this.name = name;
    }
    public int getIdAuthor(){return idAuthor;}
    public String getName(){return name;}
}
