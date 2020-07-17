package vip.wulang.leetcode.problem112;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<BInfo> queue = new LinkedList<>();
        queue.offer(new BInfo(root, root.val));
        while (!queue.isEmpty()) {
            BInfo poll = queue.poll();

            TreeNode left = poll.node.left;
            TreeNode right = poll.node.right;

            if (left == null && right == null) {
                if (poll.sum == sum) {
                    return true;
                }
                continue;
            }

            if (left != null) {
                queue.offer(new BInfo(left, poll.sum + left.val));
            }

            if (right != null) {
                queue.offer(new BInfo(right, poll.sum + right.val));
            }
        }
        return false;
    }

    private static class BInfo {
        public TreeNode node;
        public int sum;

        public BInfo(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return f(root, sum).find;
    }

    private static class Info {
        public boolean find;

        public Info(boolean find) {
            this.find = find;
        }
    }

    private Info f(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            sum -= node.val;
            return new Info(sum == 0);
        }

        Info left = null;
        if (node.left != null) {
            left = f(node.left, sum - node.val);
        }
        Info right = null;
        if (node.right != null) {
            right = f(node.right, sum - node.val);
        }

        if ((left != null && left.find) || (right != null && right.find)) {
            return new Info(true);
        } else {
            return new Info(false);
        }
    }
}
