package MachineCoding.PubSubQueue;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private int publisherId;
    private String publisherName;
    private List<String> alerts;
    private boolean hasPosted = false;
    private List<Topic> topics;

    public Publisher(int publisherId, String publisherName, List<Topic> topics) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        alerts= new ArrayList<>();
        this.topics = topics;

    }
    public Publisher(int publisherId, String publisherName, Topic topic) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        alerts= new ArrayList<>();
        addTopic(topic);

    }
    public void addTopic(Topic topic) {
        topics.add(topic);
    }
    public void removeTopic(Topic topic) {
        topics.remove(topic);
    }


    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    public void publisherBroadcast(String message, Topic topic) {
        System.out.println("Publisher " + getPublisherName() + " broadcasts: " + message);
        alerts.add(message);
        this.hasPosted = true;
        topic.setIsActive(this.hasPosted, message);
    }

}
