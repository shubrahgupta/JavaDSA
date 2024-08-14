package DSA.treeGraphs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class LCA {
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
    static int[] par;
    public void dfs(int vertex, int parent) {
        par[vertex] = parent;
        for(int child: graph.get(vertex)) {
            if (child == parent) continue;
            dfs(child, vertex);
        }
    }

    public ArrayList<Integer> PathRootToNode(int node) {
        ArrayList<Integer> path = new ArrayList<>();
        while(par[node] != 0) {
            path.add(node);
            node = par[node];
        }
        Collections.reverse(path);
        return path;
    }
    public int getLCA(ArrayList<Integer> path1, ArrayList<Integer> path2) {
        int ans = 0;
        for(int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i).equals(path2.get(i))) {
                ans = path1.get(i);
            }
            else {
                break;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        LCA dfst = new LCA();
        dfst.readFile("Code\\dfstree.txt");
        dfst.make_graph();
        par = new int[n+1];
//        dfst.calculate_height_depth();
        int vertex = 1, parent = 0, node1 = 6, node2 = 12;
        dfst.dfs(vertex, parent);
        ArrayList<Integer> path1 = dfst.PathRootToNode(node1);
        ArrayList<Integer> path2 = dfst.PathRootToNode(node2);
        int ans = dfst.getLCA(path1, path2);
        System.out.println(ans);




    }
}
