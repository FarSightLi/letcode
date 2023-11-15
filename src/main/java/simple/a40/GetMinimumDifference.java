package simple.a40;

import common.TreeNode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        int selfNum = Integer.MAX_VALUE;
        if (root == null) {
            return selfNum;
        }
        int sonNum = Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right));
        if (root.left != null && root.right != null) {
            selfNum = Math.min(root.val - root.left.val, Math.abs(root.val - root.right.val));
        } else if (root.right == null && root.left != null) {
            selfNum = root.val - root.left.val;
        } else if (root.right != null) {
            selfNum = Math.abs(root.val - root.right.val);
        }
        return Math.min(sonNum, selfNum);
    }
}
