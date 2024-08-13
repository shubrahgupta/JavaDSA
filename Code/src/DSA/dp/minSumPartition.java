package DSA.dp;

import java.util.ArrayList;

public class minSumPartition {
    Boolean[][] t;
    public static void main(String[] args) {
        minSumPartition q = new minSumPartition();
        int N = 4;
        int[] arr = {1, 6, 11, 5};
        System.out.println(q.minDifference(arr, N));
    }
    public int minDifference(int[] arr, int n)
    {
        int S = 0;
        for(int i: arr) S += i;
        t = new Boolean[n+1][S+1];
        ArrayList<Integer> permissible = func_tab(n, arr, S);

        int diff = Integer.MAX_VALUE;

        for(int i: permissible) {
            if (Math.abs(S - 2*i) < diff) {
                diff = Math.abs(S - 2*i);
            }
        }
        return diff;

    }
    ArrayList<Integer> func_tab(int N, int[] arr, int sum){
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



        ArrayList<Integer> ans = new ArrayList<>();
        for(int j = 0; j < sum + 1; j++) {
            if (t[N][j])  ans.add(j);
        }
        return ans;

    }
}
