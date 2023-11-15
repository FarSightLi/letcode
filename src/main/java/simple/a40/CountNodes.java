package simple.a40;

import common.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2^h 个节点。
 */
public class CountNodes {

    /**
     * 通过遍历所有节点
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        int num = 0;
        if (root == null){
            return num;
        }
        num++;
        num+=countNodes1(root.left);
        num+=countNodes1(root.right);
        return num;
    }

    /**
     * 利用完全二叉树定义
     * @param root
     * @return
     */
    public int countNodes(TreeNode root){
        int num =0;
        if (root == null){
            return num;
        }
        int left = getHigh(root.left);
        int right = getHigh(root.right);

        if (left == right){
            return (1<<left)+countNodes(root.right);
        }else {
            return (1<<right)+countNodes(root.left);
        }
    }

    private int getHigh(TreeNode treeNode){
        int high = 0;
        if (treeNode == null){
            return high;
        }
        high++;
        high += getHigh(treeNode.left);
        return high;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.add(treeNode,2);
        treeNode.add(treeNode,3);
        treeNode.add(treeNode,4);
        treeNode.add(treeNode,5);
        treeNode.add(treeNode,6);
        int i = new CountNodes().countNodes(treeNode);
        System.out.println(i);

    }
}
