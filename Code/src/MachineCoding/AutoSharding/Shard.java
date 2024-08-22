package MachineCoding.AutoSharding;

import java.util.HashMap;
import java.util.Map;

public class Shard {
    private int shardId;
    private Map<String, String> data;


    public Shard(int shardId) {
        this.shardId = shardId;
        this.data = new HashMap<>();
    }

    public int getShardId() {
        return this.shardId;
    }
    public String getData(String key) {
        return data.get(key);
    }
    public void insertData(String key, String value) {
        this.data.put(key, value);
    }

}
