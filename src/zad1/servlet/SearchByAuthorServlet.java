package zad1.servlet;

import zad1.dbController.Config;
import zad1.model.Book;

import java.util.List;

public class SearchByAuthorServlet extends SearchServlet{
    public SearchByAuthorServlet(){
        super();
        this.title = "<h2>Search by author</h2>";
    }
    List<Book> search(String search) throws Exception {
        return Config.getService().getBooksByAuthorName(search);
    }
}
