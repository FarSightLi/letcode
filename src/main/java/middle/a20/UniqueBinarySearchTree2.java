package middle.a20;

import common.TreeNode;

import java.util.List;

public class UniqueBinarySearchTree2 {
    public List<TreeNode> generateTrees(int n) {
        for (int i = 1; i < n; i++) {
            // 以i为根
            TreeNode treeNode = new TreeNode(i);
            // 构建左树
            int left = i - 1;
            // 从比i小的数字中挑选一个作为第一个左节点
            for (int j = 1; j < left; j++) {

            }
        }
        return null;
    }

    public TreeNode recursion(int n) {
        for (int i = 1; i < n; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left > 0 || right <= n) {
                TreeNode treeNode = new TreeNode(i);
                treeNode.left = recursion(left);
                treeNode.right = recursion(right);
                left--;
                right++;
            }
        }
        return null;
    }
}
