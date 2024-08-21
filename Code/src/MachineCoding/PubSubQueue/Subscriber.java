package MachineCoding.PubSubQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subscriber {
    private int subscriberId;
    private String name;
    private List<String> inbox;
    private ArrayList<Topic> topics;


    public Subscriber(int subscriberId, String name) {
        this.subscriberId = subscriberId;
        this.name = name;
        this.inbox = new ArrayList<>();
        this.topics = new ArrayList<>();
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }
    public void addSubscriptionToTopic(Topic topic) {
        topics.add(topic);
        topic.addSubscriber(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void subscriberReceipt(String message) {
        this.inbox.add(message);
        System.out.println("Subscriber " + getName() + " receives: " + message);

    }
}
