package middle.a20;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestTree {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // while结束后左节点已为空
            // root还原为上一个节点
            root = stack.pop();
            if (--k <=0) {
                break;
            }
            // 准备遍历右节点
            root = root.right;
        }
        return root.val;
    }
}
