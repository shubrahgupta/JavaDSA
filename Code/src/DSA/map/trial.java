package DSA.map;

import java.util.*;

public class trial {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        for(Map.Entry<String, Integer> me: map.entrySet()) {
            System.out.println(me.getKey() + " " + me.getValue());
        }

        System.out.println(map.values());
    }
}
