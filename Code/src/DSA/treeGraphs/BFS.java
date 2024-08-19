package DSA.treeGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BFS {
    static int n;
    ArrayList<int[]> pairs;
    public void readFile(String filePath) {

        // Read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String firstLine = br.readLine();
            String[] firstLineParts = firstLine.split(" ");
            n = Integer.parseInt(firstLineParts[0]);

            // List to store pairs of integers
            pairs = new ArrayList<int[]>();

            // Read the remaining lines
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                pairs.add(new int[]{a, b});
            }

            // Output the read values
//            System.out.println("n: " + n);
//            System.out.println("Pairs:");
//            for (int[] pair : pairs) {
//                System.out.println(pair[0] + " " + pair[1]);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    ArrayList<ArrayList<Integer>> graph;
    //    static ArrayList<Integer> visited;
    public void make_graph() {
        graph = new ArrayList<>(n+1);
//        visited = new ArrayList<>(n);
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
//            visited.add(i, 0);
        }
        for(int[] pair: pairs) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

    }
    int[] visited, level;


    public void bfs(int source) {
        Queue<Integer> q = new LinkedList<>();
        visited = new int[n+1];
        level = new int[n+1];
        q.add(source);
        visited[source] = 1;

        while (!q.isEmpty()) {
            for(int child: graph.get(q.peek())) {
                if (visited[child] == 1) continue;
                visited[child] = 1;
                q.add(child);
                level[child] = level[q.peek()] + 1;
                System.out.println(child + " " + level[child]);
            }
            q.poll();
        }
        System.out.println();

    }






    public static void main(String[] args) {
        BFS dfst = new BFS();
        dfst.readFile("Code\\dfstree.txt");
        dfst.make_graph();
        dfst.bfs(1);





    }
}
