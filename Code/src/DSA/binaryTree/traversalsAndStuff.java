package DSA.binaryTree;


import java.sql.SQLOutput;
import java.util.*;

class NodeNum {

    Node node;
    int num;

    public NodeNum(Node node, int num) {
        this.node = node;
        this.num = num;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class traversalsAndStuff {
    public void preorder_recursion(Node root) {
        if(root == null)    return;
        System.out.print(root.getData() + " ");
        preorder_recursion(root.getLeft());
        preorder_recursion(root.getRight());
    }
    public void inorder_recursion(Node root) {
        if(root == null)    return;

        inorder_recursion(root.getLeft());
        System.out.print(root.getData() + " ");
        inorder_recursion(root.getRight());
    }
    public void postorder_recursion(Node root) {
        if(root == null)    return;

        postorder_recursion(root.getLeft());
        postorder_recursion(root.getRight());
        System.out.print(root.getData() + " ");
    }
    public List<List<Node>> level_order_traversal(Node root) {
        List<List<Node>> levelOrderNodes = new ArrayList<>();
        if (root == null) return levelOrderNodes;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Node> nodeListOnLevel = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node element = queue.poll();

                nodeListOnLevel.add(element);
            }
            for(int i = 0; i < nodeListOnLevel.size(); i++) {
                if (nodeListOnLevel.get(i).getLeft() != null) {
                    queue.add(nodeListOnLevel.get(i).getLeft());
                }
                if (nodeListOnLevel.get(i).getRight() != null) {
                    queue.add(nodeListOnLevel.get(i).getRight());
                }
            }
            levelOrderNodes.add(nodeListOnLevel);

        }
        return levelOrderNodes;

    }
    public void preorder_iterative(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root == null) return;
        stack.add(root);
        while(!stack.isEmpty()) {
            Node top = stack.pop();
            if (top.getRight() != null) stack.add(top.getRight());
            if (top.getLeft() != null) stack.add(top.getLeft());
            System.out.print(" " + top.getData() + " ");
        }
    }
    public void inorder_iterative(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root == null) return;

        while(true) {
            if (root != null) {
                stack.add(root);
                root = root.getLeft();
            }
            else {
                if (stack.isEmpty()){
                    break;
                }
                root = stack.pop();
                System.out.print(" " + root.getData());
                root = root.getRight();
            }
        }
    }
    public void postOrderIterative2Stack(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        if (root == null) return;
        st1.add(root);
        while(!st1.isEmpty()) {
            Node top = st1.pop();
            st2.add(top);
            if (top.getLeft() != null) st1.add(top.getLeft());
            if (top.getRight() != null) st1.add(top.getRight());
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop().getData() + " ");
        }
        System.out.println();


    }

    public void postOrderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root == null) return;
        Node curr = root;
        while(curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.getLeft();
            }
            else {
                Node temp = stack.peek().getRight();
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.getData() + " ");
                    while(!stack.isEmpty() && temp == stack.peek().getRight()) {
                        temp = stack.pop();
                        System.out.print(temp.getData() + " ");
                    }

                }
                else {
                    curr = temp;
                }
            }
        }

    }
    public void preInPostTogether(Node root) {
        Stack<NodeNum> stack = new Stack<>();
        stack.add(new NodeNum(root, 1));
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();

        while(!stack.isEmpty()) {
            if (stack.peek().getNum() == 1) {
                stack.peek().setNum(stack.peek().getNum()+1);
                preOrderList.add(stack.peek().getNode().getData());
                if (stack.peek().getNode().getLeft() != null) {
                    stack.add(new NodeNum(stack.peek().getNode().getLeft(), 1));
                }
            }
            else if (stack.peek().getNum() == 2) {
                stack.peek().setNum(stack.peek().getNum()+1);
                inOrderList.add(stack.peek().getNode().getData());
                if (stack.peek().getNode().getRight() != null) {
                    stack.add(new NodeNum(stack.peek().getNode().getRight(), 1));
                }
            }
            else if (stack.peek().getNum() == 3) {
                postOrderList.add(stack.peek().getNode().getData());
                stack.pop();

            }

        }
        System.out.println(preOrderList);
        System.out.println(inOrderList);
        System.out.println(postOrderList);


    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));
        root.getLeft().getRight().setLeft(new Node(8));
        root.getRight().getRight().setLeft(new Node(9));
        root.getRight().getRight().setRight(new Node(10));

        traversalsAndStuff q = new traversalsAndStuff();
        System.out.println("Inorder");
        q.inorder_recursion(root);
        System.out.println("\nPreorder");
        q.preorder_recursion(root);
        System.out.println("\nPostorder");
        q.postorder_recursion(root);
        System.out.println("\nLevelOrder");
        System.out.println(q.level_order_traversal(root));
        System.out.println("\nPreorder");
        q.preorder_iterative(root);
        System.out.println("\nInorder");
        q.inorder_iterative(root);
        System.out.println("\nPostorder using 2 stack");
        q.postOrderIterative2Stack(root);
        System.out.println("\nPostorder using 1 stack");
        q.postOrderIterative(root);
        System.out.println("\nEverything together");
        q.preInPostTogether(root);


    }

}
