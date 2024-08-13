package DSA.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testing {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1,2));
        int B = 2 ;
        System.out.println("array: " + A + "\n" + "target: " + B);
        Solution1 s = new Solution1();
        int answer = s.findCount(A,B);
        System.out.println("Count: " + answer);
        int lB = s.lB(A,B);
        int uB = s.uB(A,B);
//////        int bs = s.BinarySearch(A,B,0,A.size()-1);
        try {
            System.out.println("Lower Bound index: " + lB + "\nElement at index: " + A.get(lB));
            System.out.println("Upper Bound index: " + uB + "\nElement at index: " + A.get(uB));
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Lower Bound index: " + lB);
            System.out.println("Upper Bound index: " + uB);
        }
    }
}

class Solution1 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int findCount(final List<Integer> A, int B) {
        return uB(A,B) - lB(A,B);
    }
    public int lB(final List<Integer> A, int B) {
        int start = 0, end = A.size()-1;

        while(start < end) {
            int mid = (start) + (end-start)/2;
            if (A.get(mid) >= B)    end = mid;
            else    start = mid + 1;
        }
        return start;
    }
    public int uB(final List<Integer> A, int B) {
        int start = 0, end = A.size()-1;

        while(start < end) {
            int mid = (start) + (end-start)/2;
            if (A.get(mid) > B)    end = mid;
            else    start = mid + 1;
        }
        return start;
    }
}

