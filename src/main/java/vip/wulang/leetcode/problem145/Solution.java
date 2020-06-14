package vip.wulang.leetcode.problem145;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        postOrderForeach(root, l);
        return l;
    }

    private void postOrderForeach(TreeNode node, List<Integer> l) {
        if (node == null) {
            return;
        }

        postOrderForeach(node.left, l);
        postOrderForeach(node.right, l);
        l.add(node.val);
    }
}
