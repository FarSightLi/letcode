package middle.a20;

import common.TreeNode;

import java.util.Arrays;

/**
 * BST中有两个节点（或彻底没有）颠倒了，恢复他
 */
public class RecoverTree {
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;

    /**
     * 通过中序遍历，即可获得一个排序好的列表，假如有两个节点颠倒了，说明在这个列表里有两个数字是大于前一个数字的，交换他们即可
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        find(root);
        if (first != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }


    public void find(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        find(treeNode.left);
        // 前一个有值且大于当前节点，说明是错的
        if (pre != null && treeNode.val <= pre.val) {
            // 如果是第一次找到错节点，则第一个错节点是上一个节点
            // 如果不是第二次找到错节点，则第一个错节点无需改变
            if (first == null) {
                first = pre;
            }
            // 无论第几次发现错节点，第二个错节点是当前节点。
            second = treeNode;
        }
        pre = treeNode;
        find(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToBinaryTree(Arrays.asList(3,1,4,null,null,2));
        new RecoverTree().recoverTree(treeNode);
        System.out.println(treeNode);
    }
}
