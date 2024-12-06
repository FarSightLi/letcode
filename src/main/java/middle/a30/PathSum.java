package middle.a30;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSumHelper(root, 0, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, int targetSum, List<Integer> current, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        current.add(root.val);
        if (root.left == null && root.right == null && sum == targetSum) {
            list.add(new ArrayList<>(current));
        } else {
            pathSumHelper(root.left, sum, targetSum, current, list);
            pathSumHelper(root.right, sum, targetSum, current, list);
        }
        // 相当于弹栈
        System.out.println("当前节点：" + root.val);
        System.out.println(current);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.listToBinaryTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
        List<List<Integer>> list = new PathSum().pathSum(node, 22);
    }
}
