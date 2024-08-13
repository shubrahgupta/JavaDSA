package contests;

public class p2 {
    public int minFlips(int[][] grid) {
        int rowA = 0, colA = 0;
        for(int[] x: grid){
            int n = x.length;
            for(int i = 0; i < n/2; i++) {
                if (x[i] != x[n-1-i]) rowA++;
            }
        }
        int nRow = grid.length;
        int nCol = grid[0].length;

        for(int i = 0; i < nCol; i++) {
            for(int j = 0; j < nRow/2; j++){
                if (grid[j][i] != grid[nRow-1-j][i]) colA++;

            }
        }
        System.out.println(rowA + " " +  colA);
        return Math.max(rowA, colA);

    }
    public static void main(String[] args) {
        int[][] array = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        int[][] array1 = {
                {0, 1},
                {0, 1},
                {0, 0}
        };
        int[][] array2 = {
                {1},
                {0}
        };
        p2 p2 = new p2();
        System.out.println(p2.minFlips(array));
        System.out.println(p2.minFlips(array1));
        System.out.println(p2.minFlips(array2));
    }
}
