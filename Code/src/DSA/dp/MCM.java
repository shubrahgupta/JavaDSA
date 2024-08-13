package DSA.dp;

public class MCM {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int N = 5;
        System.out.println(MCM.matrixMultiplication(N,arr));
    }
    static int[][] dp;

    static int matrixMultiplication(int N, int arr[])
    {
        dp = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++)   {
                dp[i][j] = -1;
            }
        }
        int i = 1, j = N-1;
        return solve(arr, i, j);
    }
    static int solve(int arr[], int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {
            int temp_ans = solve(arr, i, k) + solve(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);

            ans = Math.min(temp_ans, ans);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
