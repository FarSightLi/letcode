package simple.a40;

import common.ListNode;

import java.util.HashSet;

public class GetIntersectionNode {
    public ListNode getIntersectionNodeOld(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (set.contains(headA)) {
                    return headA;
                }
                set.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                }
                set.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a== null? headB: a.next;
            b = b==null?headA:b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.buildList(new int[]{4, 1 ,2});
        ListNode listNode2 = ListNode.buildList(new int[]{5,6});
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode intersectionNode = getIntersectionNode.getIntersectionNode(listNode1, listNode2);
        System.out.println(intersectionNode);
    }
}
