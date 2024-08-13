package DSA.treeGraphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class dfsTrees {
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
    int[] height;
    int[] depth;
    static int[] subTreeSumArr;
    static int[] subTreeEvenCountArr;

    public void calculate_height_depth() {
        height = new int[n+1]; depth = new int[n+1];
        dfs(1, 0);
        System.out.println("height");
        for(int i = 0; i < height.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int j : height) {
            System.out.print(" " + j);
        }
        System.out.println();
        System.out.println("depth");
        for(int i = 0; i < depth.length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int j : depth) {
            System.out.print(" " + j);
        }
        System.out.println();


    }
    public void dfs(int vertex, int parent){
        //take action on vertex after entering the vertex

        for(int child: graph.get(vertex)) {
            //take action on child before entering the child
            if (child == parent) continue;
//            System.out.println(child);
            depth[child] = depth[vertex] + 1;
            dfs(child, vertex);
            height[vertex] = Math.max(height[vertex], 1 + height[child]);
            //take action on child after exiting the child
        }
        //take action on vertex before exiting the vertex
    }
    static int sum = 0;
    static int even_count = 0;
    public void dfs_subTree_sum(int vertex, int parent){
        //bruteforce
        //take action on vertex after entering the vertex

        for(int child: graph.get(vertex)) {
            //take action on child before entering the child
            if (child == parent) continue;
//            System.out.println(child);
            dfs_subTree_sum(child, vertex);
            sum += child;
            //take action on child after exiting the child
        }
        //take action on vertex before exiting the vertex
    }

    public void dfs_subTree_sum_1(int vertex, int parent){
        //take action on vertex after entering the vertex
        int subTreeSum = 0;
        for(int child: graph.get(vertex)) {
            //take action on child before entering the child
            if (child == parent) continue;
//            System.out.println(child);
            dfs_subTree_sum_1(child, vertex);
            subTreeSum += subTreeSumArr[child];
            //take action on child after exiting the child
        }
//        System.out.println(vertex + " " + subTreeSum);
        subTreeSum += vertex;
        subTreeSumArr[vertex] = subTreeSum;
        //take action on vertex before exiting the vertex
    }



    public void dfs_subTree_evenCount(int vertex, int parent){
        //bruteforce
        //take action on vertex after entering the vertex

        for(int child: graph.get(vertex)) {
            //take action on child before entering the child
            if (child == parent) continue;
//            System.out.println(child);
            dfs_subTree_evenCount(child, vertex);
            even_count += (child % 2 == 0) ? 1 : 0;
            //take action on child after exiting the child
        }
        //take action on vertex before exiting the vertex
    }


    public void dfs_subTree_evenCount_1(int vertex, int parent){
        //take action on vertex after entering the vertex
        int subTreeCountEven = 0;
        for(int child: graph.get(vertex)) {
            //take action on child before entering the child
            if (child == parent) continue;
//            System.out.println(child);
            dfs_subTree_evenCount_1(child, vertex);
            subTreeCountEven += subTreeEvenCountArr[child];
            //take action on child after exiting the child
        }
//        System.out.println(vertex + " " + subTreeSum);
        subTreeCountEven += (vertex % 2 == 0) ? 1 : 0;
//        System.out.println(vertex + " " + subTreeCountEven);
        subTreeEvenCountArr[vertex] = subTreeCountEven;
        //take action on vertex before exiting the vertex
    }


    int[] depth1;

    public int diameter(int vertex, int parent){
        depth1 = new int[n+1];
        diameter_dfs(vertex,parent);
        int maxDepth1 = 0, maxNode = 0;
        for(int i = 1; i < depth1.length; i++) {
            if (maxDepth1 < depth1[i]) {
                maxDepth1 = depth1[i];
                maxNode = i;
            }
        }
        System.out.println(Arrays.toString(depth1));

        depth1 = new int[n+1];
        diameter_dfs(maxNode,0);
        System.out.println(Arrays.toString(depth1));
        int maxDepth2 = 0, maxNode2 = 0;
        for(int i = 1; i < depth1.length; i++) {
            if (maxDepth2 < depth1[i]) {
                maxDepth2 = depth1[i];
                maxNode2 = i;
            }
        }
        return maxDepth2;

    }
    public void diameter_dfs(int vertex, int parent) {
        for(int child: graph.get(vertex)) {
            if (child == parent) continue;
            depth1[child] = depth1[vertex] + 1;
            diameter_dfs(child, vertex);

        }
    }

    public static void main(String[] args) {
        dfsTrees dfst = new dfsTrees();
        dfst.readFile("dfstree.txt");
        dfst.make_graph();
//        dfst.calculate_height_depth();
        int vertex = 1, parent = 0;
        //bruteforce

//        dfst.dfs_subTree_sum(vertex,parent);
//        sum += vertex;
//        System.out.println(sum);

//        dfst.dfs_subTree_evenCount(vertex,parent);
//        even_count += (vertex % 2 == 0) ? 1: 0;
//
//        System.out.println(even_count);


        //optimized

//        subTreeSumArr = new int[n+1];
//        dfst.dfs_subTree_sum_1(vertex, parent);
//
//        for(int i = 0; i < subTreeSumArr.length; i++) {
//            System.out.print(" " + i);
//        }
//        System.out.println();
//        for (int j : subTreeSumArr) {
//            System.out.print(" " + j);
//        }
//

//        subTreeEvenCountArr = new int[n+1];
//        dfst.dfs_subTree_evenCount_1(vertex, parent);
//
//        for(int i = 0; i < subTreeEvenCountArr.length; i++) {
//            System.out.print(" " + i);
//        }
//        System.out.println();
//        for (int j : subTreeEvenCountArr) {
//            System.out.print(" " + j);
//        }

        //diameter of the tree
        int ans = dfst.diameter(vertex, parent);
        System.out.println(ans);
    }
}
