package DSA.dp;

import java.util.*;

public class scrambledString {
    public static void main(String[] args) {
        scrambledString q = new scrambledString();
        String A = "qmfcwwzbqkf",
        B = "wfcmbzwqqkf";

        System.out.println(q.isScramble(A, B));
    }
    Map<String, Boolean> m;
    public int isScramble(final String a, final String b) {
        m = new HashMap<>();
        if (a.length() != b.length()) return 0;
        if (a.isEmpty()) return 1;
        return (solve(a, b))?1:0;
    }
    public boolean solve(String a, String b) {

        if (a.equals(b)) return true;
        if (a.length() <= 1) return false;
        String key = a + " " + b;
        if (m.containsKey(key)) return m.get(key);
        boolean flag = false;
        for(int k = 1; k <= a.length()-1; k++) {
            String a_last = a.substring(a.length() - k);
            String b_last = b.substring(b.length() - k);
            String a_first = a.substring(0, k);
            String b_first = b.substring(0, k);
            if ((solve(a_first, b_last) && (solve(a_last, b_first))) ||
                    (solve(a_first,b_first) && (solve(a_last, b_last)))) {
                flag = true;
                break;

            }

        }
        m.put(key, flag);
        return flag;



    }
}
