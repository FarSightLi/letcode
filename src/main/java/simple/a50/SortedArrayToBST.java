package simple.a50;

import common.TreeNode;


public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length);
    }

    private TreeNode buildTree(int[] nums, int from, int end) {
        int size = end - from;
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return new TreeNode(nums[from]);
        }
        int mid = (end + from)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums,from,mid);
        root.right = buildTree(nums,mid+1,end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }
}
