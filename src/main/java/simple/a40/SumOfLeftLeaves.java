package simple.a40;

import common.TreeNode;

import java.util.Arrays;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root==null){
            return 0;
        }
        // 此节点的左节点是左叶子
        if (root.left != null && root.left.left == null && root.left.right ==null) {
            sum+=root.left.val;
        }
        sum+=sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(5);
        TreeNode treeNode1 = TreeNode.listToBinaryTree(Arrays.asList(3,9,20,null,null,15,7));
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(treeNode1));
    }
}
