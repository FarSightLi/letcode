package simple.a30;

import common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        boolean flag1;
        boolean flag2;
        if (r1 != null && r2 != null) {
            if (r1.val == r2.val) {
                flag1 = check(r1.left, r2.right);
                flag2 = check(r1.right, r2.left);
                return flag1 && flag2;
            }
            return false;
        }
        return false;
    }
}
