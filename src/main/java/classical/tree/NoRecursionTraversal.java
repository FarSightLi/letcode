package classical.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 非递归遍历树
 */
public class NoRecursionTraversal {
    /**
     * 中序遍历
     */
    public List<Integer> Inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode pop = stack.pop();
            result.add(pop.val);
            p = pop.right;
        }
        return result;
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        return result;
    }

    public static void main(String[] args) {
        NoRecursionTraversal noRecursionTraversal = new NoRecursionTraversal();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        TreeNode root = TreeNode.listToBinaryTree(list);
        System.out.println(noRecursionTraversal.Inorder(root));
    }
}
