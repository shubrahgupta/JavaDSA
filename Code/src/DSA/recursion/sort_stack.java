package DSA.recursion;

import java.util.Stack;

public class sort_stack {
    private void printStack(Stack<Integer> arr) {
        for(int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    private void sortStack(Stack<Integer> arr) {
        if (arr.size() == 1) {
            return;
        }
        int last = arr.peek();
        arr.pop();
        sortStack(arr);
        insertion(arr, last);

    }
    private void insertion(Stack<Integer> arr, int x) {
        if (arr.empty()) {
            arr.push(x);
            return;
        }

        int last = arr.peek();

        if (last < x) {
            arr.pop();
            insertion(arr, x);
            arr.push(last);
        }
        else {
            arr.push(x);
        }


    }

    public static void main(String[] args) {
        Stack<Integer> arr = new Stack<>();
        arr.push(1);
        arr.push(5);
        arr.push(0);
        arr.push(2);

        sort_stack s = new sort_stack();
        s.printStack(arr);
        s.sortStack(arr);
        s.printStack(arr);


    }

}
