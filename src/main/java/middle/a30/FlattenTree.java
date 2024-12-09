package middle.a30;

import common.TreeNode;

public class FlattenTree {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            // 找到第一个左节点
            if (curr.left != null) {
                TreeNode runner = curr.left;
                // 开始找最右节点
                while (runner.right != null) {
                    runner = runner.right;
                }
                // 找到最右节点了，将curr的右节点连到最右节点的右侧
                runner.right = curr.right;
                // 将这个左子树放到curren的右节点
                curr.right = curr.left;
                // 将左子树置空
                curr.left = null;
            }
            // 在下一个节点（即右节点继续此逻辑）
            curr = curr.right;
        }
    }

}
