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

    /**
     * 过了几天，重新用排名第一思路解题
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeNew(ListNode headA, ListNode headB) {
        int aLen = 1;
        int bLen = 1;
        ListNode countNodeA = headA;
        ListNode countNodeB = headB;
        while (countNodeA.next != null) {
            aLen++;
            countNodeA = countNodeA.next;
        }
        while (countNodeB.next != null) {
            bLen++;
            countNodeB = countNodeB.next;
        }
        ListNode newHeadA = headA;
        ListNode newHeadB = headB;
        while (aLen > bLen) {
            newHeadA = newHeadA.next;
            aLen--;
        }
        while (bLen > aLen) {
            newHeadB = newHeadB.next;
            bLen--;
        }
        while (newHeadA != null && newHeadB != null) {
            if (newHeadA == newHeadB) {
                return newHeadA;
            }
            newHeadA = newHeadA.next;
            newHeadB = newHeadB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.buildList(new int[]{4, 1 ,2});
        ListNode listNode2 = ListNode.buildList(new int[]{5,6});
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode intersectionNode = getIntersectionNode.getIntersectionNode(listNode1, listNode2);
        System.out.println(intersectionNode);
    }
}
