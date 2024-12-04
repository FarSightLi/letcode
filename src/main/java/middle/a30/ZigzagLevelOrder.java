package middle.a30;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagLevelOrder {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        recursion(root, 2);
        return result;
    }

    private void recursion(TreeNode treeNode, int high) {
        if (treeNode == null) {
            return;
        }
        TreeNode right = treeNode.right;
        TreeNode left = treeNode.left;
        if (left != null) {
            addNode(left, high);
        }
        if (right != null) {
            addNode(right, high);
        }
        recursion(left, high + 1);
        recursion(right, high + 1);
    }

    private void addNode(TreeNode treeNode, int high) {
        List<Integer> list;
        if (result.size() < high) {
            list = new ArrayList<>();
            result.add(list);
        } else {
            list = result.get(high - 1);
        }
        if (high % 2 == 0) {
            list.add(0, treeNode.val);
        } else {
            list.add(treeNode.val);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(TreeNode.listToBinaryTree(Arrays.asList(0,2,4,1,null,3,-1,5,1,null,6,null,8))));
    }
}
