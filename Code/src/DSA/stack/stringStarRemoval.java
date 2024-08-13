package DSA.stack;
import java.util.*;

public class stringStarRemoval {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        stringStarRemoval q = new stringStarRemoval();
        String ans = q.removeStars(s);
        System.out.println(ans);
    }
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        int count = 0;
        while(!st.isEmpty()) {
            char top = st.peek();
//            System.out.println(top);

            if (top != '*' && count == 0) {
                ans.append(top);

            }
            else if (top == '*') {
                count++;

            }
            else {

                count--;
            }
            st.pop();
        }
        ans.reverse();
        return ans.toString();
    }
}
