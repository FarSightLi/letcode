package middle.a30;

import common.ListNode;
import common.TreeNode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        // 提前结束，且简化后续判断
        if (head.next == null) return new TreeNode(head.val);
        ListNode slowPre = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            if (slowPre != slow) {
                slowPre = slow;
            }
            slow = slow.next;
        }
        // 这个逻辑被if (head.next == null) return new TreeNode(head.val);替换
        // the list length is 2, solo make slow step 1
        if (slow == slowPre && slow.next != null) {
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        // left subtree is not one node
        // 左子树不是单独的list node
        if (slow != fast) {
            slowPre.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildList(new int[]{-10, -3, 0, 5, 9});
        SortedListToBST sortedListToBST = new SortedListToBST();
        TreeNode treeNode = sortedListToBST.sortedListToBST(listNode);
        System.out.println(treeNode);
    }
}
