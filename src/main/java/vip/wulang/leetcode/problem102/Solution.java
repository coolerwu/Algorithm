package vip.wulang.leetcode.problem102;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode nextNode = null;
        TreeNode curNode = root;
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> line = new LinkedList<>();
        while (!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            line.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextNode = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextNode = node.right;
            }

            if (curNode == node && nextNode != null) {
                result.add(line);
                line = new LinkedList<>();
                curNode = nextNode;
                nextNode = null;
            }
        }
        result.add(line);
        return result;
    }
}
