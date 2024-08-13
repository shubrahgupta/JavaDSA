package DSA.recursion;

import java.util.Stack;

public class rev_stack{
    private void printStack(Stack<Integer> arr) {
        for(int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    private void reversal(Stack<Integer> st) {
        if (st.size() == 1) {
            return;
        }
        int t = st.pop();
        reversal(st);
        insertion(st,t);
    }
    private void insertion(Stack<Integer> st, int ins) {
        if (st.empty()) {
            st.push(ins);
            return;
        }

        int t = st.pop();
        insertion(st,ins);
        st.push(t);


    }




    public static void main(String[] args) {
        Stack<Integer> arr = new Stack<>();
        arr.push(10);
        arr.push(20);
        arr.push(30);
        arr.push(40);
        arr.push(50);

        rev_stack s = new rev_stack();
        s.printStack(arr);
        s.reversal(arr);
        s.printStack(arr);


    }

}

