package MachineCoding.InMemorySQLDB;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a database
            Database database = new Database();

            // Create a table
            ArrayList<String> columns = new ArrayList<>(Arrays.asList("id", "name", "age"));
            database.createTable("Person", "id", columns);

            // Insert records
            HashMap<String, Object> record1 = new HashMap<>();
            record1.put("id", 1);
            record1.put("name", "Alice");
            record1.put("age", 25);

            HashMap<String, Object> record2 = new HashMap<>();
            record2.put("id", 2);
            record2.put("name", "Bob");
            record2.put("age", 30);

            QueryEngine queryEngine = new QueryEngine(database);
            queryEngine.executeInsertQuery("Person", record1);
            queryEngine.executeInsertQuery("Person", record2);

            // Select records
            ArrayList<HashMap<String, Object>> results = queryEngine.executeSelectQuery("Person", "name", "Alice");
            System.out.println("Select result: " + results);

            // Update records
            HashMap<String, Object> updatedRecord = new HashMap<>();
            updatedRecord.put("age", 26);
            queryEngine.executeUpdateQuery("Person", "name", "Alice", updatedRecord);

            // Select again to verify update
            results = queryEngine.executeSelectQuery("Person", "name", "Alice");
            System.out.println("Select after update: " + results);

            // Delete a record
            queryEngine.executeDeleteQuery("Person", "name", "Bob");

            // Select again to verify delete
            results = queryEngine.executeSelectQuery("Person", "name", "Bob");
            System.out.println("Select after delete: " + results);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
