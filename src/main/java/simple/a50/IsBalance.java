package simple.a50;

import common.TreeNode;

import java.util.Arrays;

public class IsBalance {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int lDepth = getDepth(treeNode.left);
        if (lDepth == -1) return -1;
        int rDepth = getDepth(treeNode.right);
        if (rDepth == -1) return -1;
        if (Math.abs(lDepth-rDepth) > 1)  return -1;
        return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToBinaryTree(Arrays.asList(1, 2, 2, 3, null, null, 3, 4, null, null, 4));
        System.out.println(new IsBalance().isBalanced(treeNode));
    }
}
