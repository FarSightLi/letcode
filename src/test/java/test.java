import org.junit.jupiter.api.Test;

public class test {
    @Test
    public void test1(){
        System.out.println(Math.ceil(20 / 6));
        System.out.println(Math.floor(20 / 6));
        System.out.println(Math.round(20 / 6));
        System.out.println(20/6);
        System.out.println(20/6+1);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    private void flatten(TreeNode root){
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
    public void test111(){
        System.out.println(31&18);
    }
}
