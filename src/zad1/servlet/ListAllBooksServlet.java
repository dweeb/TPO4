package zad1.servlet;

import zad1.dbController.Config;
import zad1.model.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListAllBooksServlet extends GenericServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String returnUrl = request.getRequestURL().toString().split("books")[0];
        writer.println(header);
        writer.println("<h2>List of all books</h2>");
        writer.println("<p><a href=\"" + returnUrl + "\">Back to home</a></p>");
        try {
            writer.println("<p/>");
            List<Book> bookList = Config.getService().getAllBooks();
            for(Book b : bookList){
                writer.println(formatBook(b));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.println(footer);
    }
}
