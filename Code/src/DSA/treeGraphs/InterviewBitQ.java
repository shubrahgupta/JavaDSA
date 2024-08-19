package DSA.treeGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class InterviewBitQ {
    static ArrayList<ArrayList<Integer>> graph, pairs;
    static ArrayList<Integer> val;
    static int M = (int) (Math.pow(10,9) + 7);

    static int n;
    //    static ArrayList<Integer> visited;
    public void readFile(String filePath) {

        // Read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String firstLine = br.readLine();
            String[] firstLineParts = firstLine.split(" ");
            n = Integer.parseInt(firstLineParts[0]);

            // List to store pairs of integers
            ArrayList<ArrayList<Integer>> pair = new ArrayList<>();
            val = new ArrayList<>();

            for(int i = 1; i <= n; i++) {
                String secondLine = br.readLine();
                val.add(Integer.parseInt(secondLine));
            }
            // Read the remaining lines
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                pair.add(new ArrayList<>(Arrays.asList(a,b)));
            }
            pairs = pair;

            //Output the read values
//            System.out.println("n: " + n);
//            System.out.println("Pairs:");
//            for (int[] pair : pairs) {
//                System.out.println(pair[0] + " " + pair[1]);
//            }
//            System.out.println("Values:");
//            for (int i = 0; i < val.length; i++) {
//                System.out.println(i + " " + val[i]);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void make_graph(int N, ArrayList<ArrayList<Integer>> pairs) {
        n = N;
        graph = new ArrayList<>(N+1);
//        visited = new ArrayList<>(n);
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
//            visited.add(i, 0);
        }
        for(ArrayList<Integer> pair: pairs) {
            graph.get(pair.get(0)).add(pair.get(1));
            graph.get(pair.get(1)).add(pair.get(0));
        }

    }
    int[] subtreeSum;
    public void precompute() {
        subtreeSum = new int[n+1];
        dfs(1, 0);
        // System.out.println(Arrays.toString(subtreeSum));
    }
    public void dfs(int vertex, int parent) {
        int sum = val.get(vertex-1) % M;
        for(int child: graph.get(vertex)) {

            if (child == parent)    continue;
            dfs(child, vertex);
            sum += (subtreeSum[child] % M);
        }
        subtreeSum[vertex] = sum % M;

    }
    static int maxProduct = Integer.MIN_VALUE;
    public int deleteEdge(ArrayList<Integer> values, ArrayList<ArrayList<Integer>> pair) {
        int N = values.size();
        make_graph(N, pair);
        val = values;
        precompute();
        for(ArrayList<Integer> p: pair) {
            int i = p.get(0), j = p.get(1);
            int one_comp = Math.min(subtreeSum[i], subtreeSum[j]) % M;
            int product =  (one_comp * ((subtreeSum[1] - one_comp) % M))% M;
            maxProduct = Math.max(product, maxProduct);
        }
        return maxProduct % M;
    }
    public static void main(String[] args) {
        InterviewBitQ dfst = new InterviewBitQ();
        dfst.readFile("Code\\edgeDelTree.txt");
        System.out.println(dfst.deleteEdge(val, pairs));
    }
}
