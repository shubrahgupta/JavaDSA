package MachineCoding.PubSubQueue;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private List<Publisher> publishers;
    private List<Subscriber> subscribers;
    private List<String> messages;
    private boolean isActive = false;

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive, String message) {
        this.isActive = isActive;
        alertTransmission(this.isActive, message);
    }

    public Topic(List<Publisher> publishers, List<Subscriber> subscribers) {
        this.publishers = publishers;
        this.subscribers = subscribers;
        this.messages = new ArrayList<>();
    }
    public Topic() {
        this.publishers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }
    public void removeSubscriber(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    public void alertTransmission(boolean isActive, String message) {
        if (isActive) {
            for(Subscriber subscriber: subscribers) {
                subscriber.subscriberReceipt(message);
            }
        }

    }

}
