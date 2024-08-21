package MachineCoding.InMemorySQLDB;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;

public class QueryEngine {
    private Database database;
    QueryEngine(Database database) {
        this.database = database;
    }
    public void executeInsertQuery(String tableName, HashMap<String, Object> record) throws Exception {
        if (this.database.getTables().containsKey(tableName)) {
            this.database.getTables().get(tableName).insert(record);
        }
    }
    public ArrayList<HashMap<String, Object>> executeSelectQuery(String tableName, String column, Object value) {
        if (this.database.getTables().containsKey(tableName)) {
            return this.database.getTables().get(tableName).select(column, value);
        }
        return new ArrayList<HashMap<String, Object>>();
    }
    public void executeUpdateQuery(String tableName, String column, Object oldValue, HashMap<String, Object> newValue) {
        if (this.database.getTables().containsKey(tableName)) {
            this.database.getTables().get(tableName).update(column, oldValue, newValue);
        }
    }
    public void executeDeleteQuery(String tableName, String column, Object value) {
        if (this.database.getTables().containsKey(tableName)) {
            this.database.getTables().get(tableName).delete(column, value);
        }
    }


}
