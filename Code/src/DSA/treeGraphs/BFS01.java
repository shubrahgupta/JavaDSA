package DSA.treeGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class BFS01 {
    static int n, m;
    ArrayList<int[]> pairs;
    public void readFile(String filePath) {

        // Read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String firstLine = br.readLine();
            String[] firstLineParts = firstLine.split(" ");
            n = Integer.parseInt(firstLineParts[0]);
            m = Integer.parseInt(firstLineParts[1]);

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
    ArrayList<ArrayList<ArrayList<Integer>>> graph;
    ArrayList<Integer> level;
    //    static ArrayList<Integer> visited;
    public void make_graph() {
        level = new ArrayList<>();
        graph = new ArrayList<>(n+1);
//        visited = new ArrayList<>(n);
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
            level.add(Integer.MAX_VALUE);
//            visited.add(i, 0);
        }
        for(int[] pair: pairs) {
            graph.get(pair[0]).add(new ArrayList<>(Arrays.asList(pair[1], 0)));
            graph.get(pair[1]).add(new ArrayList<>(Arrays.asList(pair[0], 1)));
        }
//        System.out.println(graph);

    }



    public int bfs() {


        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        level.set(1, 0);
        while(!dq.isEmpty()) {
            int src = dq.pollFirst();
            System.out.println(src);
            for(ArrayList<Integer> child: graph.get(src)) {
                System.out.println(child);
                int childVal = child.get(0);
                int wt = child.get(1);
                if (level.get(src) + wt < level.get(childVal)) {
                    level.set(childVal, level.get(src) + wt);
                }
                else{
                    continue;
                }
                if (wt == 0) {
                    dq.addFirst(childVal);
                }
                else {
                    dq.addLast(childVal);
                }

            }
        }
        return level.get(n);

    }






    public static void main(String[] args) {
        BFS01 dfst = new BFS01();
        dfst.readFile("Code\\bfs01.txt");
        dfst.make_graph();
        System.out.println(dfst.bfs());





    }
}
