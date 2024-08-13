package DSA.stack;

import java.util.*;

public class asteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {8,-8};
        asteroidCollision q = new asteroidCollision();
        int[] ans = q.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ans));
    }
    public Stack<Integer> stackOperation(Stack<Integer> st) {
        if (st.size() == 1) {
            return st;
        }

        boolean flag = false;
        while(!flag && st.size() >= 2) {
            int x = st.pop();
            int top = st.peek();
            if (x < 0  && top > 0) {
                st.pop();
                if (Math.abs(x) < Math.abs(top)) st.push(top);
                else if (Math.abs(x) > Math.abs(top)) st.push(x);
            }
            else {
                st.push(x);
                flag = true;
            }
        }
        return st;
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i: asteroids) {
            st.push(i);
            st = stackOperation(st);
        }
        ArrayList<Integer> ans = new ArrayList<>(st);
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
