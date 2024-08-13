package DSA.dp;

public class LCS {
    public static void main(String[] args) {
        String x = "leetcode";
        String y = "geek";

        LCS q = new LCS();
        System.out.println(q.length_longest_palindromic_subsequence(x));

    }
    public int[][] length_lCS(String x, String y, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }

    public int length_lCS_not_print(String x, String y, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public String printLCS(int m, int n, String x, String y) {
        int[][] dp = length_lCS(x,y,m,n);
        int i = m, j = n;
        StringBuilder lcs = new StringBuilder();

        while(i > 0 & j > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                lcs.append(x.charAt(i-1));
                i--;j--;
            }
            else {
                if (dp[i-1][j] >= dp[i][j-1]) {
                    i--;
                }
                else {
                    j--;
                }
            }
        }
        lcs.reverse();
        return lcs.toString();
    }
    public String shortestCommonSupersequence(String x, String y) {
        String lcs = printLCS(x.length(), y.length(), x, y);
        StringBuilder ans = new StringBuilder();
        int x_i = 0, y_j = 0;
        for(char c: lcs.toCharArray()) {
            while(x_i < x.length() && (x.charAt(x_i) != c)) {
                ans.append(x.charAt(x_i));
                x_i++;
            }
            while(y_j < y.length() && (y.charAt(y_j) != c)) {
                ans.append(y.charAt(y_j));
                y_j++;
            }
            ans.append(c);
            x_i++; y_j++;
        }
        ans.append(x.substring(x_i)).append(y.substring(y_j));
        return ans.toString();

    }
    public int length_longest_palindromic_subsequence(String s) {
        StringBuilder t = new StringBuilder(s);
        t.reverse();
        return length_lCS_not_print(s,t.toString(),s.length(),t.length());
    }
    public String shortestCommonSupersequence_diff(String x, String y) {
        int[][] dp = length_lCS(x, y, x.length(), y.length());
        StringBuilder ans = new StringBuilder();
        int i = x.length(), j = y.length();
        while(i > 0 && j > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                ans.append(x.charAt(i-1));
                i--;
                j--;
            }
            else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    ans.append(x.charAt(i-1));
                    i--;
                }
                else if (dp[i-1][j] <= dp[i][j-1]) {
                    ans.append(y.charAt(j-1));
                    j--;
                }
            }

        }
        while(i > 0) {
            ans.append(x.charAt(i-1));
            i--;
        }
        while(j > 0) {
            ans.append(y.charAt(j-1));
            j--;
        }
        ans.reverse();
        return ans.toString();

    }
}
