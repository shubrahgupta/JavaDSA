package DSA.arrayString;

public class alt_word_merge {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String word1 = "ab", word2 = "pqrs";
        System.out.println(s.mergeAlternately(word1, word2));
    }
}
class Solution1 {
    public String mergeAlternately(String word1, String word2) {

        int diff = Math.abs(word1.length() - word2.length());
        int smaller_length = Math.min(word1.length(), word2.length());
        String larger_string = "";
        if (word1.length() > word2.length())    larger_string = word1;
        else larger_string = word2;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < smaller_length; i++) {
            s.append(word1.charAt(i));
            s.append(word2.charAt(i));
        }
        for(int i = 0; i < diff; i++) {
            s.append(larger_string.charAt(i+smaller_length));
        }
        return s.toString();
    }
}
