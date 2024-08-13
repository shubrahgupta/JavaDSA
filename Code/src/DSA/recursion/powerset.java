package DSA.recursion;
import java.util.*;
import java.lang.*;
import java.io.*;

public class powerset {

}


class GFG1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine().trim());
        int T = 1;
        while (T-- > 0) {
            // Reading the size of the integer list
//            int n = Integer.parseInt(br.readLine().trim());
//            int n = 3;
            // Reading the integer list
//            String[] inputValues = br.readLine().trim().split(" ");

            //            int[] intList = new int[len];
//            for (int i = 0; i < len; i++) {
//                intList[i] = Integer.parseInt(Arrays.toString(inputValues));
//            }
//            ArrayList<Integer> intList = new ArrayList<>(
//                    Arrays.asList(5,2,1)
//            );
//            int N = 3;
//            for (int i = 0; i < n; i++) {
//                System.out.println(intList[i]);;
//            }


            Solution8 ob = new Solution8();
            int[] nums = {1,2,3};
            List<List<Integer>> s = ob.permute(nums);
//            String s = "A1B2";
//            ArrayList<String> ans = ob.permutation(s);
//            Collections.sort(ans);

            System.out.println(s);


        }
    }
}

class Solution2 {
    List<String> l;
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        String op = "";
        String ip = s;
        l = new ArrayList<>();
        solve(ip,op);
        Collections.sort(l);
//        l.remove(0);
        return l;
    }

    public void solve(String ip, String op) {
        if (ip.isEmpty()) {
            if (!op.isEmpty()) {
//                System.out.println(op);
//                char[] charA = op.toCharArray();
//                Arrays.sort(charA);
//                String sortedString = new String(charA);
//                l.add(sortedString);
                l.add(op);
            }

            System.out.println(l);
            return;
        }
        String last = ip.substring(0,1);
        ip = ip.replaceFirst(last, "");
        op = op + last;
//        System.out.println(op);
        solve(ip, op);



        op = op.replaceFirst(last, "");
//        System.out.println(op);
        solve(ip,op);

    }


}


class Solution1 {
    ArrayList<List<Integer>> l;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> op = new ArrayList<>();
        ArrayList<Integer> ip = new ArrayList<>();
        for(int i: nums) {
            ip.addLast(i);
        }
        l = new ArrayList<>();
        solve(ip, op);
        for(List<Integer> i : l) {

            Collections.sort(i);
        }
        HashSet<List<Integer>> hash = new HashSet<>(l);

        return new ArrayList<>(hash);
    }
    public void solve(List<Integer> ip, List<Integer> op) {
        if (ip.isEmpty()) {
            System.out.println("While appending: " + op);
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
        System.out.println("Before: ");
        System.out.println("op1: " + op1 + " ip: " + ip);
        System.out.println("op2: " + op2 + " ip: " + ip);
        solve(ip1, op1);
        System.out.println("After 1st: ");
        System.out.println("op1: " + op1 + " ip: " + ip);
        System.out.println("op2: " + op2 + " ip: " + ip);
        solve(ip2, op2);
        System.out.println("After both: ");
        System.out.println("op1: " + op1 + " ip: " + ip);
        System.out.println("op2: " + op2 + " ip: " + ip);

    }
}

class Solution3{
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
            System.out.println("While appending: " + op);
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
        System.out.println("Before: ");
        System.out.println("op1: " + op1 + " ip: " + ip);
        System.out.println("op2: " + op2 + " ip: " + ip);
        solve(ip1, op1);
        System.out.println("After 1st: ");
        System.out.println("op1: " + op1 + " ip: " + ip);
        System.out.println("op2: " + op2 + " ip: " + ip);
        solve(ip2, op2);
        System.out.println("After both: ");
        System.out.println("op1: " + op1 + " ip: " + ip);
        System.out.println("op2: " + op2 + " ip: " + ip);

    }

}

class Solution4 {
    //permutation with spaces
    ArrayList<String> l;
    ArrayList<String> permutation(String s)
    {
        // Code here
        String op = "";
        String ip = s;
        l = new ArrayList<>();
        solve(ip,op);
        TreeSet<String> t = new TreeSet<>(l);
//        Collections.sort(l);
//        l.remove(0);
        return new ArrayList<>(t);
    }

    public void solve(String ip, String op) {
        if (ip.isEmpty()) {
            if (op.endsWith(" ")){
                op = op.substring(0,op.length()-1);
            }
            if (!op.isEmpty()) {
//                System.out.println(op);
//                char[] charA = op.toCharArray();
//                Arrays.sort(charA);
//                String sortedString = new String(charA);
//                l.add(sortedString);
                l.add(op);

            }

            // System.out.println(l);
            return;
        }
         String last = ip.substring(0,1);
         ip = ip.replaceFirst(last, "");
        String ip1 = ip, ip2 = ip;
        String op1 = op + last + " ";
//        System.out.println(op);
        solve(ip1, op1);




//        System.out.println(op);
        String op2 = op + last;
        solve(ip2,op2);

    }

}

class Solution5 {
    //permutation with case change
    ArrayList<String> l;
    ArrayList<String> permutation(String s)
    {
        // Code here
        String op = "";
        String ip = s;
        l = new ArrayList<>();
        solve(ip,op);
        TreeSet<String> t = new TreeSet<>(l);
//        Collections.sort(l);
//        l.remove(0);
        return new ArrayList<>(t);
    }
    public String changeCase(String s) {
        if (s.toLowerCase().equals(s)) {
            return s.toUpperCase();
        }
        return s.toLowerCase();
    }

    public void solve(String ip, String op) {
        if (ip.isEmpty()) {
            if (op.endsWith(" ")){
                op = op.substring(0,op.length()-1);
            }
            if (!op.isEmpty()) {
//                System.out.println(op);
//                char[] charA = op.toCharArray();
//                Arrays.sort(charA);
//                String sortedString = new String(charA);
//                l.add(sortedString);
                l.add(op);

            }

            // System.out.println(l);
            return;
        }
        String last = ip.substring(0,1);
        ip = ip.replaceFirst(last, "");
        String ip1 = ip, ip2 = ip;

        String op1 = op + last;
//        System.out.println(op);
        solve(ip1, op1);




//        System.out.println(op);
        last = changeCase(last);
        String op2 = op + last;
        solve(ip2,op2);

    }

}

class Solution6 {
    //generate all parantheses
    ArrayList<String> l;
    public String[] generateParenthesis(int A) {
        ArrayList<String> list = permutation(A);
//        System.out.println(s);
//        String[] s1 = new String[s.size()];
//        for(int i = 0; i < s.size(); i++) {
//            s1[i] = s.get(i);
//        }
//        System.out.println(s1[0]);
        String[] array = list.toArray(new String[0]);
        return array;
    }
    ArrayList<String> permutation(int A)
    {
        // Code here
        String op = "";
        l = new ArrayList<>();
        solve(op, A, A);
        TreeSet<String> t = new TreeSet<>(l);
//        Collections.sort(l);
//        l.remove(0);
        return new ArrayList<>(t);
    }

    public void solve(String op, int ob, int cb) {
        if (ob == 0 && (cb == 0)) {
            l.add(op);
            return;

        }
        if ((ob > cb) || (ob < 0)) {
            return;
        }


        String opB = "(";
        String clB = ")";
        String op1 = op + opB;
        int ob1 = ob-1;
        int ob2 = ob;
        int cb2 = cb-1;
        int cb1 = cb;
//        System.out.println(op);
//        System.out.println("Before: ");
//        System.out.println("ob1: " + ob1 + " cb1: " + cb1);
//        System.out.println("ob2: " + ob2 + " cb2: " + cb2);
//        System.out.println("op: " + op1);
        solve(op1,ob1,cb1);

//        System.out.println("During : ");
//        System.out.println("ob1: " + ob1 + " cb1: " + cb1);
//        System.out.println("ob2: " + ob2 + " cb2: " + cb2);

        String op2 = op + clB;
//        System.out.println(op);
        solve(op2,ob2,cb2);
//        System.out.println("After : ");
//        System.out.println("ob1: " + ob1 + " cb1: " + cb1);
//        System.out.println("ob2: " + ob2 + " cb2: " + cb2);
//        System.out.println("op: " + op2);

    }

}

class Solution7 {
    //generate binary num with more 1s than 0s
    ArrayList<String> l;
    ArrayList<String> NBitBinary(int A) {
        // Code here
        String op = "";
        l = new ArrayList<>();
        solve(op, A, 0, 0);
        TreeSet<String> t = new TreeSet<>(l);
        TreeSet<String> stringReverse = (TreeSet<String>) t.descendingSet();
//        Collections.sort(l);
//        l.remove(0);
        return new ArrayList<>(stringReverse);
    }


    public void solve(String op, int N, int n1, int n0) {
        if (N == 0 && (n1 >= n0)) {
            l.add(op);
            return;

        }
        if (N < 0) {
            return;
        }
        else if (n0 > n1){
            return;
        }


        String op1 = op + "1";
        String op2 = op + "0";
        int N1 = N-1;
        int N2 = N-1;
        int n1_1 = n1 + 1;
        int n1_0 = n1;
        int n0_1 = n0;
        int n0_0 = n0 + 1;
        if (n1 == 0 && (n0 == 0)) {
            solve(op1,N1,n1_1, n0_1);
        }
        else {
            solve(op1,N1,n1_1, n0_1);
            solve(op2,N2,n1_0, n0_0);
        }
//        System.out.println(op);
//        System.out.println("Before: ");
//        System.out.println("ob1: " + ob1 + " cb1: " + cb1);
//        System.out.println("ob2: " + ob2 + " cb2: " + cb2);
//        System.out.println("op: " + op1);


//        System.out.println("During : ");
//        System.out.println("ob1: " + ob1 + " cb1: " + cb1);
//        System.out.println("ob2: " + ob2 + " cb2: " + cb2);

//        System.out.println(op);

//        System.out.println("After : ");
//        System.out.println("ob1: " + ob1 + " cb1: " + cb1);
//        System.out.println("ob2: " + ob2 + " cb2: " + cb2);
//        System.out.println("op: " + op2);

    }

}


class Solution8 {
    //kth permutation
    ArrayList<String> l;
    List<List<Integer>> l2;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l1 = new ArrayList<>();
        ArrayList<Integer> intt = new ArrayList<>();
        for(int i : nums) {
            intt.add(i);
        }

        solve_BT(intt, 0, l1);


        return l1;
    }
    public String getPermutation(int n, int k) {
        String op = "";
        l = new ArrayList<>();
        ArrayList<Integer> intt = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            intt.add(i);
        }
//        for(int i: intt) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

//        solve(op, n, intt, n);
        solve_BT_1(intt, 0);
        TreeSet<String> t = new TreeSet<>(l);
//        Collections.sort(l);
//        l.remove(0);
        ArrayList<String> w = new ArrayList<>(t);
//        System.out.println("ll:" + t);

        return w.get(k-1);
    }



    public void solve(String op, int N, ArrayList<Integer> arr, int n) {
        if (N == 0) {
            l.add(op);
            return;

        }
        if (N < 0) {
            return;
        }

        for(int i = 0; i < arr.size(); i++) {
            ArrayList<Integer> left = (new ArrayList<>(new HashSet<Integer>((Collection<? extends Integer>) arr.clone())));

            String op1 = op + left.get(i);
            left.remove(i);
            int N1 = N-1;
            solve(op1, N1, left, n);

        }


    }
    public static String ListToString(ArrayList<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        for(int i: arr) {
            sb.append(i);
        }
        return sb.toString();
    }

    public void solve_BT(ArrayList<Integer> arr, int pt, List<List<Integer>> l1) {
        if (pt == arr.size()) {
            System.out.println(l1);
            l1.add(new ArrayList<>(arr));

            return;

        }

        for(int j = pt; j < arr.size(); j++) {
//            System.out.println("Before swap: " + arr + " jth element: " + arr.get(j) + " ptth element: " + arr.get(pt));
            Collections.swap(arr, pt, j);
//            System.out.println("After swap: " + arr + " jth element: " + arr.get(j) + " ptth element: " + arr.get(pt));

            solve_BT(arr,pt+1, l1);
            Collections.swap(arr, pt, j);
//            System.out.println("Reversing swap: " + arr + " jth element: " + arr.get(j) + " ptth element: " + arr.get(pt));

        }


    }
    public void solve_BT_1(ArrayList<Integer> arr, int pt) {
        if (pt == arr.size()) {
//            System.out.println(arr);

            l2.add(new ArrayList<>(arr));
//            System.out.println(l2);
            return;

        }

        for(int j = pt; j < arr.size(); j++) {
//            System.out.println("Before swap: " + arr + " jth element: " + arr.get(j) + " ptth element: " + arr.get(pt));
            Collections.swap(arr, pt, j);
//            System.out.println("After swap: " + arr + " jth element: " + arr.get(j) + " ptth element: " + arr.get(pt));

            solve_BT_1(arr,pt+1);
            Collections.swap(arr, pt, j);
//            System.out.println("Reversing swap: " + arr + " jth element: " + arr.get(j) + " ptth element: " + arr.get(pt));

        }


    }

}

class Solution9 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int num : nums) {
            tempList.add(num);
        }

        solve_BT(tempList, 0, result);

        return result;
    }

    public void solve_BT(ArrayList<Integer> arr, int pt, List<List<Integer>> result) {
        if (pt == arr.size()) {
            // Create a new ArrayList to store the current permutation
            result.add(new ArrayList<>(arr));
            return;
        }

        for (int j = pt; j < arr.size(); j++) {
            Collections.swap(arr, pt, j);
            solve_BT(arr, pt + 1, result);
            Collections.swap(arr, pt, j);
        }
    }
}
