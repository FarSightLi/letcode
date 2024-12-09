package middle.a30;

import common.TreeNode;

public class FlattenTree {
    public void flatten(TreeNode root) {
        // 开始遍历，当前节点就是root
        TreeNode curr = root;
        while (curr != null) {
            // 开始找当前节点的左节点的最右节点
            if (curr.left != null) {
                TreeNode runner = curr.left;
                while (runner.right != null) {
                    runner = runner.right;
                }
                // 找到最右节点了，开始链接
                runner.right = curr.right;
                // 将左子树放到右子树位置
                curr.right = curr.left;
                // 将左子树置空
                curr.left = null;
            }
            // 继续展平下一个节点
            curr = curr.right;
        }
    }

    public void flattenRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        if (left != null) {
            //找右节点
            while (left.right != null) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flattenRecursion(root.right);
    }
}
