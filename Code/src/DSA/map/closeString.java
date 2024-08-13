package DSA.map;

import java.util.*;

public class closeString {
    public static void main(String[] args) {
        String word1 = "cabbba", word2 = "abbccc";
        closeString cs = new closeString();
        System.out.println(cs.closeStrings(word1, word2));
    }
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for(int i = 0; i < word1.length(); i++) {
            char k = word1.charAt(i);
            if (m1.containsKey(k))    m1.put(k,m1.get(k)+1);
            else m1.put(k, 1);
        }
        for(int i = 0; i < word2.length(); i++) {
            char k = word2.charAt(i);
            if (m2.containsKey(k))    m2.put(k,m2.get(k)+1);
            else m2.put(k, 1);
        }
        if (m1.equals(m2)) return true;

//        int wm1 = 1, wm2 = 1;
//        for(int i: m1.values()) {
//            wm1 *= i;
//        }
//        for(int i: m2.values()) {
//            wm2 *= i;
//        }
//        System.out.println(m1.values());
//        System.out.println(m2.values());
        ArrayList<Integer> l1 = new ArrayList<>(m1.values());
        ArrayList<Integer> l2 = new ArrayList<>(m2.values());
        Collections.sort(l1);Collections.sort(l2);
        if (l1.equals(l2) && (m1.keySet().equals(m2.keySet()))) {
            return true;
        }
        return false;

    }
}
