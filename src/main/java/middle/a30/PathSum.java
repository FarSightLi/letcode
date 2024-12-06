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
        pathSumHelper(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, List<Integer> current, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            list.add(new ArrayList<>(current));
        } else {
            pathSumHelper(root.left, sum - root.val, current, list);
            pathSumHelper(root.right, sum - root.val, current, list);
        }
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.listToBinaryTree(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1));
        List<List<Integer>> list = new PathSum().pathSum(node, 22);
        System.out.println(list);
    }
}
