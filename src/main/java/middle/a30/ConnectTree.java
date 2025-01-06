package middle.a30;

import common.TreeNode;

import java.util.ArrayDeque;

public class ConnectTree {
    // Definition for a Node.
    class Node {
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

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            ArrayDeque<Node> deque = new ArrayDeque<>();
            deque.push(root);
            while (!deque.isEmpty()) {
                Node poll = deque.poll();
                if (poll == null) {
                    continue;
                }

                deque.offer(poll.left);
                deque.offer(poll.right);
            }
            return root;
        }
    }
}
