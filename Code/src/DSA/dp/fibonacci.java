package DSA.dp;

import java.util.Arrays;

public class fibonacci {
    public static void main(String[] args) {
        int n = 9;
        int[] F = new int[n+1];
        Arrays.fill(F, 0, F.length, -1);
//        System.out.println(Arrays.toString(F));
        int ans = fib(F,n);
        System.out.println(ans);
    }
    public static int fib(int[] F, int n) {
        if (n == 0) {
            F[n] = 0;
            return F[n];
        }
        else if (n == 1) {
            F[n] = 1;
            return F[n];
        }
        if (F[n] != -1) {
            return F[n];
        }
        F[n] = fib(F, n-1) + fib(F,n-2);
        return F[n];


    }
}
