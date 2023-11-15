package middle.a10;

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建虚拟头节点，简化链表操作
        ListNode dummyHead = new ListNode();
        // 当前节点，用于构建结果链表
        ListNode current = dummyHead;
        // 进位值，初始为0
        int carry = 0;

        // 遍历两个输入链表，以及进位值不为0作为循环条件
        while (l1 != null || l2 != null || carry != 0) {
            // 当前位的和，初始为进位值
            int sum = carry;
            // 如果 l1 不为空，则加上 l1 的当前位的值，并移动 l1 指针
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 如果 l2 不为空，则加上 l2 的当前位的值，并移动 l2 指针
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 计算进位值和当前位的值
            carry = sum / 10;
            sum %= 10;

            // 构建结果链表，将当前位的值加入链表
            current.next = new ListNode(sum);
            // 移动当前节点指针
            current = current.next;
        }

        // 返回虚拟头节点的下一个节点，即为相加结果的链表
        return dummyHead.next;
    }
//        LinkedList<Integer> list1 = new LinkedList<>();
//        LinkedList<Integer> list2 = new LinkedList<>();
//        // 存储和的list
//        LinkedList<Integer> list3 = new LinkedList<>();
//        // 初始化list3
//        list3.add(0);
//        // 将链表顺序存储
//        while (l1 != null) {
//            list1.add(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            list2.add(l2.val);
//            l2 = l2.next;
//        }
//        int size1 = list1.size();
//        int size2 = list2.size();
//        if (size1 > size2) {
//            for (int i = 0; i < size1 - size2; i++) {
//                list2.add(0);
//            }
//        } else if (size1 < size2) {
//            for (int i = 0; i < size2 - size1; i++) {
//                list1.add(0);
//            }
//        }
//
//        int size = Math.max(size1,size2);
//        boolean flag = false;
//        for (int i = 0; i < size; i++) {
//            int up = 0;
//
//            // 当前这一位
//            int num = list1.get(i) + list2.get(i) + list3.get(i);
//            flag = num >= 10;
//            // 大于10，就下一位+1
//            if (flag) {
//                num = num - 10;
//                up = 1;
//            }
//            // 什么时候不向后挂一位：up=0且i == size-1
//            if (!(up==0 &&i == size-1)){
//                list3.add(up);
//            }
//            list3.set(i, num);
//        }
//        ListNode listNode = new ListNode(list3.get(0));
//        for (int i = 1; i < list3.size(); i++) {
//            add(listNode, list3.get(i));
//        }
//        return listNode;
//    }
//
//    private ListNode add(ListNode node, Integer val) {
//        // 得到最后一个节点
//        while (node.next != null) {
//            node = node.next;
//        }
//        // 新建一个节点，挂到最后
//        ListNode newNode = new ListNode(val);
//        node.next = newNode;
//        return node;
//    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
//        ListNode listNode1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode listNode2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        System.out.println(solution.addTwoNumbers(listNode1, listNode2).toString());
    }
}