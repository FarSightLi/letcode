package simple.a50;

import common.TreeNode;

import java.util.Arrays;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 1);
    }

    private int helper(TreeNode root, int d) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) {
            return d;
        }
        int l = helper(root.left, d + 1);
        int r = helper(root.right, d + 1);
        if (l == -1) return r;
        if (r == -1) return l;
        return Math.min(l, r);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToBinaryTree(Arrays.asList(2, null, 3, null, 4, null, 5, null, 6));
        System.out.println(new MinDepth().minDepth(treeNode));
    }
}
