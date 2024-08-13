package DSA.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class equalRowColumnPair {
    public static void main(String[] args) {
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        equalRowColumnPair q = new equalRowColumnPair();
        int ans = q.equalPairs(grid);
        System.out.println(ans);
    }

    public int equalPairs(int[][] grid) {
        Map<Integer, int[]> r = new HashMap<>();
        Map<Integer, int[]> c = new HashMap<>();
        for(int k = 0; k < grid.length; k++) {
            r.put(k, grid[k]);
        }
        for(int k = 0; k < grid.length; k++) {
            int[] cc = new int[grid.length];
            for(int j = 0; j < grid.length; j++) {
                cc[j] = grid[j][k];
            }
//            System.out.println(Arrays.toString(cc));
            c.put(k, cc);
        }
//        for(int i:r.keySet()) {
//            System.out.println(i + " " + Arrays.toString(r.get(i)));
//        }
//        for(int i:c.keySet()) {
//            System.out.println(i + " " + Arrays.toString(c.get(i)));
//        }
        int count = 0;
        for(int i:r.keySet()){
            for(int j:c.keySet()) {
                if (Arrays.equals(r.get(i), c.get(j))) {
                    count++;
                }
            }
        }
        return count;

    }
//    public boolean compareRowColumn(int[][] grid, int i, int j) {
//        ArrayList<Integer> ar = new ArrayList<>();
//        ArrayList<Integer> ac = new ArrayList<>();
//        for(int k = 0; k < grid.length; k++) {
//            ar.add(grid[k][j]);
//        }
//        for(int k = 0; k < grid.length; k++) {
//            ac.add(grid[i][k]);
//        }
//        if (ar.equals(ac))  return true;
//        return false;
//
//    }
//    public int equalPairs(int[][] grid) {
//        int count = 0;
//        for(int i = 0; i < grid.length; i++) {
//            for(int j = 0; j < grid[0].length; j++) {
//                if (compareRowColumn(grid, i, j)) count++;
//            }
//        }
//        return count;
//    }
}
