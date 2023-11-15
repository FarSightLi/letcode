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
}