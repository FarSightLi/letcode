package simple.a50;

import common.TreeNode;

import java.util.Arrays;

public class FindTilt {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        return Math.abs(left - right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToBinaryTree(Arrays.asList(1, 2, 3));
        new FindTilt().findTilt(treeNode);
    }
}
