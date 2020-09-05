package zad1.servlet;

import zad1.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SearchServlet extends GenericServlet{
    String title;
    public SearchServlet(){
        super();
        this.title = "<h2>Search</h2>";
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String returnUrl = request.getRequestURL().toString().split("search")[0];
        writer.println(header);
        writer.println(title);
        writer.println("<p><a href=\"" + returnUrl + "\">Back to home</a></p>");
        writer.println("<form action=\"\" style=\"max-width:300px\">\n" +
                "  <input type=\"text\" placeholder=\"Search...\" name=\"search\">\n" +
                "  <button type=\"submit\">Search</button>\n" +
                "</form>");
        String searchPhrase = request.getParameter("search");
        if(searchPhrase != null){
            try {
                writer.println("<p/>");
                List<Book> bookList = search(searchPhrase);
                for(Book b : bookList){
                    writer.println(formatBook(b));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        writer.println(footer);
    }
    List<Book> search(String search) throws Exception {
        return null;
    }
}
