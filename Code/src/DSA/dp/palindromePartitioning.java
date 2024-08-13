package DSA.dp;

public class palindromePartitioning {
    public static void main(String[] args) {
        String s = "aaabba";
        System.out.println(palindromicPartition(s));
//        String s1 = "aaabba";
//        System.out.println(isPalindrome(s, 2,s.length()-1));
    }
    static int[][] dp;
    static boolean isPalindrome(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) == s.charAt(j)) {
            i++; j--;
            return isPalindrome(s,i,j);
        }
        else {
            return false;
        }

    }

    static int solve(String str, int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (isPalindrome(str, i, j))  return 0;
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++) {
            int temp_ans = solve(str, i, k) + solve(str, k+1, j) + 1;

            ans = Math.min(temp_ans, ans);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    static int palindromicPartition(String str)
    {
        int N = str.length();
        dp = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++)   {
                dp[i][j] = -1;
            }
        }
        int i = 0, j = N-1;
        return solve(str, i, j);
    }
}
