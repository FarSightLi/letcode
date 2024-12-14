package middle.a30;

import common.TreeNode;

public class BuildTreeByInAndPost {
    int i = 0;
    int p = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length - 1;
        i = postorder.length - 1;
        return helper(inorder, postorder, 3001);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int boundary) {
        if (p < 0 || inorder[i] == boundary) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[p]);
        p--;
        root.right = helper(inorder, postorder, root.val);
        i--;
        root.left = helper(inorder, postorder, boundary);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new BuildTreeByInAndPost().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
