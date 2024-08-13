package DSA.treeGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class hasCycle {
    static int n;
    int e;
    ArrayList<int[]> pairs;
    public void readFile(String filePath) {

        // Read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String firstLine = br.readLine();
            String[] firstLineParts = firstLine.split(" ");
            n = Integer.parseInt(firstLineParts[0]);
            e = Integer.parseInt(firstLineParts[1]);

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
            System.out.println("n: " + n + ", e: " + e);
            System.out.println("Pairs:");
            for (int[] pair : pairs) {
                System.out.println(pair[0] + " " + pair[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> visited;
    public void make_graph() {
        graph = new ArrayList<>(n+1);
        visited = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            visited.add(i, 0);
        }
        for(int[] pair: pairs) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

    }
    boolean flag;
    public boolean isCycle(int V) {
        make_graph();
        flag = false;
        for(int i = 0; i < V; i++) {
            dfs(i,0);
        }
        return flag;
    }
    public void dfs(int vertex, int parent){
        visited.set(vertex,1);

        for(int child: graph.get(vertex)) {
            System.out.println("parent " + vertex + " child " + child);
            if (visited.get(child) == 1 && (child == parent)) continue;
            else if (visited.get(child) == 1 && (child != parent)) {flag = true; return;}
            System.out.println(child);
            dfs(child, vertex);
        }
    }


    public static void main(String[] args) {
        hasCycle q = new hasCycle();
        q.readFile("input.txt");
        System.out.println("Ans: " + q.isCycle(n));
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//
//        adj.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
//        adj.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
//        adj.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
//        System.out.println(numProvinces(adj,3));
    }
}
