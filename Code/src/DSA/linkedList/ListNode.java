package DSA.linkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    private ListNode arrayToLinkedList(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(arr.get(0));
        ListNode latest = head;
        for(int i: arr) {
            ListNode n = new ListNode(i);
            if (latest.val != n.val) {
                latest.next = n;
                latest = n;
            }
        }


        return head;

    }

    private ListNode arrayToLinkedListWithCycle(ArrayList<Integer> arr, int pos) {
        if (arr.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(arr.get(0));
        ListNode latest = head;
        for(int i: arr) {
            ListNode n = new ListNode(i);
            if (latest.val != n.val) {
                latest.next = n;
                latest = n;
            }
        }
        ListNode head1 = head;
        if (pos == -1) {
            return head;
        }
        while(pos != 0) {
            head1 = head1.next;
            pos--;
        }
        latest.next = head1;


        return head;

    }

    private void printLinkedList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(); ListNode h1 = l1; ListNode h2 = l2;

        ListNode h3 = l3; l3.val = (h1.val + h2.val) % 10; carry = (h1.val + h2.val) / 10;
        h1 = h1.next; h2 = h2.next;
        ListNode head;
        while(h1 != null && h2 != null) {

            int v = h1.val + h2.val + carry;
            carry = v/10; int st = v%10;
            head = new ListNode(st);

            h3.next = head;
            h1 = h1.next;
            h2 = h2.next;
            h3 = h3.next;

        }
        while (h1 == null && (h2 != null)) {
            int v = h2.val + carry;
            carry = v/10; int st = v%10;
            head = new ListNode(st);

            h3.next = head;
            h2 = h2.next;
            h3 = h3.next;
        }
        while (h1 != null && (h2 == null)) {
            int v = h1.val + carry;
            carry = v/10; int st = v%10;
            head = new ListNode(st);

            h3.next = head;
            h1 = h1.next;
            h3 = h3.next;
        }

        if (carry != 0) h3.next = new ListNode(carry);



        return l3;

    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (slow == null) {
            return false;
        }
        else if (slow.next == null) {
            return false;
        }


        while(slow != null && fast.next != null && (slow == head || slow != fast)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            return false;
        }
        else if (fast.next == null) {
            return false;
        }
        return true;
    }
    public ListNode reverseLL(ListNode head) {
        if (head != null) {
            ListNode prev = null, temp = head;
            while(temp!=null) {
                ListNode front = temp.next;
                temp.next = prev;
                prev = temp;
                temp = front;

            }
            return prev;
        }
        return null;

    }

    public static void main(String[] args) {
        ArrayList<Integer> a_l1 = new ArrayList<>(Arrays.asList(3,2,0,-4));
        int pos_l1 = 1;
        ArrayList<Integer> a_l2 = new ArrayList<>(Arrays.asList(1,2));
        int pos_l2 = 0;
        ArrayList<Integer> a_l3 = new ArrayList<>(Arrays.asList(1));
        int pos_l3 = -1;
        Solution s = new Solution();
//        ListNode l1 = s.arrayToLinkedListWithCycle(a_l1, pos_l1);
//
//        ListNode l2 = s.arrayToLinkedListWithCycle(a_l2, pos_l2);
//        ListNode l3 = s.arrayToLinkedListWithCycle(a_l3, pos_l3);

        //        ListNode head = s.addTwoNumbers(l1,l2);
//        s.printLinkedList(l3);
//        System.out.println(s.hasCycle(l1) + "l1");
//        System.out.println(s.hasCycle(l2) + "l2");
//        System.out.println(s.hasCycle(l3) + "l3");
        ListNode head = s.arrayToLinkedList(a_l1);
        head = s.reverseLL(head);
        s.printLinkedList(head);




    }
}

