package DSA.binaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class TreeNodeCoordinates {
    TreeNode TreeNode;
    int x;
    int y;
    public TreeNodeCoordinates(TreeNode TreeNode, int x, int y) {
        this.TreeNode = TreeNode;
        this.x = x;
        this.y = y;
    }
    public TreeNode getTreeNode() {
        return TreeNode;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setTreeNode(TreeNode TreeNode) {
        this.TreeNode = TreeNode;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class TreeNodeCoordinateComparator implements Comparator<TreeNodeCoordinates> {

    @Override
    public int compare(TreeNodeCoordinates o1, TreeNodeCoordinates o2) {
        if((o1.getX() == o2.getX()) && (o1.getY() == o2.getY()))
            return o1.getTreeNode().val-o2.getTreeNode().val;
        else if ((o1.getX() == o2.getX()))
            return o1.getY()-o2.getY();
        else
            return o1.getX()-o2.getX();
    }
}


public class VerticalOrderTraversal_copy {
    int maxWidth = Integer.MIN_VALUE;
    int minWidth = Integer.MAX_VALUE;
    int levels = 0;
    List<List<Integer>> ans;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        VerticalOrderTraversal_copy q = new VerticalOrderTraversal_copy();
        q.verticalTraversal(root);



    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traversal(root, 0, 0);
        ans = new ArrayList<>();
        for(int i = minWidth; i <= maxWidth; i++) {
            ans.add(new ArrayList<>());
        }
        traversalTreeNodes(root, 0 , 0);
//        System.out.println(maxWidth);
//        System.out.println(minWidth);
//        System.out.println(levels);
        System.out.println(ans);
        return ans;
    }
    public void traversal(TreeNode root, int x, int y) {
        if (root == null) return;
        maxWidth = Math.max(maxWidth, x);
        minWidth = Math.min(minWidth, x);
        levels = Math.max(levels, y);
        traversal(root.left, x-1, y+1);
        traversal(root.right, x+1, y+1);
    }

    public void traversalTreeNodes(TreeNode root, int x, int y) {
        List<TreeNodeCoordinates> list = new ArrayList<>();

        Stack<TreeNodeCoordinates> stack = new Stack<>();
        stack.add(new TreeNodeCoordinates(root, x, y));
        while(!stack.isEmpty()) {
            TreeNodeCoordinates TreeNodeCoordinates = stack.pop();
            list.add(TreeNodeCoordinates);
            if (TreeNodeCoordinates.getTreeNode().right != null) {
                stack.add(new TreeNodeCoordinates(TreeNodeCoordinates.getTreeNode().right, TreeNodeCoordinates.getX()+1, TreeNodeCoordinates.getY()+1));
            }
            if (TreeNodeCoordinates.getTreeNode().left != null) {
                stack.add(new TreeNodeCoordinates(TreeNodeCoordinates.getTreeNode().left, TreeNodeCoordinates.getX()-1, TreeNodeCoordinates.getY()+1));
            }

        }
        list.sort(new TreeNodeCoordinateComparator());
        for(TreeNodeCoordinates i: list) {
            System.out.println(i.getTreeNode().val + " (" + i.getX() + ", " + i.getY() + ")");
        }
        List<List<TreeNodeCoordinates>> nodeList = new ArrayList<>();
        for(int i = minWidth; i <= maxWidth; i++) {
            nodeList.add(new ArrayList<>());
        }
        for(TreeNodeCoordinates i: list) {
            nodeList.get(i.getX() + Math.abs(minWidth)).add(i);

        }
        for(int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).sort(new TreeNodeCoordinateComparator());
            for(TreeNodeCoordinates node: nodeList.get(i))
                ans.get(i).add(node.getTreeNode().val);

        }

    }


}
