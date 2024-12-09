package simple.a50;

import common.TreeNode;

import java.util.Arrays;

public class FindTilt {
    // 1.计算倾斜度
    // 2.增加sum
    int sum = 0;
    public int findTilt(TreeNode root) {
        getSum(root);
        return sum;
    }

    /**
     * 首先，计算倾斜度是按原值来的，其次，最后需要返回sum
     * 所以，求完倾斜度后，求sum，无需修改树的值
     * @param root
     * @return
     */
    private int getSum(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
        sum += Math.abs(left-right);
        return root.val + left + right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToBinaryTree(Arrays.asList(21,7,14,1,1,2,2,3,3));
        int tilt = new FindTilt().findTilt(treeNode);
        System.out.println(tilt);
    }
}
