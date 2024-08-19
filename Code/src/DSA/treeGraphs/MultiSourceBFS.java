package DSA.treeGraphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MultiSourceBFS {
    public boolean isValid(int i, int j, ArrayList<ArrayList<Integer>> arr) {
        int n = arr.size();
        int m = arr.get(0).size();
        if (i >= n || j >= m || i < 0 || j < 0) return false;
        return true;
    }
    static int[][] manipulations = {{1,0},{-1,0},{0,-1},{0,1}, {1,1}, {1,-1}, {-1, 1}, {-1,-1}};

    public int numHours(ArrayList<ArrayList<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
        ArrayList<ArrayList<Integer>> level = new ArrayList<>();
        int m = arr.get(0).size();
        for(int i = 0; i < arr.size(); i++) {
            level.add(new ArrayList<>(Collections.nCopies(m, Integer.MAX_VALUE)));
            for(int j = 0; j < arr.get(0).size(); j++) {
                if (arr.get(i).get(j) > max) {
                    max = arr.get(i).get(j);
                    coordinates = new ArrayList<>();
                    coordinates.add(new ArrayList<>(Arrays.asList(i,j)));
                }
                else if (arr.get(i).get(j) == max) {
                    coordinates.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.addAll(coordinates);
        for(ArrayList<Integer> coordinate:coordinates) {
            level.get(coordinate.get(0)).set(coordinate.get(1), 0);
        }
        while(!q.isEmpty()) {
            ArrayList<Integer> el = q.poll();

            for(int[] manipulation: manipulations) {
                int x = el.get(0), y = el.get(1);
                int xMan = x + manipulation[0], yMan = y + manipulation[1];
                if (!isValid(xMan ,yMan, arr)) continue;

                if (level.get(x).get(y) + 1 < level.get(xMan).get(yMan)) {
                    level.get(xMan).set(yMan, level.get(x).get(y) + 1);
                    q.add(new ArrayList<>(Arrays.asList(xMan, yMan)));
                }
            }
        }
        System.out.println(level);
        int levelMax = 0;
        for(ArrayList<Integer> y: level) {
            for(int i: y) {
                levelMax = Math.max(levelMax, i);
            }
        }
        return levelMax;
    }

    public static void main(String[] args) {
        int t;
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("Code\\multisourcebfs.txt"))) {
            line = br.readLine();
            t = Integer.parseInt(line);
            while(t>0) {
                t--;
                String[] nm = br.readLine().split(" ");
                int n = Integer.parseInt(nm[0]);
                int m = Integer.parseInt(nm[1]);
                ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    String[] line1 = br.readLine().split(" ");
                    ArrayList<Integer> row = new ArrayList<>();
                    for (String s : line1) {
                        row.add(Integer.parseInt(s));
                    }
                    arr.add(row);

                }
                MultiSourceBFS bfs = new MultiSourceBFS();
                System.out.println(bfs.numHours(arr));

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
