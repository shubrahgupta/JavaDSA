package DSA.recursion;
import java.io.*;
import java.util.*;
public class gfg_try {
}
//{ Driver Code Starts
//Initial Template for Java


class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < N ; i++){
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<List<Integer>> l;

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> op = new ArrayList<>();
        ArrayList<Integer> ip = arr;

        l = new ArrayList<>();
        solve(ip, op);
        ArrayList<Integer> sumArray = new ArrayList<>();
        for(List<Integer> i : l) {
            int sum = 0;
            for (Integer j: i) {
                sum += j;
            }
            sumArray.add(sum);
        }
        HashSet<Integer> hash = new HashSet<>(sumArray);

        return new ArrayList<>(hash);
    }
    public void solve(List<Integer> ip, List<Integer> op) {
        if (ip.isEmpty()) {
            // System.out.println("While appending: " + op);
            l.addLast(op);
            return;
        }
        ArrayList<Integer> ip1 = new ArrayList<>(ip);
        ArrayList<Integer> ip2 = new ArrayList<>(ip);
        ArrayList<Integer> op1 = new ArrayList<>(op);
        ArrayList<Integer> op2 = new ArrayList<>(op);

        int last = ip.get(0);
        ip1.remove(0);
        ip2.remove(0);
//        ip.remove(0);

//        System.out.println(ip);
        op1.addLast(last);
        /*System.out.println("Before: ");
        System.out.println("op1: " + op1 + " ip: " + ip);
        System.out.println("op2: " + op2 + " ip: " + ip);*/
        solve(ip1, op1);
        // System.out.println("After 1st: ");
        // System.out.println("op1: " + op1 + " ip: " + ip);
        // System.out.println("op2: " + op2 + " ip: " + ip);
        solve(ip2, op2);
        // System.out.println("After both: ");
        // System.out.println("op1: " + op1 + " ip: " + ip);
        // System.out.println("op2: " + op2 + " ip: " + ip);

    }

}
