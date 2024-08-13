package contests;

import java.util.*;

public class p1 {
    public int winningPlayerCount(int n, int[][] pick) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>(Collections.nCopies(11, 0)));

        }
        System.out.println(map);

        for(int[] x: pick) {
//            System.out.println(Arrays.toString(x));
            int val = map.get(x[0]).get(x[1]);
            map.get(x[0]).set(x[1],val+1);
        }
        int winners = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> it : map.entrySet()) {
            int max = Integer.MIN_VALUE;
            ArrayList<Integer> arr = it.getValue();
            for(int i: arr) {
                max = Math.max(max,i);
            }
            if (max > it.getKey()){
                winners++;
            }
        }
        System.out.println(map);
        return winners;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] array = {
                {1, 8}, {0, 6}, {1, 5}, {0, 5}, {1, 6},
                {0, 7}, {1, 1}, {0, 6}, {0, 2}, {1, 7}
        };
        p1 p1 = new p1();
        System.out.println(p1.winningPlayerCount(n, array));
    }

}
