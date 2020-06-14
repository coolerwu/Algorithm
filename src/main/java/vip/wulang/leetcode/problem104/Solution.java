package vip.wulang.leetcode.problem104;

import vip.wulang.leetcode.structrue.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return preForeach(root, 1);
    }

    private int preForeach(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }

        int depthL = Math.max(preForeach(node.left, depth + 1), depth);
        depthL = Math.max(preForeach(node.right, depth + 1), depthL);
        return depthL;
    }
}
