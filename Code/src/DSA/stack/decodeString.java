package DSA.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class decodeString {
    public ArrayList<String> splitString(String s) {
        Stack<Character> st = new Stack<>();
        ArrayList<String> ar = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        while(!st.isEmpty()) {
            StringBuilder y = new StringBuilder();
            boolean flag = false;
            if (st.peek() != '[' && st.peek() != ']' && !Character.isDigit(st.peek())) {

                y.append(st.pop());
                flag = true;

            }
            else if (st.peek() == ']') {
                int cb = 1;
                st.pop();
                while(!st.isEmpty()) {

                    if (st.peek() == ']') {
                        cb++;
                        st.pop();
                        y.append(" ");
                    }
                    else if (st.peek() == '[') {
                        cb--;
                        st.pop();
//                        y.append(" ");
                        if (cb == 0)  break;
                    }
                    else if (Character.isDigit(st.peek())){
                        y.append(st.pop());
                        y.append(" ");
                    }
                    else if (st.peek() != '[' && cb != 0) {
                        y.append(st.pop());
                    }

                }
            }
            else if (Character.isDigit(st.peek())) {
                y.append(st.pop());
            }
//            System.out.println(y);

            ar.add(y.toString());
            if (flag)   ar.add(String.valueOf(1));

        }
        Collections.reverse(ar);
        ar.replaceAll(this::rev);
        return ar;

    }
    public String rev (String i) {
        StringBuilder b = new StringBuilder(i);
        return b.reverse().toString();

    }
    public String decodeString(String s) {
        ArrayList<String> splitString = splitString(s);
        ArrayList<Integer> number = new ArrayList<>();
        ArrayList<String> string = new ArrayList<>();
        for(int i = 0; i < splitString.size(); i+=2) {
            number.add(Integer.valueOf(splitString.get(i)));
        }
        for(int i = 1; i < splitString.size(); i+=2) {
            string.add(splitString.get(i));
        }
//        System.out.println("["+ splitString.get(1) + "]");
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < number.size(); i++) {
            ans.append(string.get(i).repeat(number.get(i)));
        }
//        System.out.println(ans);
        String[] parts = ans.toString().split(" ");

        StringBuilder t = new StringBuilder();
        for(int i = 0; i < parts.length; i++) {
            if (Character.isDigit(parts[i].charAt(0))) {
                int times = parts[i].charAt(0)-'0';
                System.out.println("times: " + times);
                String word = parts[i].substring(1);
                parts[i] = word.repeat(times);

            }

        }
        System.out.println(Arrays.toString(parts));
        for(int i = 0; i < parts.length; i++) {
            t.append(parts[i]);
        }


        return t.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[cde5[h]h]]x";
        decodeString q = new decodeString();
        String out = q.decodeString(s);

        System.out.println(out);
//        System.out.println(ans);
    }
}

//This beauty can handle the nested loops, integers till single digit, but for 2/3 digit, it fails.

