package middle.a30;

import common.TreeNode;

public class BuildTreeByPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bTree(preorder, inorder, 3001);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart >= inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i < inEnd; i++) {
            // is root
            if (inorder[i] == preorder[preStart]) {
                root.left = helper(preorder, inorder, preStart + 1, inStart - 1, i);
                // 在inorder中，根节点左边的个数即是左节点个个数，左子树个数=inEnd-inStart+1
                // 那么对应preOrder来说，根节点向后偏移x个就是右子树部分
                root.right = helper(preorder, inorder, preStart + i - inStart + 1, i + 1, inEnd);
            }
        }
        return root;
    }

    int i = 0; // the index of inorder
    int p = 0; // the index of preorder

    private TreeNode bTree(int[] preorder, int[] inorder, int boundary) {
        // if p >= preorder'length, it means all elements is been processed
        if (p >= preorder.length) {
            return null;
        }
        // when processing the left subtree, boundary is last depth's root
        // when processing right subtree,the boundary is last element (or say i >= inorder.length)
        // and i >= inorder.length amount to p>= inoder.length, so not need check it
        if (inorder[i] == boundary) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p]);
        p++;
        root.left = bTree(preorder, inorder, root.val);
        i++;
        root.right = bTree(preorder, inorder, boundary);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new BuildTreeByPreAndIn().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}


