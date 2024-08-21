package MachineCoding.InMemorySQLDB;

import java.util.*;

public class Table {
    private String name, primaryKey;
    private ArrayList<String> columns;
    private HashMap<String, Integer> columnIdx;
    private ArrayList<HashMap<String, Object>> records;

    public Table(String name, String primaryKey, ArrayList<String> columns) {
        this.name = name;
        this.primaryKey = primaryKey;
        this.columns = columns;
        columnIdx = new HashMap<>();
        for(int i = 0; i < columns.size(); i++) {
            this.columnIdx.put(columns.get(i), i);
        }
        this.records = new ArrayList<>();
    }
    public void insert(HashMap<String, Object> record) throws Exception {
        if (record.containsKey(primaryKey)) {
            for(HashMap<String, Object> olderRecord: records) {
                if (record.get(primaryKey) == olderRecord.get(primaryKey)) {
                    throw new Exception("Primary Key Duplication");
                }
            }
            records.add(record);

        }
        else {
            throw new Exception("No primary key present in the record");
        }
    }

    public ArrayList<HashMap<String, Object>> select(String column, Object value) {
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        for(HashMap<String, Object> record: records) {
            if (record.get(column) == value) {
                result.add(record);
            }
        }
        return result;
    }
    public void update(String column, Object oldValue, HashMap<String, Object> newValue) {
        for(HashMap<String, Object> record: records) {
            if (record.get(column) == oldValue) {
                record.putAll(newValue);

            }
        }

    }
    public void delete(String column, Object value) {
        records.removeIf(record -> record.get(column) == value);
    }

    public String getName() {
        return name;
    }
}

