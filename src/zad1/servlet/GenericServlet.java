package zad1.servlet;

import zad1.model.Book;

import javax.servlet.http.HttpServlet;

public class GenericServlet extends HttpServlet {
    static String header = "<!DOCTYPE html><html>"+
            "<head><meta charset=\"UTF-8\" /><title>BookDB</title></head>" +
            "<body>" ;
    static String footer = "</body></html>";
    String formatBook(Book b){
        return "<h3>" + b.getTitle() + "</h3>" +
                "<p>Author: " + b.getAuthor() + "</p>" +
                "<p>Year: " + b.getYear() + "</p>";
    }
}
