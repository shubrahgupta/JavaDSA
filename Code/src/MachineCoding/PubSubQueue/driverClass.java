package MachineCoding.PubSubQueue;

import java.util.ArrayList;
import java.util.Arrays;
public class driverClass {
    public static void main(String[] args) {
        Topic topic1 = new Topic();
        Topic topic2 = new Topic();

        Publisher producer1 = new Publisher(1,"producer1", new ArrayList<>(Arrays.asList(topic1, topic2)));
        Publisher producer2 = new Publisher(2,"producer2", new ArrayList<>(Arrays.asList(topic1, topic2)));
        Subscriber consumer1 = new Subscriber(1, "consumer1");
        Subscriber consumer2 = new Subscriber(2, "consumer2");
        Subscriber consumer3 = new Subscriber(3, "consumer3");
        Subscriber consumer4 = new Subscriber(4, "consumer4");
        Subscriber consumer5 = new Subscriber(5, "consumer5");
        consumer1.addSubscriptionToTopic(topic1);
        consumer2.addSubscriptionToTopic(topic1);
        consumer3.addSubscriptionToTopic(topic1);
        consumer4.addSubscriptionToTopic(topic1);
        consumer5.addSubscriptionToTopic(topic1);

        consumer1.addSubscriptionToTopic(topic2);
        consumer4.addSubscriptionToTopic(topic2);
        consumer3.addSubscriptionToTopic(topic2);

        producer1.publisherBroadcast("Message 1", topic1);
        producer1.publisherBroadcast("Message 2", topic1);
        producer2.publisherBroadcast("Message 3", topic1);
        producer1.publisherBroadcast("Message 4", topic2);
        producer2.publisherBroadcast("Message 5", topic2);





    }


}
