package middle.a30;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>(1);
        list.add(root.val);
        result.add(list);
        recursion(result, root, 1);
        return result;
    }

    private void recursion(List<List<Integer>> result, TreeNode treeNode, int high) {
        TreeNode left = treeNode.left;
        if (left != null) {
            addNode(result, left,high);
            recursion(result, left, high+1);
        }
        TreeNode right = treeNode.right;
        if (right != null) {
            addNode(result, right,high);
            recursion(result, right,high+1);
        }
    }

    private void addNode(List<List<Integer>> result, TreeNode treeNode, int high) {
        int size = result.size();
        if (size <= high) {
            List<Integer> list = new ArrayList<>();
            list.add(treeNode.val);
            result.add(0,list);
        }else {
            result.get(size - high - 1).add(treeNode.val);
        }
    }
}
