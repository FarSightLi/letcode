package simple.a30;

import common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        int leftHigh, rightHigh;
        leftHigh = 0;
        rightHigh = 0;
        getHigh(root.left, leftHigh);
        getHigh(root.right,rightHigh);
        int num = leftHigh - rightHigh;
        return false;
    }

    private void getHigh(TreeNode root, int high) {
        if (root.left != null) {
            getHigh(root.left,high);
        }
        if (root.right != null) {
            getHigh(root.right,high);
        }
        high++;
    }
}
