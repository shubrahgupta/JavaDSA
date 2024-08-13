package DSA.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
         q = new LinkedList<>();

    }

    public int ping(int t) {
        q.add(t);
        int lower = Math.max(t - 3000, 0);
        while(!q.isEmpty()) {
            int element = q.poll();
            if (element >= lower && element <= t) {
                q.add(element);
                break;
            }


        }
        return q.size();
    }

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        int[] time = {1,100,3001,3002};
        int[] arr = new int[time.length];
        for(int i = 0; i < time.length; i++) {
            int param_1 = obj.ping(time[i]);
            arr[i] = param_1;
        }
        System.out.println(Arrays.toString(arr));

    }
}
