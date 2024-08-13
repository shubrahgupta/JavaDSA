package DSA.arrayString;

import java.util.ArrayList;
import java.util.List;

public class greatestCandies {
    public static void main(String[] args) {

    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i: candies) {
            if (i >= max)   max = i;
        }
        List<Boolean> ll = new ArrayList<>();
        for(int i: candies) {
            if ((extraCandies + i) >= max) {
                ll.add(true);
            }
            else {
                ll.add(false);
            }
        }
        return ll;
    }
}
