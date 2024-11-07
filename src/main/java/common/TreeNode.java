package common;


import java.util.*;

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

        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1; // 从列表的第二个元素开始

        while (i < list.size()) {
            TreeNode current = queue.poll();
            if (current != null) {
                // 左子节点
                if (i < list.size() && list.get(i) != null) {
                    current.left = new TreeNode(list.get(i));
                    queue.offer(current.left);
                }
                i++;

                // 右子节点
                if (i < list.size() && list.get(i) != null) {
                    current.right = new TreeNode(list.get(i));
                    queue.offer(current.right);
                }
                i++;
            }
        }

        return root;
    }

}