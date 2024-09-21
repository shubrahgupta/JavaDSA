package DSA.binaryTree;

public class maxDepth {

    public int findMaxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findMaxDepth(root.getLeft()), findMaxDepth(root.getRight()));
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
        maxDepth q = new maxDepth();
        System.out.println(q.findMaxDepth(root));
    }
}
