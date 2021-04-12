package vip.wulang.leetcode.jianOffer;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution34 {
    class Solution {
        List<List<Integer>> result;
        LinkedList<Integer> sourceList;
        int target;

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) {
                return new ArrayList<>();
            }

            result = new LinkedList<>();
            this.target = target;
            sourceList = new LinkedList<>();
            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode node, int curVal) {
            sourceList.add(node.val);

            if (node.left == null && node.right == null && target == curVal + node.val) {
                result.add(new LinkedList<>(sourceList));
                sourceList.removeLast();
                return;
            }

            if (node.left == null && node.right == null) {
                sourceList.removeLast();
                return;
            }

            if (node.left != null) {
                dfs(node.left, curVal + node.val);
            }
            if (node.right != null) {
                dfs(node.right, curVal + node.val);
            }

            sourceList.removeLast();
        }
    }
}
