package DSA.arrayString;

import java.util.*;

public class gcdString {
    public static void main(String[] args) {
        String str1 = "LEET", str2 = "CODE";
        gcdString G = new gcdString();
        System.out.println(G.gcdOfStrings(str1, str2));

    }
//    public static int gcd(int a, int b) {
//        if (b == 0) {
//            return a;
//        } else {
//            return gcd(b, a % b);
//        }
//    }

    public String setToString(Set<Character> s) {
        Iterator<Character> it = s.iterator();
        StringBuilder s1 = new StringBuilder();
        while(it.hasNext()) {
            s1.append(it.next());
        }
        return s1.toString();

    }
    public String gcdOfStrings(String str1, String str2) {
        String smallerString = (str1.length() <= str2.length()) ? str1 : str2;
        String largerString = (str1.length() > str2.length()) ? str1 : str2;

        String nn = smallerString;
        for (int i = 0; i < smallerString.length(); i++) {

            String sL_rep = largerString.replaceAll(nn, "");
            String sS_rep = smallerString.replaceAll(nn, "");
            if (sL_rep.isEmpty() && sS_rep.isEmpty()) {
                return nn;
            }
//            System.out.println("before" + nn);
            nn = nn.substring(0,nn.length()-1);
//            System.out.println("after" + nn);
        }
        return nn;
    }
}

