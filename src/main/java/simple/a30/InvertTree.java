package simple.a30;

import common.TreeNode;

/**
 * 翻转二叉树
 */
public class InvertTree {
    /**
     * 先往下寻找再交换
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 左右节点有一个不为空才向下寻找
        if (root.left != null || root.right != null) {
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
        }
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;
        return root;
    }

    /**
     * 先交换再往下寻找
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(1);
        System.out.println(treeNode);
        InvertTree invertTree = new InvertTree();
        invertTree.invertTree(treeNode);
    }
}
