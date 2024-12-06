package middle.a30;

import common.TreeNode;

public class FlattenTree {
    public void flatten(TreeNode root) {
        TreeNode right = root.right;
        root.right = root.left;
        flatten(root.left);
    }

}
