package DSA.dp;


import java.util.Arrays;

public class subsetSum {
    static int[][] dp;
    static Boolean[][] t;
    public static void main(String[] args) {

        int N = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;


        boolean ans = subsetSum.isSubsetSum(N,arr,sum);
        System.out.println(ans);

    }
    static Boolean isSubsetSum(int N, int[] arr, int sum) {
        dp = new int[N+1][sum+1];
        t = new Boolean[N+1][sum+1];
        for(int i = 0; i <= N; i++)
            Arrays.fill(dp[i],-1);

        return func_tab(N,arr,sum,t);
    }

    static Boolean func(int N, int[] arr, int sum, int[][] dp){
        boolean ans;
        if (sum == 0 && N == 0) return true;
        else if (sum == 0 && N != 0) return true;
        else if (sum != 0 && N == 0) return false;
        if (dp[N][sum] != -1)   return (dp[N][sum] == 1) ;
        if (arr[N-1] <= sum) {
            ans = (isSubsetSum(N - 1, arr, sum) || isSubsetSum(N - 1, arr, sum - arr[N - 1]));
            dp[N][sum] = (!ans) ? 0 : 1;
        }


        else {
            ans = isSubsetSum(N-1, arr,sum);
            dp[N][sum] = (!ans) ? 0 : 1;
        }


        return dp[N][sum] == 1;

    }


    static Boolean func_tab(int N, int[] arr, int sum, Boolean[][] t){
        for(int i = 0; i < N+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                if (i == 0) t[i][j] = false;
                else if (j == 0) t[i][j] = true;

            }
        }
        for(int i = 1; i < N+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = (t[i-1][j] || t[i - 1][j - arr[i - 1]]);
                }

                else {
                    t[i][j] = t[i-1][j];

                }
            }
        }



        return t[N][sum];

    }
}
