package middle.a20;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree2 {
    public List<TreeNode> generateTrees(int n) {
        return recursion(1, n);
    }

    public List<TreeNode> recursion(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = recursion(start, i - 1);
            List<TreeNode> rightList = recursion(i + 1, end);
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new UniqueBinarySearchTree2().generateTrees(3);
        System.out.println(treeNodes);
    }
}
