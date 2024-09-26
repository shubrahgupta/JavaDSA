package DSA.binaryTree;

import java.util.*;

class NodeCoordinates1 {
    Node Node;
    int x;
    int y;
    public NodeCoordinates1(Node Node, int x, int y) {
        this.Node = Node;
        this.x = x;
        this.y = y;
    }
    public Node getNode() {
        return Node;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setNode(Node Node) {
        this.Node = Node;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}




public class TopViewBT_copy {
    int maxWidth = Integer.MIN_VALUE;
    int minWidth = Integer.MAX_VALUE;
    int levels = 0;
    static List<List<Integer>> ans;
    static List<Node> preOrder;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        TopViewBT_copy q = new TopViewBT_copy();
        q.verticalTraversal(root);
        System.out.println(topView(root));



    }
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> topView = new ArrayList<>();
        TopViewBT_copy q = new TopViewBT_copy();
        q.verticalTraversal(root);
        for(List<Integer> i: ans) {
            topView.add(i.get(0));
        }
        return topView;
    }
    public List<List<Integer>> verticalTraversal(Node root) {
//        traversal(root, 0, 0);
//
//        for(int i = minWidth; i <= maxWidth; i++) {
//            ans.add(new ArrayList<>());
//        }
        ans = new ArrayList<>();
        traversalNodes(root, 0 , 0);
//        System.out.println(maxWidth);
//        System.out.println(minWidth);
//        System.out.println(levels);
        System.out.println(ans);
        return ans;
    }
    public void traversal(Node root, int x, int y) {
        if (root == null) return;
        maxWidth = Math.max(maxWidth, x);
        minWidth = Math.min(minWidth, x);
        levels = Math.max(levels, y);
        traversal(root.left, x-1, y+1);
        traversal(root.right, x+1, y+1);
    }

    public void traversalNodes(Node root, int x, int y) {
        List<NodeCoordinates1> list = new ArrayList<>();
        preOrder = new ArrayList<>();

        Stack<NodeCoordinates1> stack = new Stack<>();
        stack.add(new NodeCoordinates1(root, x, y));
        while(!stack.isEmpty()) {
            NodeCoordinates1 NodeCoordinates1 = stack.pop();
            maxWidth = Math.max(maxWidth, NodeCoordinates1.getX());
            minWidth = Math.min(minWidth, NodeCoordinates1.getX());
            levels = Math.max(levels, NodeCoordinates1.getY());
            list.add(NodeCoordinates1);
            preOrder.add(NodeCoordinates1.getNode());
            if (NodeCoordinates1.getNode().right != null) {
                x = NodeCoordinates1.getX()+1;
                y = NodeCoordinates1.getY()+1;
                maxWidth = Math.max(maxWidth, x);
                minWidth = Math.min(minWidth, x);
                levels = Math.max(levels, y);
                stack.add(new NodeCoordinates1(NodeCoordinates1.getNode().right, x, y));
            }
            if (NodeCoordinates1.getNode().left != null) {
                x = NodeCoordinates1.getX()-1;
                y = NodeCoordinates1.getY()+1;
                maxWidth = Math.max(maxWidth, x);
                minWidth = Math.min(minWidth, x);
                levels = Math.max(levels, y);
                stack.add(new NodeCoordinates1(NodeCoordinates1.getNode().left, x, y));
            }

        }
//        Collections.sort(list, new Comparator<NodeCoordinates1>() {
//            @Override
//            public int compare(NodeCoordinates1 o1, NodeCoordinates1 o2) {
//                if((o1.getX() == o2.getX()) && (o1.getY() == o2.getY()))
//                    return preOrder.indexOf(o1.getNode())- preOrder.indexOf(o2.getNode());
//                else if ((o1.getX() == o2.getX()))
//                    return o1.getY()-o2.getY();
//                else
//                    return o1.getX()-o2.getX();
//            }
//
//        });
//        for(NodeCoordinates1 i: list) {
//            System.out.println(i.getNode().data + " (" + i.getX() + ", " + i.getY() + ")");
//        }
        List<List<NodeCoordinates1>> nodeList = new ArrayList<>();
        for(int i = minWidth; i <= maxWidth; i++) {
            nodeList.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(NodeCoordinates1 i: list) {
            nodeList.get(i.getX() + Math.abs(minWidth)).add(i);

        }
        for(int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).sort(new Comparator<>() {
                @Override
                public int compare(NodeCoordinates1 o1, NodeCoordinates1 o2) {
                    if ((o1.getX() == o2.getX()) && (o1.getY() == o2.getY()))
                        return preOrder.indexOf(o1.getNode()) - preOrder.indexOf(o2.getNode());
                    else if ((o1.getX() == o2.getX()))
                        return o1.getY() - o2.getY();
                    else
                        return o1.getX() - o2.getX();
                }

            });
            for(NodeCoordinates1 node: nodeList.get(i)) {
                ans.get(i).add(node.getNode().data);
                if (ans.get(i).size() == 1) {
                    break;
                }
            }



        }

    }


}
