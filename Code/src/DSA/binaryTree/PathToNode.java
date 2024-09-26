package DSA.binaryTree;


import java.util.ArrayList;
import java.util.List;

public class PathToNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
//        PathToNode q = new PathToNode();
        System.out.println(Paths(root));
    }

    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        List<TreeNode> leafNodes = new ArrayList<>();
        PathToNode q = new PathToNode();
        q.preOrderNormal(root, leafNodes);
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        for(TreeNode i: leafNodes) {
            pathList.add(q.solve(root, i.val));
        }
        return pathList;
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        //path to a node from root
        ArrayList<Integer> path = new ArrayList<>();
        preOrder(A, path, B);
        return path;
    }
    public boolean preOrder(TreeNode root, ArrayList<Integer> path, int B) {
        if (root == null)   return false;
        path.add(root.val);
//        System.out.println(path);
        if (root.val == B)  return true;
        boolean left = preOrder(root.left, path, B);
        boolean right = preOrder(root.right, path, B);

        if (!(left || right)) {
            path.remove(path.size()-1);
        }
        return left || right;

    }

    public void preOrderNormal(TreeNode root, List<TreeNode> leafNodes) {
        if (root == null)   return;
        if (root.left == null && (root.right == null))  leafNodes.add(root);
        preOrderNormal(root.left, leafNodes);
        preOrderNormal(root.right, leafNodes);

    }



}
