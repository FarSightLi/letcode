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
    public List<Integer> Inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root;
        while (!stack.empty()) {
            System.out.println(p.val);
            if (p.left != null) {
                stack.push(p.left);
                p = p.left;
                continue;
            }
            result.add(stack.pop().val);
            if (p.right != null) {
                stack.push(p.right);
                p = p.right;
                continue;
            }
            p = stack.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        NoRecursionTraversal noRecursionTraversal = new NoRecursionTraversal();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        TreeNode root = TreeNode.listToBinaryTree(list);
        System.out.println(noRecursionTraversal.Inorder(root));
    }
}
