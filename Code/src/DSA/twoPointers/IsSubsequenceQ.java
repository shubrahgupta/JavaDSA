package DSA.twoPointers;

public class IsSubsequenceQ {
    public static void main(String[] args) {
        String s = "ahx", t = "ahbgdc";
        IsSubsequenceQ isq = new IsSubsequenceQ();
        System.out.println(isq.isSubsequence(s,t));
    }
    public boolean isSubsequence(String s, String t) {
        int tp = 0, sp = 0, count = 0;
        while((sp < s.length()) && (tp < t.length())) {
            if ((s.charAt(sp) == t.charAt(tp)) && (sp <= s.length()-1)) {
//                System.out.println(sp + " " + s.charAt(sp));
//                System.out.println(tp + " " + t.charAt(tp));
                sp++;tp++;count++;
            }
            else if(s.charAt(sp) != t.charAt(tp) && (sp <= s.length()-1)) {
                tp++;
            }
            else {
                break;
            }
        }
        System.out.println(count);
        return count == s.length();

    }
}
