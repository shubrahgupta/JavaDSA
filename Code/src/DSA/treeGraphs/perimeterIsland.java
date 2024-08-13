package DSA.treeGraphs;

public class perimeterIsland {
    static int count = 0;
    public int islandPerimeter(int[][] grid) {
        int i, j = 0;
        outerloop:
        for(i = 0; i < grid.length; i++) {
            for(j = 0; j < grid[0].length; j++) {
//                System.out.print("hh: "  + grid[i][j] + " ");
                if (grid[i][j] == 1) {
                    break outerloop;
                }
            }
//            System.out.println();

        }
        System.out.println(i + " " + j);
        dfs(grid, i, j);
        return count;

    }
    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0) {count ++;
            System.out.println("smaller b:" +count);
            return;}
        if (i >= grid.length || j >= grid[0].length) {count ++;
            System.out.println("larger b:" + count);
            return;}
        if (grid[i][j] == 0) {count ++;
            System.out.println("water surr:" + count);
            return;}
        if (grid[i][j] == 2) return;
        grid[i][j] = 2;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        int[][] grid1 = {{1}};
        int[][] grid2 = {{1, 0}};

        perimeterIsland p = new perimeterIsland();
//        System.out.println(p.islandPerimeter(grid));
//        System.out.println(p.islandPerimeter(grid1));
        System.out.println("Ans: " + p.islandPerimeter(grid2));
    }
}
