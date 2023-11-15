package middle.a10;

import common.TreeNode;

/**
 * 验证是否是合法的二叉搜索树
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * <p>
 * 节点的右子树只包含 大于 当前节点的数。
 * <p>
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean flag = true;

    private boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val <= low || root.val >= high) {
            return false;
        }
//        if (root.left != null) {
//            if (root.left.val < root.val) {
//                flag=isValidBST(root.left,low, root.val);
//            } else {
//                return false;
//            }
//        }
//        if (root.right != null) {
//            if (root.right.val > root.val) {
//                flag=isValidBST(root.right, root.val, high);
//            } else {
//                return false;
//            }
//        }
//        return flag;
        /// 官方解题写法
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
//        root.add(root, 1);
//        root.add(root, 5);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(6);
//        root.right.left.left = new TreeNode(3);
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(root));
    }
}
