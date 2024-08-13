package DSA.treeGraphs;

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    static ArrayList<Integer> visited;

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new ArrayList<>(Collections.nCopies(V, 0));
        boolean flag = false;
        for(int i = 0; i < V; i++) {
            flag = dfs(i,0,adj);
            if (flag)   return flag;
        }
        return flag;
    }
    public boolean dfs(int vertex, int parent, ArrayList<ArrayList<Integer>> adj){
        System.out.println(visited);
        visited.set(vertex,1);
        boolean isLoop = false;

        for(int child: adj.get(vertex)) {
            System.out.println("parent " + vertex + " child " + child);
            if (visited.get(child) == 1 && (child == parent)) continue;
            else if (visited.get(child) == 1) {return true;}

//            System.out.println(child);
            isLoop |= dfs(child, vertex, adj);
        }
        return isLoop;
    }
}