package simple.a30;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HasPathSum {

    /**
     * 失败的栈解法
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumFail(TreeNode root, int targetSum) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int sum = 0;
        TreeNode last = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                sum = sum + root.val;
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            // 说明是叶子节点
            if (pop.right == null && pop.left == null) {
                System.out.println(sum);
                if (sum == targetSum) {
                    return true;
                }
                if (last != null) {
                    sum = sum - last.val;
                    last = null;
                }
            }
            // 开始遍历右节点
            if (pop.right != null) {
                root = pop.right;
                last = pop;
            } else {
                // 右节点也为空，说明还会继续弹栈，所有需要减去该节点
                sum = sum - pop.val;
            }
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return checkSum(root, 0, targetSum);
    }

    private boolean checkSum(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        sum = sum + node.val;
        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }
        return checkSum(node.left, sum, targetSum) || checkSum(node.right, sum, targetSum);
    }

    public static void main(String[] args) {
        System.out.println(new HasPathSum().hasPathSum(TreeNode.listToBinaryTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)), 18));
    }
}
