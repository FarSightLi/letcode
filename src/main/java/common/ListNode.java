package common;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildList(int[] nums) {
        ListNode listNode = new ListNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            ListNode endNode = listNode;
            while (endNode.next != null) {
                endNode = endNode.next;
            }
            endNode.next = new ListNode(nums[i]);
        }
        return listNode;
    }

    private static ListNode recursionBuildList(ListNode node, int num) {
        node.next = new ListNode(num);
        return node.next;
    }
}
