package DSA.binaryTree;

import java.util.ArrayList;

public class LCA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        LCA q = new LCA();
        TreeNode ans = q.lowestCommonAncestor(root, root.right.right, root.right.left);
        System.out.println(ans.val);
        ans = q.lowestCommonAncestor(root, root.right.right, root.right);
        System.out.println(ans.val);
        ans = q.lowestCommonAncestor(root, root.right.right, root);
        System.out.println(ans.val);
        ans = q.lowestCommonAncestor(root, root.right.right, root.left.left);
        System.out.println(ans.val);

    }
    public void printNodeList(ArrayList<TreeNode> path) {
        System.out.println();
        for(TreeNode i: path) {
            System.out.print(i.val + " ");
        }
        System.out.println();
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> pPath = solve(root, p);
        ArrayList<TreeNode> qPath = solve(root, q);
        printNodeList(pPath);
        printNodeList(qPath);
        int pIndex = 0, qIndex = 0;
        while(true) {
            if (pIndex == pPath.size()) {
                return pPath.get(pIndex-1);
            }
            if (qIndex == qPath.size()) {
                return qPath.get(qIndex-1);
            }
            if (pPath.get(pIndex) != qPath.get(qIndex)) {
                return qPath.get(qIndex-1);
            }
            pIndex++;
            qIndex++;
        }


    }
    public ArrayList<TreeNode> solve(TreeNode A, TreeNode B) {
        //path to a node from root
        ArrayList<TreeNode> path = new ArrayList<>();
        preOrder(A, path, B);
        return path;
    }
    public boolean preOrder(TreeNode root, ArrayList<TreeNode> path, TreeNode B) {
        if (root == null)   return false;
        path.add(root);
//        System.out.println(path);
        if (root == B)  return true;
        boolean left = preOrder(root.left, path, B);
        boolean right = preOrder(root.right, path, B);

        if (!(left || right)) {
            path.remove(path.size()-1);
        }
        return left || right;

    }
}
