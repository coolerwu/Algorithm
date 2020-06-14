package vip.wulang.leetcode.problem101;

import vip.wulang.leetcode.structrue.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
