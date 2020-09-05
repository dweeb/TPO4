package zad1.dbController;

public class Config {
    private static MySqlService service = new MySqlService();
    public static MySqlService getService() {
        return service;
    }
}
