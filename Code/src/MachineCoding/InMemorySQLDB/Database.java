package MachineCoding.InMemorySQLDB;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private HashMap<String, Table> tables;

    public Database() {
        tables = new HashMap<>();
    }
    public void createTable(String name, String primaryKey, ArrayList<String> columns) {
        Table t = new Table(name, primaryKey, columns);
        this.tables.put(name, t);
    }
    public void dropTable(String name) throws Exception {
        if (tables.containsKey(name)) {
            this.tables.remove(name);
        }
        else {
            throw new Exception("No such table present");
        }
    }

    public HashMap<String, Table> getTables() {
        return tables;
    }
}
