import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
    public void test1() {
        class Solution {
            public int[] twoSum(int[] nums, int target) {
                Map<Integer, Integer> map = new HashMap<>(nums.length);
                for (int i = 0; i < nums.length; i++) {
                    map.put(nums[i], i);
                }
                for (int i = 0; i < nums.length; i++) {
                    Integer t = map.get(target - nums[i]);
                    if (t.equals(nums[i])) {
                        continue;
                    }
                    if (t != null) {
                        return new int[]{i, map.get(target - nums[i])};
                    }
                }
                return new int[0];
            }
        }
        System.out.println(Math.ceil(20 / 6));
        System.out.println(Math.floor(20 / 6));
        System.out.println(Math.round(20 / 6));
        System.out.println(20 / 6);
        System.out.println(20 / 6 + 1);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        // 计算左子树的节点值之和
        int leftSum = sum(root.left);

        // 更新当前节点的值
        root.val += leftSum;

    }

    // 计算节点值之和的辅助函数
    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        return leftSum + rightSum + node.val;
    }

    @Test
    public void test2() {

        // 创建一个二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // 展开二叉树
        flatten(root);

        // 打印展开后的二叉树
        printTree(root);
    }

    // 打印二叉树的辅助函数（中序遍历）
    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }

        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }

    @Test
    public void test111() {
        System.out.println(31 & 18);
    }

    @Test
    public void testRemoveElement() {
        int[] nums = new int[]{1, 2}; // Input array
        int val = 2; // Value to remove
        int[] expectedNums = new int[]{0, 1, 4, 0, 3}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation
        assert k == expectedNums.length;
        for (int i = 0; i < 2; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }


    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    @Test
    public void testRemoveDuplicates() {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }


    public boolean isPalindrome(int x) {
        // 负数、不为0且结尾是0的不可能回文
        if (x < 0 || (x!=0 && x%10==0)){
            return false;
        }
        int result = 0;
        // 储存原始数字
        int origin = x;
        while (x > 0) {
            // 获得最后一位
            int last = x % 10;
            result = result * 10 + last;
            // 去除x的最后一位
            x = x /10;
        }
        return origin == result;
    }

    @Test
    public void testIsPalindrome(){
        System.out.println(isPalindrome(-121));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int shortest = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int length = strs[i].length();
            if (length < shortest) {
                shortest = length;
            }
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < shortest; i++) {
            String firstStr = strs[0];
            char c = firstStr.charAt(i);
            for (String str : strs) {
                if (c != str.charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }

    @Test
    public void testLongestCommonPrefix(){
        String s = longestCommonPrefix(new String[]{"a","ab"});
    }
}
