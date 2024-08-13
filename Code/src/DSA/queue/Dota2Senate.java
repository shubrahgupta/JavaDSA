package DSA.queue;

import java.util.*;

public class Dota2Senate {
    public static void main(String[] args) {
        Dota2Senate q = new Dota2Senate();
        String senate = "RD";
        System.out.println(q.predictPartyVictory(senate));
    }
    public String predictPartyVictory(String senate) {
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();
        for(int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') R.add(i);
            else D.add(i);
        }
        while(!D.isEmpty() && !R.isEmpty()) {
            if (D.peek() < R.peek()) {
                D.remove();
                R.remove();
                D.add(senate.length());
            }
            else if (D.peek() > R.peek()){
                R.remove();
                D.remove();
                R.add(senate.length());
            }
        }
        if (!D.isEmpty()) {
            return "Dire";
        }
        else {
             return "Radiant";
        }

    }
}
