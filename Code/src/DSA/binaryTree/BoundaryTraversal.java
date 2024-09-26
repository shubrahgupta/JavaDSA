package DSA.binaryTree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));
        root.getLeft().getRight().setLeft(new Node(8));
        root.getLeft().getRight().setRight(new Node(9));

        BoundaryTraversal q = new BoundaryTraversal();
        System.out.println(q.boundary(root));
    }
    ArrayList<Integer> ans;

    ArrayList<Integer> boundary(Node node) {
        ans = new ArrayList<>();

        // Add the root node if it's not null
        if (node != null && !isLeaf(node)) {
            ans.add(node.data);
        }

        // Add the left boundary (excluding leaf nodes)
        leftBoundary(node.left);

        // Add all leaf nodes
        leafNodeBoundary(node);

        // Add the right boundary (excluding leaf nodes and reverse it at the end)
        rightBoundary(node.right);

        return ans;
    }

    // Function to add the left boundary
    public void leftBoundary(Node root) {
        while (root != null) {
            if (!isLeaf(root)) {
                ans.add(root.data); // Add only non-leaf nodes
            }
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    // Function to add the right boundary
    public void rightBoundary(Node root) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (root != null) {
            if (!isLeaf(root)) {
                temp.add(root.data); // Add only non-leaf nodes
            }
            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        // Reverse the right boundary and add to the result
        Collections.reverse(temp);
        ans.addAll(temp);
    }

    // Function to add leaf nodes
    public void leafNodeBoundary(Node root) {
        if (root == null) return;
        if (isLeaf(root)) {
            ans.add(root.data);
        }
        leafNodeBoundary(root.left);
        leafNodeBoundary(root.right);
    }

    // Helper function to check if a node is a leaf node
    public boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

}
