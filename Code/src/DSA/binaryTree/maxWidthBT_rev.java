package DSA.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNodeIndex {
    int index;
    TreeNode node;

    public TreeNodeIndex(TreeNode node, int index) {
        this.index = index;
        this.node = node;
    }
}

public class maxWidthBT_rev {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = Integer.MIN_VALUE;
        Queue<TreeNodeIndex> queue = new LinkedList<>();
        queue.add(new TreeNodeIndex(root, 0));
        while(!queue.isEmpty()) {
            List<TreeNodeIndex> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNodeIndex t = queue.poll();
                list.add(t);
            }
            for(int i = 0; i < list.size(); i++) {
                list.get(i).index -= size;
            }

            for(TreeNodeIndex t: list) {
                if (t.node.left != null)
                    queue.add(new TreeNodeIndex(t.node.left, 2*t.index+1));
                if (t.node.right != null)
                    queue.add(new TreeNodeIndex(t.node.right, 2*t.index+2));
            }

            maxWidth = Math.max(maxWidth, list.get(list.size()-1).index - list.get(0).index);

        }
        return maxWidth+1;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        maxWidthBT_rev q = new maxWidthBT_rev();
        System.out.println(q.widthOfBinaryTree(root));

    }
}
