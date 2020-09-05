package zad1.servlet;

import zad1.dbController.Config;
import zad1.model.Book;

import java.util.List;

public class SearchByYearServlet extends SearchServlet{
    public SearchByYearServlet(){
        super();
        this.title = "<h2>Search by year published</h2>";
    }
    List<Book> search(String search) throws Exception {
        int year = Integer.parseInt(search);
        return Config.getService().getBooksByYear(year);
    }
}
