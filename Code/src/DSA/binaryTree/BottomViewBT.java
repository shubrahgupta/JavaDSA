package DSA.binaryTree;

import java.util.*;

class NodeCoordinates {
    Node node;
    int x; int y;

    public NodeCoordinates(Node node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
public class BottomViewBT {
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

        BottomViewBT q = new BottomViewBT();
        System.out.println(q.bottomView(root));



    }


    public ArrayList<Integer> bottomView(Node root)
    {
        TreeMap<Integer, List<Node>> t = traversal(root);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: t.keySet()) {
            ans.add(t.get(i).get(t.get(i).size()-1).data);
        }
        return ans;
    }
    public TreeMap<Integer, List<Node>> traversal(Node root) {
        Queue<NodeCoordinates> q = new LinkedList<>();
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        if (root == null)   return map;
        q.add(new NodeCoordinates(root, 0 ,0));
        while(!q.isEmpty()) {
            int size = q.size();
            List<NodeCoordinates> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                NodeCoordinates nodeCoordinates = q.poll();
                level.add(nodeCoordinates);
            }

            for(NodeCoordinates nodeCoordinates: level) {
                if (nodeCoordinates.node.left != null)
                    q.add(new NodeCoordinates(nodeCoordinates.node.left, nodeCoordinates.x - 1, nodeCoordinates.y + 1));
                if (nodeCoordinates.node.right != null)
                    q.add(new NodeCoordinates(nodeCoordinates.node.right, nodeCoordinates.x + 1, nodeCoordinates.y + 1));
                if (!map.containsKey(nodeCoordinates.x)) {
                    map.put(nodeCoordinates.x, new ArrayList<>(List.of(nodeCoordinates.node)));
                } else {
                    map.get(nodeCoordinates.x).add(nodeCoordinates.node);
                }
            }
        }
        return map;
    }

}
