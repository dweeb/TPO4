package zad1.dbController;

import zad1.model.Author;
import zad1.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlService {
    public List<Book> getAllBooks() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bookdb?user=app&password=d0lphin&serverTimezone=CET");
        Statement stat = con.createStatement();
        ResultSet res = stat.executeQuery("select b.idBook, a.name, b.title, b.year from book b " +
                                            "join author a on b.idAuthor = a.idAuthor;");
        List<Book> resultList = new ArrayList<>();
        while (res.next()){
            resultList.add(new Book(
                    res.getInt("idBook"),
                    res.getString("name"),
                    res.getString("title"),
                    res.getInt("year")
                    ));
        }
        return resultList;
    }
    public Author getAuthorById(int id) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bookdb?user=app&password=d0lphin&serverTimezone=CET");
        PreparedStatement stat = con.prepareStatement("select * from bookdb.author where idAuthor = ?;");
        stat.setInt(1, id);
        ResultSet res = stat.executeQuery();
        res.next();
        return new Author(
                res.getInt("idAuthor"),
                res.getString("name")
        );
    }
    public List<Author> getAuthorsByName(String search) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bookdb?user=app&password=d0lphin&serverTimezone=CET");
        PreparedStatement stat = con.prepareStatement("select * from bookdb.author where name = ?;");
        stat.setString(1, "%" + search + "%");
        ResultSet res = stat.executeQuery();
        List<Author> resultList = new ArrayList<>();
        while(res.next()) {
            resultList.add(new Author(
                    res.getInt("idAuthor"),
                    res.getString("name")
            ));
        }
        return resultList;
    }
    public List<Book> getBooksByAuthorId(int id) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bookdb?user=app&password=d0lphin&serverTimezone=CET");
        PreparedStatement stat = con.prepareStatement("select b.idBook, a.name, b.title, b.year from book b " +
                                                        "join author a on b.idAuthor = a.idAuthor " +
                                                        "where a.idAuthor = ?;");
        stat.setInt(1, id);
        ResultSet res = stat.executeQuery();
        List<Book> resultList = new ArrayList<>();
        while (res.next()){
            resultList.add(new Book(
                    res.getInt("idBook"),
                    res.getString("name"),
                    res.getString("title"),
                    res.getInt("year")
            ));
        }
        return resultList;
    }
    public List<Book> getBooksByAuthorName(String name) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bookdb?user=app&password=d0lphin&serverTimezone=CET");
        PreparedStatement stat = con.prepareStatement("select b.idBook, a.name, b.title, b.year from book b " +
                                                        "join author a on b.idAuthor = a.idAuthor " +
                                                        "where a.name like ?;");
        stat.setString(1, "%" + name + "%");
        ResultSet res = stat.executeQuery();
        List<Book> resultList = new ArrayList<>();
        while (res.next()){
            resultList.add(new Book(
                    res.getInt("idBook"),
                    res.getString("name"),
                    res.getString("title"),
                    res.getInt("year")
            ));
        }
        return resultList;
    }
    public List<Book> getBooksByYear(int year) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bookdb?user=app&password=d0lphin&serverTimezone=CET");
        PreparedStatement stat = con.prepareStatement("select b.idBook, a.name, b.title, b.year from book b " +
                                                        "join author a on b.idAuthor = a.idAuthor " +
                                                        "where b.year = ?;");
        stat.setInt(1, year);
        ResultSet res = stat.executeQuery();
        List<Book> resultList = new ArrayList<>();
        while (res.next()){
            resultList.add(new Book(
                    res.getInt("idBook"),
                    res.getString("name"),
                    res.getString("title"),
                    res.getInt("year")
            ));
        }
        return resultList;
    }
    public List<Book> getBooksByTitle(String search) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bookdb?user=app&password=d0lphin&serverTimezone=CET");
        PreparedStatement stat = con.prepareStatement("select b.idBook, a.name, b.title, b.year from book b " +
                                                        "join author a on b.idAuthor = a.idAuthor " +
                                                        "where b.title like ?;");
        stat.setString(1, "%" + search + "%");
        ResultSet res = stat.executeQuery();
        List<Book> resultList = new ArrayList<>();
        while (res.next()){
            resultList.add(new Book(
                    res.getInt("idBook"),
                    res.getString("name"),
                    res.getString("title"),
                    res.getInt("year")
            ));
        }
        return resultList;
    }
}
