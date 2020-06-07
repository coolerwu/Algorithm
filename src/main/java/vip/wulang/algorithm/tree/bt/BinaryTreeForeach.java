package vip.wulang.algorithm.tree.bt;

import vip.wulang.algorithm.tree.bt.structrue.BinaryTreeNode;

import java.util.*;

public class BinaryTreeForeach {
    /**
     * 先序遍历。
     */
    public static void pre(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node + " ");
        pre(node.left);
        pre(node.right);
    }

    /**
     * 后序遍历。
     */
    public static void post(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        post(node.left);
        post(node.right);
        System.out.print(node + " ");
    }

    /**
     * 中序遍历。
     */
    public static void mid(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        mid(node.left);
        System.out.print(node.val + " ");
        mid(node.right);
    }

    public static void midStack(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);
        List<BinaryTreeNode> foreachAlready = new LinkedList<>();
        while (!stack.isEmpty()) {
            final BinaryTreeNode element = stack.peek();
            if (element.left == null || (foreachAlready.contains(element.left) || foreachAlready.contains(element.right))) {
                System.out.print(element.val + " ");
                foreachAlready.add(element);
                stack.pop();
                if (element.right != null) {
                    stack.push(element.right);
                }
            } else {
                stack.push(element.left);
            }
        }
    }

    /**
     * 最好的非递归中序遍历。p相当于是一个当前的指针。用到了左边界。
     */
    public static void midStack2(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = node;
        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
    }

    /**
     * 不一样的后序输出，有点东西的骚东西。
     *
     * @param node 头结点
     */
    public static void postAmazing(BinaryTreeNode node) {
        BinaryTreeNode currentNode, beforeNode;
        beforeNode = node;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            currentNode = stack.peek();
            if (currentNode.left != null && currentNode.left != beforeNode && currentNode.right != beforeNode) {
                stack.push(currentNode.left);
            } else if (currentNode.right != null && currentNode.right != beforeNode) {
                stack.push(currentNode.right);
            } else {
                final BinaryTreeNode stackTopEle = stack.pop();
                System.out.print(stackTopEle.val + " ");
                beforeNode = stackTopEle;
            }
        }
    }

    /**
     * 按层遍历。
     */
    public static void layerForeach(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            final BinaryTreeNode element = queue.poll();
            if (element.left != null) {
                queue.add(element.left);
            }
            if (element.right != null) {
                queue.add(element.right);
            }
            System.out.print(element.val + " ");
        }
    }

    /**
     * 二叉树的最大宽度。新层到来，结算老层。
     */
    public static void maxWidth(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Map<BinaryTreeNode, Integer> map = new HashMap<>();
        queue.add(node);
        int curLevel = 1;
        int curLevelNodes = 1;
        int max = 0;
        map.put(node, curLevel);
        while (!queue.isEmpty()) {
            final BinaryTreeNode element = queue.poll();
            int curNodeLevel = map.get(element);
            if (element.left != null) {
                queue.add(element.left);
                map.put(element.left, curNodeLevel + 1);
            }
            if (element.right != null) {
                queue.add(element.right);
                map.put(element.right, curNodeLevel + 1);
            }

            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        System.out.println(Math.max(max, curLevelNodes));
    }

    /**
     * 二叉树的最大宽度。最优。
     */
    public static void maxWidth2(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);
        BinaryTreeNode curNode, nextNode;
        curNode = node;
        nextNode = null;
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            final BinaryTreeNode element = queue.poll();

            if (element.left != null) {
                queue.add(element.left);
                nextNode = element.left;
            }

            if (element.right != null) {
                queue.add(element.right);
                nextNode = element.right;
            }

            curLevelNodes++;
            if (curNode == element) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curNode = nextNode;
                nextNode = null;
            }
        }
        System.out.println(max);
    }
}
