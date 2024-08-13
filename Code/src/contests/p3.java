package contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p3 {
    ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> visited;
    static ArrayList<Integer> times;
    static int n;

    public int[] timeTaken(int[][] edges) {
        make_graph(edges);

        times = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (visited.get(i) != -1) continue;
            dfs(0, i);
            int ans = Integer.MIN_VALUE;
            for (Integer integer : visited) {
                ans = Math.max(ans, integer);
            }
            System.out.println("i : " + i + " ==> ans: " + ans);
            times.add(ans);
            visited = new ArrayList<>(Collections.nCopies(n, -1));
            System.out.println(visited);

        }
        int[] intArray = new int[times.size()];
        for (int j = 0;j < times.size(); j++) {
            intArray[j] = times.get(j);
        }
        return intArray;
    }
    public void make_graph(int[][] edges) {
        graph = new ArrayList<>(n);
        visited = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            visited.add(i, -1);
        }
        System.out.println(Arrays.toString(graph.toArray()));
        for(int[] pair: edges) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

    }
    public void dfs(int t, int vertex) {
        visited.set(vertex, t);
        System.out.println("vertex: " + vertex + "---> t: " + t);
        for(int child: graph.get(vertex)) {
            if (visited.get(child) != -1)   continue;
            if (child % 2 == 0) dfs(t+2, child);
            else dfs(t+1, child);

        }
    }

    public static void main(String[] args) {

        int[][] array = {
                {2, 4},
                {0, 1},
                {2, 3},
                {0, 2}
        };
        n = array.length+1;
        p3 p3 = new p3();
        int[] ans = p3.timeTaken(array);
        for(int j = 0; j < ans.length; j++) {
            System.out.print(ans[j] + " ");
        }


    }
}
