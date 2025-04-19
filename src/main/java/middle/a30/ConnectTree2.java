package middle.a30;

import java.util.*;

public class ConnectTree2 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        while (root != null) {
            if (root.left != null) {
                if (root.right == null) {
                    // 寻找下一个不为空的节点
                    root.left.next = getNextNode(root.next);
                } else {
                    root.left.next = root.right;
                }
            }
            if (root.right != null) {
                root.right.next = getNextNode(root.next);
            }
        }
        return root;
    }

    private Node getNextNode(Node root) {
        if (root == null) return root;
        Node connectNode = null;
        Node next = root;
        while (next != null) {
            if (next.left != null) {
                connectNode = next.left;
                break;
            }
            if (next.right != null) {
                connectNode = next.right;
                break;
            }
            next = next.next;
        }
        return connectNode;
    }

    public static void main(String[] args) {
        ConnectTree2 connectTree2 = new ConnectTree2();
        Node node = ConnectTree2.listToBinaryTree(Arrays.asList(2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, null, null, 7));
        connectTree2.connect(node);
        System.out.println(node);
    }

    public static Node listToBinaryTree(List<Integer> list) {
        if (list == null || list.isEmpty() || list.get(0) == null) {
            return null; // 空列表或第一个元素为 null 返回空树
        }

        Node root = new Node(list.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1; // 从列表的第二个元素开始

        while (i < list.size()) {
            Node current = queue.poll();
            if (current != null) {
                // 左子节点
                if (i < list.size() && list.get(i) != null) {
                    current.left = new Node(list.get(i));
                    queue.offer(current.left);
                }
                i++;

                // 右子节点
                if (i < list.size() && list.get(i) != null) {
                    current.right = new Node(list.get(i));
                    queue.offer(current.right);
                }
                i++;
            }
        }

        return root;
    }
}
