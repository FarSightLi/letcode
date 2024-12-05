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
        List<Integer> list = new ArrayList<>(1);
        list.add(root.val);
        result.add(list);
        traversal(root, 1);
        return result;
    }

    private void traversal(TreeNode root, int h){
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            // 偶数层高，先left
            if (h % 2 == 0) {
                addResult(root.left,h);
                addResult(root.right,h);
                traversal(root.left,h+1);
                traversal(root.right,h+1);
            }else {
                addResult(root.right,h);
                addResult(root.left,h);
                traversal(root.right,h+1);
                traversal(root.left,h+1);

            }
        }
    }

    private void addResult(TreeNode node, int h){
        if (node == null) {
            return;
        }
        List<Integer> list;
        if (result.size() - 1< h) {
            list = new ArrayList<>();
        }else {
            list = result.get(h);
        }
        list.add(node.val);
        result.add(list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToBinaryTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        ZigzagLevelOrder levelOrder = new ZigzagLevelOrder();
        levelOrder.zigzagLevelOrder(treeNode);
        System.out.println(levelOrder.result);
    }
}
