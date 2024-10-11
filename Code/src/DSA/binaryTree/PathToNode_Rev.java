package DSA.binaryTree;

import java.util.ArrayList;

public class PathToNode_Rev {
    ArrayList<Integer> gArr;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        PathToNode_Rev q = new PathToNode_Rev();
        System.out.println(q.solve(root, 6));
    }

    public ArrayList<Integer> solve(TreeNode root, int B) {
        gArr = new ArrayList<>();
        preorder(root, gArr, B);
        return gArr;
    }
    public boolean preorder(TreeNode root, ArrayList<Integer> arr, int B) {
        if (root == null)   return false;
        arr.add(root.val);
        if (root.val == B)  return true;
        boolean lp = preorder(root.left, arr, B);
        boolean rp = preorder(root.right, arr, B);
        if (!(lp || rp))    arr.remove(arr.size()-1);
        return lp || rp;
    }
}
