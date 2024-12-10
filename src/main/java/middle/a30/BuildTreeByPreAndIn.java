package middle.a30;

import common.TreeNode;

public class BuildTreeByPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,0,inorder.length);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart >= inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i < inEnd; i++) {
            // is root
            if (inorder[i] == preorder[preStart]) {
                root.left = helper(preorder, inorder, preStart + 1, inStart-1, i);
                // 在inorder中，根节点左边的个数即是左节点个个数，左子树个数=inEnd-inStart+1
                // 那么对应preOrder来说，根节点向后偏移x个就是右子树部分
                root.right = helper(preorder, inorder, preStart + i - inStart +1, i + 1, inEnd);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new BuildTreeByPreAndIn().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}


