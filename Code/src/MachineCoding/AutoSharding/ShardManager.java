package MachineCoding.AutoSharding;

import java.util.ArrayList;
import java.util.List;

public class ShardManager {
    private List<Shard> shards;
    private int numberOfShards;

    public ShardManager(int numberOfShards) {
        this.numberOfShards = numberOfShards;
        shards = new ArrayList<>();
        for(int i = 0; i < numberOfShards; i++) {
            shards.add(new Shard(i));
        }
    }
    public int getShardIndex(String key) {
        int hashValue = key.hashCode();
        return Math.abs(hashValue) % numberOfShards;
    }
    public void insert(String key, String value){
        Shard currentShard = shards.get(getShardIndex(key));
        currentShard.insertData(key, value);

    }
    public String retrieve(String key) {
        Shard currentShard = shards.get(getShardIndex(key));
        return currentShard.getData(key);
    }

}
