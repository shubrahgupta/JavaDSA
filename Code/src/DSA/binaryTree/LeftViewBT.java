package DSA.binaryTree;

import java.util.*;

class NodeCoordinates2 {
    Node node;
    int x; int y;

    public NodeCoordinates2(Node node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
public class LeftViewBT {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.right.left.right = new Node(14);

        LeftViewBT q = new LeftViewBT();
        System.out.println(q.leftView(root));



    }
    ArrayList<Integer> leftView(Node root)
    {
        Queue<NodeCoordinates2> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)   return ans;
        q.add(new NodeCoordinates2(root, 0 ,0));
        while(!q.isEmpty()) {
            int size = q.size();
            List<NodeCoordinates2> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                NodeCoordinates2 NodeCoordinates2 = q.poll();
                level.add(NodeCoordinates2);
                if (i == 0) {
                    ans.add(NodeCoordinates2.node.data);
                }
            }

            for(NodeCoordinates2 NodeCoordinates2: level) {
                if (NodeCoordinates2.node.left != null)
                    q.add(new NodeCoordinates2(NodeCoordinates2.node.left, NodeCoordinates2.x - 1, NodeCoordinates2.y + 1));
                if (NodeCoordinates2.node.right != null)
                    q.add(new NodeCoordinates2(NodeCoordinates2.node.right, NodeCoordinates2.x + 1, NodeCoordinates2.y + 1));

            }
        }
        return ans;
    }

    public ArrayList<Integer> traversal(Node root) {
        Queue<NodeCoordinates2> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)   return ans;
        q.add(new NodeCoordinates2(root, 0 ,0));
        while(!q.isEmpty()) {
            int size = q.size();
            List<NodeCoordinates2> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                NodeCoordinates2 NodeCoordinates2 = q.poll();
                level.add(NodeCoordinates2);
                if (i == 0) {
                    ans.add(NodeCoordinates2.node.data);
                }
            }

            for(NodeCoordinates2 NodeCoordinates2: level) {
                if (NodeCoordinates2.node.left != null)
                    q.add(new NodeCoordinates2(NodeCoordinates2.node.left, NodeCoordinates2.x - 1, NodeCoordinates2.y + 1));
                if (NodeCoordinates2.node.right != null)
                    q.add(new NodeCoordinates2(NodeCoordinates2.node.right, NodeCoordinates2.x + 1, NodeCoordinates2.y + 1));

            }
        }
        return ans;
    }

}
