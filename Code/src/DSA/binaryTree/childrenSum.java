package DSA.binaryTree;

public class childrenSum {
//    static int ans = 1;
//    static boolean flag = true;
//    public static int isSumProperty(Node root)
//    {
//        // add your code here
//
//
//        preorder(root);
//        return ans;
//
//    }
//    public static void preorder(Node root) {
//        if (root == null || !flag) return;
//        int leftval = 0, rightval = 0;
//        if(root.left == null && root.right == null) return;
//        if (root.left != null) {
//            leftval = root.left.data;
//
//        }
//        if (root.right != null) {
//            rightval = root.right.data;
//
//        }
//        if (leftval + rightval != root.data) {
//            ans = 0; flag = false;
//            return;
//        }
//        preorder(root.left);
//        preorder(root.right);
//    }
    static boolean flag = true;
    public static int isSumProperty(Node root)
    {
        // add your code here
        flag = true;
        preorder(root);

        return (flag)?1:0;

    }
    public static boolean check(Node root) {
        if (root == null)   return true;
        if(root.left == null && root.right == null) {
            return true;
        }
        int l = 0, r = 0;
        if (root.left != null) {
            l = root.left.data;
        }
        if (root.right != null) {
            r = root.right.data;
        }


        if(l + r == root.data)  return true;
        else return false;
    }

    public static void preorder(Node root) {
        if (root == null) return;
        if (!check(root)) {
            flag = false;
            return;
        }
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.setLeft(new Node(4));
        root.setRight(new Node(6));
        root.left.setLeft(new Node());
        root.left.setRight(new Node());
        root.setRight(new Node(6));
        root.right.setLeft(new Node());
        root.right.setRight(new Node());

//        root.setRight(new Node(6));
//        root.getLeft().setLeft(new Node(4));
//        root.getLeft().setRight(new Node(5));
//        root.getRight().setLeft(new Node(6));
//        root.getRight().setRight(new Node(7));
//        root.getLeft().getRight().setLeft(new Node(8));
//        root.getRight().getRight().setLeft(new Node(9));
//        root.getRight().getRight().setRight(new Node(10));
        System.out.println(isSumProperty(root));
    }
}
