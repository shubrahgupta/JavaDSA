package DSA.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class sort_array {
    private void printArray(ArrayList<Integer> arr) {
        for(int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    private void sortArray(ArrayList<Integer> arr) {
        if (arr.size() == 1) {
            return;
        }
        int last = arr.getLast();
        arr.removeLast();
        sortArray(arr);
        insertion(arr, last);

    }
    private void insertion(ArrayList<Integer> arr, int x) {
        if (arr.isEmpty()) {
            arr.addLast(x);
            return;
        }

        int last = arr.getLast();
        if (last > x) {
            arr.removeLast();
            insertion(arr, x);
            arr.addLast(last);
        }
        else {
            arr.addLast(x);
        }


    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(
                Arrays.asList(1,5,0,2)
        );

        sort_array s = new sort_array();
        s.printArray(arr);
        s.sortArray(arr);
        s.printArray(arr);


    }

}
