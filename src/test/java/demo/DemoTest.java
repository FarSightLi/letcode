package demo;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DemoTest {
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
            if (nums[i - 1] != nums[i]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    @Test
    public void testRemoveDuplicates() {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }


    public boolean isPalindrome(int x) {
        // 负数、不为0且结尾是0的不可能回文
        if (x < 0 || (x != 0 && x % 10 == 0)) {
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
            x = x / 10;
        }
        return origin == result;
    }

    @Test
    public void testIsPalindrome() {
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
    public void testLongestCommonPrefix() {
        String s = longestCommonPrefix(new String[]{"a", "ab"});
    }

    public String addBinary(String a, String b) {
        // make a length is max
        int dif = a.length() - b.length();
        if (dif < 0) {
            String t = "";
            t = a;
            a = b;
            b = t;
        }
        // 补0
        StringBuilder zero = new StringBuilder();
        for (int i = 0; i < Math.abs(dif); i++) {
            zero.append("0");
        }
        b = zero.append(b).toString();
        char c = '0';
        char[] result = new char[a.length() + 1];
        int resultIndex = a.length();
        for (int i = b.length() - 1; i >= 0; i--) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            char r = (charA ^ charB) == 0 ? '0' : '1';
            r = (r ^ c) == 0 ? '0' : '1';
            if ((charA == charB && charA == '1') || r == '0' && c == '1') {
                c = '1';
            } else {
                c = '0';
            }
            result[resultIndex] = r;
            resultIndex--;
        }
        if (c == '1') {
            result[resultIndex] = c;
            return String.valueOf(result, resultIndex, result.length);
        }
        return String.valueOf(result, 1, result.length - 1);
    }

    @Test
    public void testAddBinary() {
        System.out.println(addBinary("1", "111"));
    }


    @Test
    public void testwei() {
        System.out.println((char) ('1' ^ '1') == '0');
        System.out.println('1' ^ '0');
        System.out.println('0' ^ '0');
        System.out.println("**********");
        System.out.println('1' | '1');
        System.out.println('1' | '1');
        System.out.println('1' | '0');
        System.out.println("**********");
        System.out.println('1' & '0');
        System.out.println('0' & '0');
        System.out.println('0' & '0');
        System.out.println();
        System.out.println('0' + '0');
    }


    public int[] plusOne(int[] digits) {
        int carry = 0;
        int lastNum = digits[digits.length - 1] + 1;
        if (lastNum >= 10) {
            lastNum = lastNum - 10;
            carry = 1;
        }
        digits[digits.length - 1] = lastNum;
        for (int i = digits.length - 2; i >= 0; i--) {
            int r = digits[i] + carry;
            if (r >= 10) {
                carry = 1;
                r = r - 10;
            } else {
                carry = 0;
            }
            digits[i] = r;
        }
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        } else {
            return digits;
        }
    }

    @Test
    public void testPlusOne() {
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return revisionInorderTraversal(root);
    }

    private List<Integer> revisionInorderTraversal(TreeNode treeNode) {
        List<Integer> left = new ArrayList<>();
        if (treeNode.left != null) {
            left = revisionInorderTraversal(treeNode.left);
        }
        List<Integer> right = new ArrayList<>();
        if (treeNode.right != null) {
            right = revisionInorderTraversal(treeNode.right);
        }
        List<Integer> result = new ArrayList<>(left);
        result.add(treeNode.val);
        result.addAll(right);
        return result;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q && p == null) {
            return true;
        } else {
            if (p == null || q == null) {
                return false;
            }
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean revisionsIsSameTree(TreeNode p, TreeNode q) {
        if (p != q) {
            return false;
        } else {
            // one of them is null ,return false
            if (q == null) {
                return false;
            }
        }
        return revisionsIsSameTree(p.left, q.left) && revisionsIsSameTree(q.right, q.right);
    }

    /**
     * 是否对称
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return recursionSymmetric(root.left, root.right);
    }

    public boolean recursionSymmetric(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            } else {
                return recursionSymmetric(p.left, q.right) && recursionSymmetric(p.right, q.left);
            }
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    void testIsSymmetric() {
        List<Integer> list = Arrays.asList(2, 3, 3, 4, 5, null, 4);
        TreeNode root = TreeNode.listToBinaryTree(list);
        System.out.println(isSymmetric(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 1);
        map.put(2, 2);
    }

    /**
     * 现在知道1和2，那么3无非就是先走一步，然后剩下的就是走两步的情况，则这时的结果r= v2 再加上 先走两步，剩下的就是走一步的情况:r=v1, 总结果 v1+v2;
     * 4则是先走1步，那么就是v3 和先走两步的v2 则结果等于v3+v2
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        Integer r = map.get(n);
        if (r == null) {
            int i = climbStairs(n - 2);
            map.put(n - 2, i);
            int j = climbStairs(n - 1);
            map.put(n - 1, j);
            r = i + j;
        }
        return r;
    }

    @Test
    public void testClimbStairs() {
        System.out.println(climbStairs(45));
    }


    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getDepth(root, 1);
    }

    public int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        if (root.left == null && root.right == null) {
            return depth;
        }
        return Math.max(getDepth(root.left, depth + 1), getDepth(root.right, depth + 1));
    }

    @Test
    public void testDep() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(maxDepth1(root));
        System.out.println(maxDepth(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getLeftHeight(root.right);
        if (leftHeight == rightHeight) {
            // 根的左右高度相等，则只需计算右树，
            // return 左全子树+根节点 + 右子树
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            // 右子树高度小于左子树，则既要统计左，也要统计右，再加上根节点
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    /**
     * 统计左数的高度
     *
     * @param treeNode
     * @return
     */
    int getLeftHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + getLeftHeight(treeNode.left);
    }

    @Test
    public void testCountNode() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(60);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(countNodes(treeNode));

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//        deque.add(root);
//        int result = root.val;
//        while (!deque.isEmpty()) {
//            if ()
//        }
        return false;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        } else {
            TreeNode tmp = root.left;
            root.left = root.right;
            invertTree(root.left);
            root.right = tmp;
            invertTree(root.right);
        }
        return root;
    }

    @Test
    void testInvertTree() {
        TreeNode treeNode = TreeNode.listToBinaryTree(List.of(1, 2, 3, 4, 6, 7, 9));
        TreeNode result = invertTree(treeNode);
        System.out.println(result);
    }


    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }

    @Test
    void testValidBst(){
        TreeNode treeNode = TreeNode.listToBinaryTree(Arrays.asList(2, 1, 4, null, null, 3, 6));
        isValidBST(treeNode);
    }
}
