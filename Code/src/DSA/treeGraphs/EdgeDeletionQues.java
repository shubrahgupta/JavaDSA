package DSA.treeGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EdgeDeletionQues {
    static int n;
    ArrayList<int[]> pairs;
    int[] val;
    public void readFile(String filePath) {

        // Read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String firstLine = br.readLine();
            String[] firstLineParts = firstLine.split(" ");
            n = Integer.parseInt(firstLineParts[0]);

            // List to store pairs of integers
            pairs = new ArrayList<int[]>();
            val = new int[n+1];

            for(int i = 1; i <= n; i++) {
                String secondLine = br.readLine();
                val[i] = Integer.parseInt(secondLine);
            }
            // Read the remaining lines
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                pairs.add(new int[]{a, b});
            }

             //Output the read values
            System.out.println("n: " + n);
            System.out.println("Pairs:");
            for (int[] pair : pairs) {
                System.out.println(pair[0] + " " + pair[1]);
            }
            System.out.println("Values:");
            for (int i = 0; i < val.length; i++) {
                System.out.println(i + " " + val[i]);
            }
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
    public static void main(String[] args) {
        EdgeDeletionQues dfst = new EdgeDeletionQues();
        dfst.readFile("Code\\edgeDelTree.txt");
        dfst.make_graph();
    }
}
