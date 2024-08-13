package DSA.recursion;

import java.util.ArrayList;
import java.util.Collections;


public class LargestKswaps {
    public static void main(String[] args) {
//        Solution10 s = new Solution10();
        String num = "9877504563120052443"; int k = 3;
//        System.out.println(Solution10.returnMaxIndices(new StringBuilder(num),0));
        System.out.println(Solution10.findMaximumNum(num,k));
    }
}

class Solution10 {
    static ArrayList<String> lisst;
    public static String findMaximumNum(String num, int k) {
        String x = maxInteger(num,k);
        return x;

    }
    public static String maxInteger(String num, int k) {
        StringBuilder sNum = new StringBuilder(num);
        lisst = new ArrayList<>();
        solve(sNum, k, 0);
        Collections.sort(lisst);
//         System.out.println(lisst);
        return lisst.get(lisst.size()-1).toString();

    }
    public static ArrayList<Integer> returnMaxIndices(StringBuilder num, int start) {
        ArrayList<Integer> arr = new ArrayList<>();
        int startith = Integer.parseInt(String.valueOf(num.charAt(start)));
        int max = -1;
//        System.out.println("Max: " + max);
        for(int i = start+1 ; i < num.length(); i++) {
            int i1 = Integer.parseInt(String.valueOf(num.charAt(i)));

            if (i1 == max && (i1 > startith)) {
                arr.add(i);
            }
            else if (i1 > max && (i1 > startith)){

                max = i1;
                arr.clear();
                arr.add(i);
            }
        }
        return arr;
    }
    public static void swap(StringBuilder stringBuilder, int i, int j) {
        char temp = stringBuilder.charAt(i);
        stringBuilder.setCharAt(i, stringBuilder.charAt(j));
        stringBuilder.setCharAt(j, temp);
    }
    public static void solve(StringBuilder num, int k, int start) {
        if ((k == 0) || start == num.length()-1) {
//            System.out.println(num);
            lisst.add(num.toString());
            return;
        }
        ArrayList<Integer> arr = returnMaxIndices(num, start);

        System.out.println("num: " + num);
        System.out.println("start: " + start);
        System.out.println(arr);
        if (!arr.isEmpty()) {
            for(int i : arr) {
                int ith = Integer.parseInt(String.valueOf(num.charAt(i)));
                int startith = Integer.parseInt(String.valueOf(num.charAt(start)));
                System.out.println(ith > startith);
                System.out.println(num.charAt(i) + " " + num.charAt(start) );
                if (num.charAt(i) > num.charAt(start)) {
                    swap(num, start, i);
                    System.out.println("after swap: " + num);
                    k--;
                    start += 1;

                    solve(num, k, start);
                    k++; start -= 1;
                    swap(num, i, start);
                    System.out.println("bt: " + num);

                }

            }
        }
        else {

            start+=1;
            solve(num, k, start);

        }



    }

}
