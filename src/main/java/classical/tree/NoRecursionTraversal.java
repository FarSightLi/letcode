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

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root;
        TreeNode lastVisited = null;
        while (p!=null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }else {
                // 右子树存在，且右子树没访问过，访问右子树
                // 右子树不存在，弹出本节点
                TreeNode peek = stack.peek();
                // 右节点不为空且peek的右节点没有被访问过
                if (peek.right != null && lastVisited != peek.right) {
                    p=peek.right;
                    lastVisited = p;
                }else {
                    TreeNode pop = stack.pop();
                    result.add(pop.val);
                    p = pop.right;
                    lastVisited = pop.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NoRecursionTraversal noRecursionTraversal = new NoRecursionTraversal();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        TreeNode root = TreeNode.listToBinaryTree(list);
//        System.out.println(noRecursionTraversal.inorder(root));
//        System.out.println(noRecursionTraversal.preorder(root));
        System.out.println(noRecursionTraversal.postorder(root));
    }
}
