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
    public List<Integer> inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.empty()) {
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

    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                result.add(pop.val);
                stack.push(pop.right);
                stack.push(pop.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NoRecursionTraversal noRecursionTraversal = new NoRecursionTraversal();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        TreeNode root = TreeNode.listToBinaryTree(list);
        System.out.println(noRecursionTraversal.inorder(root));
        System.out.println(noRecursionTraversal.preorder(root));
    }
}
