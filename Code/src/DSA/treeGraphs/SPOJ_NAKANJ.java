package DSA.treeGraphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class SPOJ_NAKANJ {
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
    static int[][] level, visited;
    public boolean isValid(int xs, int ys) {
        if (xs >= 8 || xs < 0)   return false;
        if (ys >= 8 || ys < 0)   return false;
        return true;
    }
    public int[] chessToCartesian(String src) {
        int x, y;
        x = src.charAt(0) - 97;
        y = Integer.parseInt(String.valueOf(src.charAt(1))) - 1;
        return new int[]{x,y};
    }
    static int[][] manipulations = {{2,1},{1,2},{2,-1},{-2,1}, {-2,-1}, {1,-2}, {-1, 2}, {-1,-2}};
    public void bfs(int xs, int ys) {
        visited = new int[8][8];
        level = new int[8][8];
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        visited[xs][ys] = 1;
        q.add(new ArrayList<>(Arrays.asList(xs, ys)));
        while(!q.isEmpty()) {
            ArrayList<Integer> src = q.poll();
            for(int[] child: manipulations) {
                int xc = src.get(0) + child[0], yc = src.get(1) + child[1];
                if (!isValid(xc, yc))   continue;
                if (visited[xc][yc] == 1) continue;
                visited[xc][yc] = 1;
                q.add(new ArrayList<>(Arrays.asList(xc, yc)));
                level[xc][yc] = level[src.get(0)][src.get(1)] + 1;
            }
        }
    }







    public static void main(String[] args) throws FileNotFoundException {
        SPOJ_NAKANJ q1 = new SPOJ_NAKANJ();
        try (BufferedReader br = new BufferedReader(new FileReader("Code\\spoj_nakanj.txt"))) {
            String firstLine = br.readLine();
            String line;
            int t = Integer.parseInt(firstLine);
            while((line = br.readLine()) != null) {
                String[] coordinates = line.split(" ");
                String src = coordinates[0], dest = coordinates[1];
                int[] cartesian_src = q1.chessToCartesian(src);
                int[] cartesian_dest = q1.chessToCartesian(dest);
                int xs = cartesian_src[0], ys = cartesian_src[1];
                int xd = cartesian_dest[0], yd = cartesian_dest[1];
                q1.bfs(xs, ys);
                System.out.println(Arrays.deepToString(level));
                System.out.println(level[xd][yd]);

            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }






    }
}
