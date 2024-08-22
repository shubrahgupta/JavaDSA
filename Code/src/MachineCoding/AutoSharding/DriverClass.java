package MachineCoding.AutoSharding;

public class DriverClass {
    public static void main(String[] args) {

        int numberOfShards = 3;
        ShardManager shardManager = new ShardManager(numberOfShards);

        shardManager.insert("user1", "Alice");
        shardManager.insert("user2", "Bob");
        shardManager.insert("user3", "Charlie");

        System.out.println("user1: " + shardManager.retrieve("user1"));
        System.out.println("user2: " + shardManager.retrieve("user2"));
        System.out.println("user3: " + shardManager.retrieve("user3"));
    }

}
