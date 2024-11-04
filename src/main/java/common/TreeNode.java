package common;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> integers = new ArrayList<>();
        List<Integer> left = inorderTraversal(root.left);
        integers.addAll(left);
        integers.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        integers.addAll(right);

        return integers;
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(root.val);
        List<Integer> left = preorderTraversal(root.left);
        integers.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        integers.addAll(right);
        return integers;
    }

    public TreeNode add(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (root.val <= key) {
            root.right = add(root.right, key);
        } else {
            root.left = add(root.left, key);
        }
        return root;
    }

    // 方法：将 List 转换为二叉树
    public static TreeNode listToBinaryTree(List<Integer> list) {
        if (list == null || list.isEmpty() || list.get(0) == null) {
            return null; // 空列表或第一个元素为 null 返回空树
        }
        return buildTree(list, 0);
    }

    // 辅助递归方法：构建树节点
    private static TreeNode buildTree(List<Integer> list, int index) {
        if (index >= list.size() || list.get(index) == null) {
            return null; // 超出列表边界或元素为 null 时返回 null
        }
        TreeNode node = new TreeNode(list.get(index));
        node.left = buildTree(list, 2 * index + 1); // 左子节点位置：2 * index + 1
        node.right = buildTree(list, 2 * index + 2); // 右子节点位置：2 * index + 2
        return node;
    }

}