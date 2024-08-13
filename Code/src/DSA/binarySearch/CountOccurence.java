package DSA.binarySearch;
import java.util.*;

public class CountOccurence {
    public static void main(String[] args) {
       List<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
        int B = 10 ;
        System.out.println("array: " + A + "\n" + "target: " + B);
        Solution s = new Solution();
        int answer = s.findCount(A,B);
        System.out.println("Count: " + answer);
        int lB = s.lowerBound(A,B,0,A.size()-1);
        int uB = s.upperBound1(A,B,0,A.size()-1);
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

class Solution {
    /*
    * If element is not present, then returns -1
    * If duplicate elements are present, then returns the lowest index for that element.
    * */
    public int lowerBound(List<Integer> A, int B, int start, int end) {
        int low = -1;
        int mid;
        int steps = (end-start+1);
        while(steps > 0) {
            mid = start + (end-start)/2;
            if (B > A.get(mid)) start = mid+1;
            else if (B < A.get(mid)) end = mid - 1;
            else {
                low = mid;
                end = mid - 1;
            }
            steps /= 2;
        }
        return low;
    }
    /*
     * If element is not present, then returns array.size()
     * If duplicate elements are present, then returns the index of an element present in the array just greater than that element.
     * */
    public int upperBound(List<Integer> A, int B, int start, int end) {
        int high = end + 1;
        int mid;
        int steps = (end-start+1);
        while(steps > 0) {
            mid = start + (end-start)/2;
            if (B > A.get(mid)) start = mid+1;
            else if (B < A.get(mid)){
                end = mid-1;
            }
            else {
                start = mid+1;
                high = mid;
            }
            steps /= 2;
        }

        return high;
    }




    /*
     * If element is not present, then returns the index of an element present in the array just greater than that element.
     * If duplicate elements are present, then returns the index of an element present in the array just greater than that element.
     * */
    public int upperBound1(List<Integer> A, int B, int start, int end) {
        int high = end + 1;
        int mid;
        int steps = (end-start+1);
        while(steps > 0) {
            mid = start + (end-start)/2;
            if (B > A.get(mid)) start = mid+1;
            else if (B < A.get(mid)){
                end = mid-1;
                high = mid;
            }
            else {
                start = mid+1;
                high = mid;
            }
            steps /= 2;
        }
        if (B == A.get(A.size()-1)) {
            high = high + 1;
        }
        return high;
    }


    /*
     * If element is not present, then returns -1
     * If duplicate elements are present, then returns the index of any one of the target element.
     * */
    public int BinarySearch(List<Integer> A, int B, int start, int end) {
        int req = -1;
        int mid;
        int steps = (end-start+1);
        while(steps > 0) {
            mid = start + (end-start)/2;
            if (B > A.get(mid)) start = mid+1;
            else if (B < A.get(mid)) end = mid - 1;
            else {
                req = mid;

            }
            steps /= 2;
        }
        return req;
    }
    public int findCount(final List<Integer> A, int B) {
        int lB = lowerBound(A,B,0,A.size()-1);
        int uB = upperBound1(A,B,0,A.size()-1);
//        System.out.println(lB + " " + uB);
        if (lB == -1) {
            return 0;
        }
        return uB-lB;


    }

}

