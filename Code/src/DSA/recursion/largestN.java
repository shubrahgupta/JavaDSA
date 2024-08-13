package DSA.recursion;
import java.io.*;
import java.util.*;


public class largestN
{
    public static void main(String args[])throws IOException
    {
//        Scanner sc = new Scanner(System.in);
        int N = 2;
        ArrayList<Integer> ans = Solution11.increasingNumbers(N);
        for(int num : ans){
            System.out.print(num + " ");
        }
        System.out.println();


    }
}

// } Driver Code Ends


//User function Template for Java
class Solution11{
    static ArrayList<Integer> lit;
//    static ArrayList<Integer> tryer;
    static ArrayList<Integer> increasingNumbers(int N){
        // code here
        lit = new ArrayList<>();
        StringBuilder op = new StringBuilder();
        solve(N,0,op);
//        tryer = new ArrayList<>();
//        for(String i: lit) {
//            tryer.add(Integer.valueOf(i));
//        }
//        return tryer;
        return lit;

    }
    static ArrayList<Integer> listReq(int N, int prev) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (N == 1) {
            arr.add(0);
        }
        for (int i = prev+1; i <= 9; i++) {
            arr.add(i);
        }
        return arr;
    }
    static void solve(int N, int pos, StringBuilder op) {
        if (pos == N) {
//            System.out.println(op.toString());
            lit.add(Integer.parseInt(op.toString()));
            return;
        }
        ArrayList<Integer> arr;
        if (pos == 0) {
            arr = listReq(N, 0);
        }
        else {
            int prev = op.charAt(pos-1) - '0';
//            System.out.println("prev: " + prev);
            arr = listReq(N,prev);
        }
//        System.out.println(arr);
        for (Integer integer : arr) {
            op.append(integer);
            pos++;
//            System.out.println(op);
            solve(N, pos, op);
            op.deleteCharAt(pos - 1);
            pos--;
//            System.out.println("op:" + op);

        }



    }

}
