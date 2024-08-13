package DSA.recursion;

import java.util.Stack;

public class remove_mid_stack {
    private void printStack(Stack<Integer> arr) {
        for(int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    private void removeMidStack(Stack<Integer> st, int k) {
        if (k == 1) {
            st.pop();
            return;
        }
        int last = st.pop();
        removeMidStack(st, k-1);
        st.push(last);

    }
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        if (sizeOfStack % 2 == 0)
            removeMidStack(s, ((sizeOfStack + 1) / 2) + 1);
        else
            removeMidStack(s, ((sizeOfStack + 1) / 2));
    }


    public static void main(String[] args) {
        Stack<Integer> arr = new Stack<>();
        arr.push(10);
        arr.push(20);
        arr.push(30);
        arr.push(40);
        arr.push(50);

        remove_mid_stack s = new remove_mid_stack();
        s.printStack(arr);
        s.deleteMid(arr, arr.size());
        s.printStack(arr);


    }

}
