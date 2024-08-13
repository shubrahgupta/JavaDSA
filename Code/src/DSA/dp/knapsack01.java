package DSA.dp;

public class knapsack01 {
    static int[][] dp;
    public static void main(String[] args) {
        int N = 3, W = 3;
        int[] profit = {1, 2, 3}, weight = {4, 5, 6};
        dp = new int[N+1][W+1];
        knapsack01 q = new knapsack01();
        System.out.println(q.knapsack_memo(weight, profit, W, N));
        System.out.println(q.knapsack_tab(weight, profit, W, N));
    }
    public int knapsack_memo(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0) { dp[n][w] = 0; return dp[n][w];}
        if (wt[n-1] <= w) {
            dp[n][w] =  Math.max(
                    val[n-1] + dp[n-1][w-wt[n-1]],
                    dp[n-1][w]
            );

        }
        return dp[n][w];
    }
    public int knapsack_tab(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0) { dp[n][w] = 0; return dp[n][w];}

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= w; j++) {
                if (wt[i-1] <= j) {
                    dp[i][j] =  Math.max(
                            val[i-1] + dp[i-1][j-wt[i-1]],
                            dp[i-1][j]
                    );

                }
            }
        }

        return dp[n][w];
    }
}
