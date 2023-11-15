package simple.a20;

import java.util.Stack;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：有两种方法可以爬到楼顶。
 * <p>
 * 1. 1 阶 + 1 阶
 * <p>
 * 2. 2 阶
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * <p>
 * 输出：3
 * <p>
 * 解释：有三种方法可以爬到楼顶。
 * <p>
 * 1. 1 阶 + 1 阶 + 1 阶
 * <p>
 * 2. 1 阶 + 2 阶
 * <p>
 * 3. 2 阶 + 1 阶
 */
public class ClimbStairs {
    int num = 0;
    int num2 = 0;


    /**
     * 用栈模拟递归
     *
     * @param n
     * @return
     */
    public int climbStairsStack(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        while (!stack.empty()) {
            int peek = stack.pop();
            if (peek - 2 >= 0) {
                stack.push(peek - 2);
            }
            if (peek - 1 >= 0) {
                stack.push(peek - 1);
            } else {
                num++;
            }
        }
        return num;
    }

    public int climbStairs(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 1;
        ints[1] = 1;
        for (int i = 2; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }

    public int test(int n) {
        LinkNode linkNode = new LinkNode();
        linkNode.val = n;
        add(linkNode);
        return num;
    }

    public int test2(int n) {
        Tree tree = new Tree(n);
        add(tree);
        return num2;
    }

    public int test3(int n) {
        Tree tree = new Tree(n);
        addStack(tree);
        return num2;
    }

    class LinkNode {
        int val;
        LinkNode sNode;
    }

    private LinkNode add(LinkNode linkNode) {
        if (linkNode.val - 2 >= 0) {
            LinkNode sNode = new LinkNode();
            sNode.val = linkNode.val - 2;
            linkNode.sNode = sNode;
            add(sNode);
        }
        if (linkNode.val - 2 >= 0) {
            LinkNode sNode = new LinkNode();
            sNode.val = linkNode.val - 1;
            linkNode.sNode = sNode;
            add(sNode);
        } else {
            num++;
            return linkNode;
        }
        return linkNode;
    }


    /**
     * 递归建造二叉树
     *
     * @param tree
     * @return
     */
    private Tree add(Tree tree) {
        // 向右添加
        if (tree.val - 2 >= 0) {
            Tree sNode = new Tree(tree.val - 2);
            tree.right = sNode;
            add(sNode);
        }
        // 向左添加
        if (tree.val - 1 >= 0) {
            Tree sNode = new Tree(tree.val - 1);
            tree.left = sNode;
            add(sNode);
        } else {
            num2++;
            return tree;
        }
        return tree;
    }

    private Tree addStack(Tree tree) {

        Tree root = tree;
        Stack<Tree> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Tree current = stack.pop();

            // 向右添加
            if (current.val - 2 >= 0) {
                Tree rightNode = new Tree(current.val - 2);
                current.right = rightNode;
                stack.push(rightNode);
            }

            // 向左添加
            if (current.val - 1 >= 0) {
                Tree leftNode = new Tree(current.val - 1);
                current.left = leftNode;
                stack.push(leftNode);
            }
        }

        return root;
    }

    public class Tree {
        int val;
        Tree right;
        Tree left;
        Tree pNode;

        public Tree(int val) {
            this.val = val;
        }
    }

    // 获取当前JVM的已用内存量
    private static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = 45;


//
//        // 记录方法2调用前的内存使用情况
//        long memoryBeforeMethod2 = getUsedMemory();
//
//        // 调用方法2
//        climbStairs.test3(n);
//
//        // 记录方法2调用后的内存使用情况
//        long memoryAfterMethod2 = getUsedMemory();
//
//        // 计算方法2的内存占用差异
//        long memoryDiffMethod2 = memoryAfterMethod2 - memoryBeforeMethod2;
//
//        System.out.println("栈递归树: " + memoryDiffMethod2 / (1024 * 1024) + " MB");

        // 记录方法1调用前的内存使用情况
        long memoryBeforeMethod1 = getUsedMemory();

        // 调用方法1
        climbStairs.test2(n);

        // 记录方法1调用后的内存使用情况
        long memoryAfterMethod1 = getUsedMemory();

        // 计算方法1的内存占用差异
        long memoryDiffMethod1 = memoryAfterMethod1 - memoryBeforeMethod1;

        System.out.println("Memory used by method 1: " + memoryDiffMethod1 / (1024 * 1024) + " MB");
        System.out.println("递归树: " + memoryDiffMethod1 / (1024 * 1024) + " MB");

        // 记录方法3调用前的内存使用情况
        long memoryBeforeMethod3 = getUsedMemory();

        // 调用方法3
        climbStairs.climbStairs(n);

        // 记录方法3调用后的内存使用情况
        long memoryAfterMethod3 = getUsedMemory();

        // 计算方法3的内存占用差异
        long memoryDiffMethod3 = memoryAfterMethod3 - memoryBeforeMethod3;

        System.out.println("Memory used by method 3: " + memoryDiffMethod3 / (1024 * 1024) + " MB");

    }

}
