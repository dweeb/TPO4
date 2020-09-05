package zad1.servlet;

import zad1.dbController.Config;
import zad1.model.Book;

import java.util.List;

public class SearchByTitleServlet extends SearchServlet{
    public SearchByTitleServlet(){
        super();
        this.title = "<h2>Search by title</h2>";
    }
    List<Book> search(String search) throws Exception {
        return Config.getService().getBooksByTitle(search);
    }
}
