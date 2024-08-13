package DSA.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class testing {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> a = new ArrayList<>(
                Arrays.asList(890, 992, 172, 479, 973, 901, 417, 215, 901, 283, 788, 102, 726, 609, 379, 587, 630, 283, 10, 707, 203, 417, 382, 601, 713, 290, 489, 374, 203, 680, 108, 463, 290, 290, 382, 886, 584, 406, 809, 601, 176, 11, 554, 801, 166, 303, 308, 319, 172, 619, 400, 885, 203, 463, 303, 303, 885, 308, 460, 283, 406, 64, 584, 973, 572, 194, 383, 630, 395, 901, 992, 973, 938, 609, 938, 382, 169, 707, 680, 965, 726, 726, 890, 383, 172, 102, 10, 308, 10, 102, 587, 809, 460, 379, 713, 890, 463, 108, 108, 811, 176, 169, 313, 886, 400, 319, 22, 885, 572, 64, 120, 619, 313, 3, 460, 713, 811, 965, 479, 3, 247, 886, 120, 707, 120, 176, 374, 609, 395, 811, 406, 809, 801, 554, 3, 194, 11, 587, 169, 215, 313, 319, 554, 379, 788, 194, 630, 601, 965, 417, 788, 479, 64, 22, 22, 489, 166, 938, 66, 801, 374, 66, 619, 489, 215, 584, 383, 66, 680, 395, 400, 166, 572, 11, 992)
        );
        System.out.println(s.singleNumber(a));


//        System.out.println(Math.abs(Integer.MIN_VALUE));
    }

}

class Solution {
    public int singleNumber(final List<Integer> A) {
        BitSet b = new BitSet(32);
//        System.out.println(b);
        for(int i = 0; i < 32; i++) {
//            System.out.println(b);
            int countZeroes = 0;
            for (Integer integer : A) {
                int z = (integer >> i) & 1;
                if (z == 0) countZeroes++;

            }
            if(countZeroes % 3 == 0) {
                b.set(i);
            }
            else {
                b.clear(i);
            }
        }
        System.out.println(bitSetToString(b,32));
        System.out.println(b);

        return bitSetToInt(b);

    }
    public static int bitSetToInt(BitSet bitSet) {
        int intValue = 0;

        // Iterate through each bit index in the BitSet
        for (int i = 0; i < 32; i++) {
            // Check if the bit at index i is set
            if (bitSet.get(i)) {
                // Set the corresponding bit in intValue using a bitwise OR
                intValue += (1 << i);
            }
        }

        return intValue;
    }

    public String bitSetToString(BitSet bitSet, int size) {
        StringBuilder binaryString = new StringBuilder();

        for (int i = 0; i < size; i++) {
            // Check if the bit at index i is set (1) or not (0)
            if (bitSet.get(i)) {
                binaryString.append('1');
            } else {
                binaryString.append('0');
            }
        }
        binaryString.reverse();

        // Print the binary string representation of the BitSet
        return "BitSet in 1/0 form: " + binaryString.toString();
    }
    public int divide(int A, int B) {
        if (B == 1){
            return A;
        }
        else if ((A == Integer.MIN_VALUE) && (B == -1)) {
            return Integer.MAX_VALUE;
        }
        return (int) something(A,B);

    }

    public long something(int A, int B) {
        int sign = 1;
        if (((A <= 0) && (B >= 0)) || ((A >= 0) && (B <= 0))) {
            sign = -1;
        }
        if (A == Integer.MIN_VALUE) {
            A = Integer.MAX_VALUE;
            if (B <= 0) sign = 1;
        }
        long a = Math.abs(A);
        long b = Math.abs(B);
//        System.out.println(a + " " + b);
        long c = (long) Math.exp(Math.log(a) - Math.log(b));
//        System.out.println(c);
        return sign * c;

    }
}

