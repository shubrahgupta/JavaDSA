package DSA.dp;

public class eggDroppingProb {
    int[][] dp;

    public int superEggDrop(int e, int f) {
        dp = new int[e + 1][f + 1];
        for (int i = 0; i <= e; i++) {
            for (int j = 0; j <= f; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(e, f);
    }

    public int solve(int e, int f) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;

        if (dp[e][f] != -1) return dp[e][f];

        int low = 1, high = f;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            int breakCase = solve(e - 1, mid - 1);  // Egg breaks
            int noBreakCase = solve(e, f - mid);    // Egg doesn't break

            // We need the worst case
            int temp_ans = 1 + Math.max(breakCase, noBreakCase);
            ans = Math.min(ans, temp_ans);

            // Binary search
            if (breakCase > noBreakCase) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        dp[e][f] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int f = 5, e = 3;
        eggDroppingProb q = new eggDroppingProb();
        System.out.println(q.superEggDrop(e, f));
    }
}

