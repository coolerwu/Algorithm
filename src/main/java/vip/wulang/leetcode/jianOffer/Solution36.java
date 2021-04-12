package vip.wulang.leetcode.jianOffer;


import vip.wulang.leetcode.structrue.Node;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author CoolerWu
 * @version 1.0
 * @since 2021/4/10
 */
public class Solution36 {

    Node head = null, pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        midForeach(root);
        if (pre != null) {
            pre.right = head;
            head.left = pre;
        }
        return head;
    }

    private void midForeach(Node node) {
        if (node == null) {
            return;
        }

        midForeach(node.left);

        if (head == null) {
            head = node;
        } else {
            pre.right = node;
            node.left = pre;
        }
        pre = node;

        midForeach(node.right);
    }

    public Node treeToDoublyList02(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Node> list = new ArrayList<>(1000);
        midForeach02(list, root);
        Node head = null;
        Node parent = null;
        for (Node node : list) {
            if (head == null) {
                head = node;
            } else {
                parent.right = node;
                node.left = parent;
            }
            parent = node;
        }
        if (parent != null) {
            parent.right = head;
            head.left = parent;
        }
        return head;
    }

    private void midForeach02(ArrayList<Node> list, Node node) {
        if (node == null) {
            return;
        }

        midForeach02(list, node.left);
        list.add(node);
        midForeach02(list, node.right);
    }

    private static class NNode {
        public Node node;
        public boolean checkedLeft;
        public boolean checkedRight;

        public NNode(Node node, boolean checkedLeft, boolean checkedRight) {
            this.node = node;
            this.checkedLeft = checkedLeft;
            this.checkedRight = checkedRight;
        }
    }

    public Node treeToDoublyList01(Node root) {
        if (root == null) {
            return null;
        }

        LinkedList<NNode> stack = new LinkedList<>();
        stack.push(new NNode(root, false, false));
        Node head = null;
        Node parent = null;
        while (!stack.isEmpty()) {
            NNode node = stack.peek();
            if (node.node.left != null && !node.checkedLeft) {
                node.checkedLeft = true;
                stack.push(new NNode(node.node.left, false, false));
                continue;
            }

            node = stack.pop();
            Node newNode = new Node(node.node.val);
            if (head == null) {
                head = newNode;
            } else {
                parent.right = newNode;
                newNode.left = parent;
            }
            parent = newNode;

            if (node.node.right != null && !node.checkedRight) {
                node.checkedRight = true;
                stack.push(new NNode(node.node.right, false, false));
            }
        }

        if (parent != null) {
            parent.right = head;
            head.left = parent;
        }
        return head;
    }
}