package middle.a10;


import common.TreeNode;

public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                // 将左节点挂到右节点的最左节点
                add(root.right,root.left);
                root = root.right;
            }
        }
        return root;
    }

    private void add(TreeNode root, TreeNode key){
        if (root.left == null) {
            root.left = key;
        }else {
            add(root.left,key);
        }
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        TreeNode root = new TreeNode(4);
        root.add(root,2);
        root.add(root,1);
        root.add(root,3);
        root.add(root,7);
        root.add(root,8);
        root.preorderTraversal(root).forEach(o-> System.out.printf(o+","));
    }



}
