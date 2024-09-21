package StriverSheet.Arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class PascalsTriangle {

    static int[][] dp;
    public int getDigit(int n, int k) {
        if ((n == k) || (k == 0)) {
            return dp[0][0];
        }
        if (dp[n][k] != 0) {
            return dp[n][k];
        }
        return getDigit(n-1, k) + getDigit(n-1,k-1);
    }
    public void tableEntry(int numRows) {
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j <= i; j++) {
                if (dp[i][j] == 0) {
                    dp[i][j] = getDigit(i, j);
                }
            }
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        tableEntry(numRows);
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                list.add(dp[i][j]);
            }
            answer.add(list);
        }
        return answer;
    }

    public static void main(String[] args) {
        dp = new int[30][30];
        dp[0][0] = 1;
        PascalsTriangle q = new PascalsTriangle();
//        System.out.println(q.getDigit(5,4));
        System.out.println(q.generate(29));

    }
}
