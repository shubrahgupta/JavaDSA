package DSA.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNodeIndexed {
    TreeNode node;
    int index;

    public TreeNodeIndexed(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }

}
public class maxWidthBT {
    public static void main(String[] args) {

    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<TreeNodeIndexed> queue = new LinkedList<>();
        queue.add(new TreeNodeIndexed(root, 0));
        while(!queue.isEmpty()) {

            List<TreeNodeIndexed> treeNodeIndexedList = new ArrayList<>();
            int qsize = queue.size();
            for(int i = 0; i < qsize; i++) {
                TreeNodeIndexed treeNodeIndexed = queue.poll();

                treeNodeIndexedList.add(treeNodeIndexed);

            }
            maxWidth = Math.max(maxWidth, treeNodeIndexedList.get(qsize-1).index - treeNodeIndexedList.get(0).index);
            for(TreeNodeIndexed i: treeNodeIndexedList) {
                if (i.node.left != null) {
                    queue.add(new TreeNodeIndexed(i.node.left, (2 * i.index )+ 1));
                }
                if (i.node.right != null) {
                    queue.add(new TreeNodeIndexed(i.node.right, (2 * i.index )+ 2));
                }
            }



        }
        return maxWidth;

    }


}
