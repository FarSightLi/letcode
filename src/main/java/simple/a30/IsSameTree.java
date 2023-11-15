package simple.a30;

import common.TreeNode;

/**
 * 判断两棵树是否相等
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag1;
        boolean flag2;
        // 节点都不为空
        if (p != null && q != null) {
            // 节点值相等
            if (p.val == q.val) {
                flag1 = isSameTree(p.left, q.left);
                flag2 = isSameTree(p.right, q.right);
            }
            //节点值不相等
            else {
                return false;
            }
            return flag1 && flag2;
            // 节点都为空，也是结构相等
        }else return p == null && q == null;
    }

}
