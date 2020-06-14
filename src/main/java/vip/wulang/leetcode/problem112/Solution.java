package vip.wulang.leetcode.problem112;

import vip.wulang.leetcode.structrue.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
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
