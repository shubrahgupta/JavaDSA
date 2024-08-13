package DSA.arrayString;

import java.util.*;

public class revWordsString {
    public static void main(String[] args) {
        String s = " hello red  world    ";
        revWordsString r = new revWordsString();
        String answer = r.reverseWords(s);
        System.out.println(answer);
    }
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
//        System.out.println(Arrays.toString(s1));


        ArrayList<String> s2 = new ArrayList<>(Arrays.asList(s1));
//        for(String i:s2) {
////            System.out.println(i);
//            if (i.isEmpty()) System.out.println(true);
//        }
//        System.out.println(s2);
//        Collections.reverse(s2);
        List<String> s4;
        s4 = s2.reversed();
        s4.removeIf(String::isEmpty);
//        System.out.println(s2);
        StringBuilder s3 = new StringBuilder();
        String delimiter = " ";
        for(String i: s4) {
            s3.append(i);
            s3.append(delimiter);
        }
        s3.deleteCharAt(s3.length()-1);
        return s3.toString();
    }
}
