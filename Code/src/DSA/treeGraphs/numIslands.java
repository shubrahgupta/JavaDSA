package DSA.treeGraphs;

import java.util.ArrayList;

public class numIslands {
    static boolean[] visited;
    static ArrayList<Pair<Integer, Integer>>[] adjl;
    public int[][] adjacencyMatrix(int N, int M, int[][] connections) {
        int[][] adjm = new int[N+1][N+1];
        for(int[] x: connections) {
            int x1, y1, wt;
            x1 = x[0]; y1 = x[1]; wt = x[2];
            adjm[x1][y1] = wt;
            adjm[y1][x1] = wt;

        }
        return adjm;
    }

    public ArrayList<Pair<Integer, Integer>>[] adjacencyList(int N, int M, int[][] connections) {
        ArrayList<Pair<Integer, Integer>>[] adjl = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            adjl[i] = new ArrayList<Pair<Integer, Integer>>();

        }
        for(int[] x: connections) {
            int x1, y1, z1;
            x1 = x[0]; y1 = x[1]; z1 = x[2];
            adjl[x1].add(new Pair<>(y1,z1));
            adjl[y1].add(new Pair<>(x1,z1));


        }
        return adjl;
    }


    public static void dfs(int vertex){
        System.out.println(vertex);
        visited[vertex] = true;
        for(Pair<Integer, Integer> child: adjl[vertex]) {
            System.out.println("parent " + vertex + " child " + child.getFirst());
            if (visited[child.getFirst()])  continue;
            dfs(child.getFirst());
        }
    }

    public static void dfs_floodfill(char[][] image, int i, int j, char initialColour, char newColour){
        int n = image.length;
        int m = image[0].length;
        if (i < 0 || j < 0) return;
        if (i >= n || j >= m) return;
        if (image[i][j] != initialColour) return;
        image[i][j] = newColour;


        dfs_floodfill(image, i-1, j, initialColour, newColour);
        dfs_floodfill(image, i+1, j, initialColour, newColour);
        dfs_floodfill(image, i, j-1, initialColour, newColour);
        dfs_floodfill(image, i, j+1, initialColour, newColour);
    }

    public int numIslands(char[][] image) {
        int m = image.length;
        int n = image[0].length;
        char newColor = '2';
        char landColor = '1';
        int numIslands = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (image[i][j] == landColor) {
                    dfs_floodfill(image, i, j, image[i][j], newColor);
                    numIslands++;
                }


            }
        }
        return numIslands;


    }

    public static void main(String[] args) {
        int N = 6, M = 9;
        int[][] connections = {{1,3,4},{1,5,3},{3,5,2},{3,4,7},{3,6,8},{3,2,9},{2,6,1},{4,6,2},{5,6,3}};
//        int[][] array = {
//                {1, 1, 1},
//                {1, 1, 0},
//                {1, 0, 1}
//        };
//        int sr = 1, sc = 1, color = 2;
//        System.out.println(Arrays.deepToString(array));
//        floodFill ff = new floodFill();
//        int[][] ans = ff.floodFill(array, sr, sc, color);
//        System.out.println(Arrays.deepToString(ans));




        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
//        DSA.treeGraphs.representation q = new DSA.treeGraphs.representation();
//        int[][] adjm = q.adjacencyMatrix(N, M, connections);
//        adjl = q.adjacencyList(N,M, connections);
////        for(int[] x: adjm) {
////            for(int i:x) {
////                System.out.print(i + " ");
////            }
////            System.out.println();
////        }
////        System.out.println();
////        for(int i = 0; i < N; i++) {
////            System.out.print(i + ": ");
////            for(Pair<Integer, Integer> p : adjl[i]) {
////                System.out.print("(" + p.getFirst() + "," + p.getSecond() + ")");
////            }
////            System.out.println();
////        }
//        visited = new boolean[N+1];
//        dfs(1);


    }
}
