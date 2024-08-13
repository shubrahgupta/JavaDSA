package DSA.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class maxVowelsQ {
    public static void main(String[] args) {
        maxVowelsQ mv = new maxVowelsQ();
        String s = "leetcode";
        int k = 3;
        int ans = mv.maxVowels(s,k);
        System.out.println(ans);
    }
    public int maxVowels(String s, int k) {
        ArrayList<Character> vowels = new ArrayList<> (Arrays.asList('a','e','i','o','u'));
        int i = 0, j = k-1, maxVowelCount = 0;
        for(int l = i; l <= j; l++) {
            if (vowels.contains(s.charAt(l))) maxVowelCount += 1;
        }
        int VowelCount = maxVowelCount;
        while(j < s.length()-1) {

            j++;
            if (vowels.contains(s.charAt(j))) VowelCount += 1;
            if (vowels.contains(s.charAt(i))) VowelCount -= 1;
            i++;
            maxVowelCount = Math.max(maxVowelCount, VowelCount);

        }
        return maxVowelCount;
    }
}
