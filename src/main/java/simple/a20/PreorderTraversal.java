package simple.a20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 前序遍历二叉树
 */
public class PreorderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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
}
