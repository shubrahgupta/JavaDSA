package DSA.recursion;

import java.util.ArrayList;

public class josephus {
    public static void main(String[] args) {
        int n = 32, k = 32;
        System.out.println(Solution_josephus.safePos(n,k));
    }
}
class Solution_josephus {
    static ArrayList<Integer> l;
    static int safePos(int n, int k) {

        l = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            l.add(i);
        }
        solve(k-1, 0);
        return l.get(0);

        // code here
    }
    public static void solve(int k, int last) {
        if (l.size() == 1) {
            return;
        }
        int k1 = (k + last) % l.size();
        System.out.println("k1: " + k);
        System.out.println("l: " + l);
        l.remove(k1);
        solve(k, k1);
    }
};
