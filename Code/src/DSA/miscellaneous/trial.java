package DSA.miscellaneous;

import java.util.ArrayList;


public class trial {
    public static void main(String[] args) {
        int x = 12;
        String x1 = String.valueOf(x);
        System.out.println(x1.length());

    }

}

class Solution2 {
    long mod = (long) (Math.pow(10,7) + 9);
    public int cntBits(ArrayList<Integer> A) {
        long answer = 0;
        for(int j = 0; j < 32; j++){
            long countOnes = 0;
            for (Integer integer : A) {
                if ((integer & (1 << j)) == 1)  countOnes++;
            }
            answer += (2 * (((countOnes%mod) * ((A.size() - countOnes)%mod))%mod)%mod);

        }
        return (int) answer;


    }
}

