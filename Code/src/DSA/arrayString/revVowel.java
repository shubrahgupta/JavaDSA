package DSA.arrayString;

import java.util.ArrayList;
import java.util.Arrays;

public class revVowel {
    public static void main(String[] args) {
        String s = ".,(";
        revVowel rev = new revVowel();
        String ans = rev.reverseVowels(s);
        System.out.println(ans);
    }
//    public String reverseVowels(String s) {
//        StringBuilder s1 = new StringBuilder(s);
//        ArrayList<Character> ch = new ArrayList<>();
//        ArrayList<String> vow = new ArrayList<>(Arrays.asList("a","e","i","o","u"));
//        ArrayList<Integer> indexes = new ArrayList<>();
//        for(int i = 0; i < s1.length(); i++) {
//            char c = s1.charAt(i);
//            String x = "" + c;
//            x = x.toLowerCase();
//            if (vow.contains(x)) {
//                ch.add(s1.charAt(i));
//                indexes.add(i);
//            }
//        }
//        Collections.reverse(ch);
//        for(int i = 0; i < ch.size(); i++) {
//            s1.setCharAt(indexes.get(i),ch.get(i));
//        }
//        return s1.toString();
//
//    }
    public String reverseVowels(String s) {
        int i = 0, j = s.length()-1;
        StringBuilder s1 = new StringBuilder(s);
        System.out.println("sss: " + s);
        ArrayList<Character> vow = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        while(i<j) {
            while ((!vow.contains(s1.charAt(i))) && (i < j)) {
                i++;
//                System.out.println(s1.charAt(i) + " " + i + " " + j);
            }
            while ((!vow.contains(s1.charAt(j))) && (i < j)) {
                j--;
//                System.out.println(s1.charAt(i) + " " + i + " " + j);
            }
//            System.out.println(i + " " + j);
            if ((i > j) || (i >= s.length()) || (j<0))  break;
            char first = s1.charAt(j), second = s1.charAt(i);
//            System.out.println(second + " " + i + " " + j + " " + first);
            s1.setCharAt(i,first);s1.setCharAt(j,second);
            i++; j--;

        }
        return s1.toString();
    }
}
