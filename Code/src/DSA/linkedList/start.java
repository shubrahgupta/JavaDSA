package DSA.linkedList;

import java.util.ArrayList;

class Node {
    int data;
    Node next = null;
    Node(int data) {
        this.data = data;
    }
}
public class start {
    private void printLinkedList(Node head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
    private Node insertNode(Node head, int value, int pos) {
        if (head == null) {
            head = new Node(value);
            return head;
        }
        else if(pos == 0) {
            Node n = new Node(value);
            n.next = head;
            head = n;
            return head;
        }
        int count = 1;
        Node latest = head;
        while(head.next != null && (count+1 < pos)) {
            count++;
            head = head.next;
        }
        if (head.next == null && (count+1 < pos)) {
            head.next = new Node(value);
            return latest;
        }
        Node n = new Node(value);
        n.next = head.next;
        head.next = n;
        return latest;





    }

    private Node deleteNode(Node head, int pos) {
        if (head == null) {
            return null;
        }
        else if(pos == 1) {

            head = head.next;
            return head;
        }
        int count = 1;
        Node latest = head;
        while(head.next != null && (count+1 < pos)) {
            count++;
            head = head.next;
        }
        if (head.next == null && (count+1 < pos)) {
            return latest;
        }

        head.next = head.next.next;
        return latest;





    }

    private Node arraytolinkedlist(ArrayList<Integer> arr) {
        if (arr.isEmpty()) {
            return null;
        }
        Node head = new Node(arr.get(0));
        Node latest = head;
        for(int i: arr) {
            Node n = new Node(i);
            if (latest.data != n.data) {
                latest.next = n;
                latest = n;
            }
        }


        return head;

    }

    public static void main(String[] args) {


        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        start s = new start();
        Node head = s.arraytolinkedlist(arr);

//        s.printLinkedList(head);

        head = s.deleteNode(head, 1);
        s.printLinkedList(head);



    }
}
