package DSA.dp;

public class booleanParanthesization {
    public static void main(String[] args) {
        int n = 7;
        String s = "T|T&F^T";
        System.out.println(booleanParanthesization.countWays(n, s));
    }
    static int[][][] dp;
    static int countWays(int N, String s){
        dp = new int[N+1][N+1][2];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++)   {
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int i = 0, j = N-1;
        return solve(s, i, j, true);
    }
    static int solve(String s, int i, int j, boolean needTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (needTrue) {if (s.charAt(i) == 'T')  return 1; else return 0; }
            else {if (s.charAt(i) == 'F')  return 1; else return 0; }
        }
        if (needTrue)   {if (dp[i][j][1] != -1) return dp[i][j][1];}
        else {if (dp[i][j][0] != -1) return dp[i][j][0];}
        int ans = 0;
        for(int k = i+1; k <= j-1; k+=2) {
            int lt = solve(s, i, k-1, true);
            int lf = solve(s, i, k-1, false);
            int rt = solve(s, k + 1, j, true);
            int rf = solve(s, k + 1, j, false);

            if (s.charAt(k) == '|') {
                if (needTrue)   ans += (lt * rt + lt * rf + lf * rt);
                else ans += lf * rf;
            }
            else if (s.charAt(k) == '&') {
                if (needTrue)   ans += (lt * rt);
                else ans += (lf * rf + lt * rf + lf * rt);
            }
            else {
                if (needTrue)   ans += (lt * rf + lf * rt);
                else ans += (lf * rf + lt * rt);
            }

        }
        if (needTrue)   {dp[i][j][1] = ans; return dp[i][j][1];}
        else {dp[i][j][0] = ans; return dp[i][j][0];}

    }
}
