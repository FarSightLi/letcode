package middle.a30;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrder {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        traversal(root, 1);
        return result;
    }

    private void traversal(TreeNode root, int h) {
        if (root.left != null) {
            addResult(root.left, h);
            traversal(root.left, h + 1);
        }
        if (root.right != null) {
            addResult(root.right, h);
            traversal(root.right, h + 1);
        }
    }

    private void addResult(TreeNode node, int h){
        if (result.size() - 1 < h) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            result.add(list);
        } else {
            List<Integer> list = result.get(h);
            list.add(node.val);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToBinaryTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        LevelOrder levelOrder = new LevelOrder();
        levelOrder.levelOrder(treeNode);
        System.out.println(levelOrder.result);
    }
}
