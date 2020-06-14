package vip.wulang.leetcode.problem94;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        inorderForeach(root, l);
        return l;
    }

    private void inorderForeach(TreeNode node, List<Integer> l) {
        if (node == null) {
            return;
        }

        inorderForeach(node.left, l);
        l.add(node.val);
        inorderForeach(node.right, l);
    }
}
