package DSA.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class SymmetricBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricBT q = new SymmetricBT();
        System.out.println(q.isSymmetric(root));
    }
//    public boolean isSymmetric(TreeNode root) {
//        List<Integer> listLeft = new ArrayList<>();
//        List<Integer> listRight = new ArrayList<>();
//
//        preOrderMirrorLeft(root, listLeft);
//        preOrderMirrorRight(root, listRight);
//        System.out.println(listLeft);
//        System.out.println(listRight);
//
//        return listLeft.equals(listRight);
//    }
//    public void preOrderMirrorLeft(TreeNode root, List<Integer> list) {
//        if (root == null) {list.add(Integer.MIN_VALUE); return;}
//        list.add(root.val);
//        preOrderMirrorLeft(root.left, list);
//        preOrderMirrorLeft(root.right, list);
//
//    }
//    public void preOrderMirrorRight(TreeNode root, List<Integer> list) {
//        if (root == null) {list.add(Integer.MIN_VALUE); return;}
//        list.add(root.val);
//        preOrderMirrorRight(root.right, list);
//        preOrderMirrorRight(root.left, list);
//
//    }
    public boolean isSymmetric(TreeNode root) {
        return preOrder(root, root);
    }
    public boolean preOrder(TreeNode rootLeft, TreeNode rootRight) {

        if (rootLeft == null && rootRight == null) {return true;}
        if (rootLeft == null || rootRight == null)  {return false;}
        if (rootLeft.val != rootRight.val)  {return false;}
        System.out.println(rootLeft.val + " " + rootRight.val);
        return preOrder(rootLeft.left, rootRight.right) && preOrder(rootLeft.right, rootRight.left);




    }


}
