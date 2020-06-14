package vip.wulang.leetcode.problem144;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        preForeach(root, l);
        return l;
    }

    private void preForeach(TreeNode node, List<Integer> l) {
        if (node == null) {
            return;
        }

        l.add(node.val);
        preForeach(node.left, l);
        preForeach(node.right, l);
    }
}
