package DSA.binaryTree;

public class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        if (isBalancedCheck(root) == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    public int isBalancedCheck(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = isBalancedCheck(root.left);
        int rh = isBalancedCheck(root.right);
        if (lh == -1 || (rh == -1)) return -1;
        if (Math.abs(lh-rh) > 1) return -1;
        return 1 + Math.max(lh,rh);
    }

}
