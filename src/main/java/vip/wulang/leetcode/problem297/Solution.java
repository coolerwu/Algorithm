package vip.wulang.leetcode.problem297;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        sb.append(serialize1(root));
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }

    private String serialize1(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            final TreeNode ele = queue.poll();
            if (ele == null) {
                sb.append("null,");
                continue;
            }

            if (ele.left == null && ele.right == null) {
                sb.append(ele.val).append(",");
                continue;
            }

            sb.append(ele.val).append(",");

            queue.add(ele.left);
            queue.add(ele.right);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node1;
        node1.left = node3;
        node1.right = node4;
        System.out.println(new Solution().serialize(node));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replaceAll("\\[", "]");
        if (data.isEmpty()) {
            return null;
        }
        TreeNode pre = null;
        int left = -1;
        for (String s : data.split(",")) {
            if (pre == null) {
                pre = new TreeNode(Integer.parseInt(s));
                continue;
            }
            if ("null".equals(s)) {
                if (left == -1) {
                    pre.left = null;
                    left = 1;
                } else {
                    pre.right = null;
                    left = -1;
                }
                continue;
            }
            if (left == -1) {
                pre.left = new TreeNode(Integer.parseInt(s));
                left = 1;
            } else if (left == 1) {
                pre.right = new TreeNode(Integer.parseInt(s));
                left = 2;
            } else {
                pre = pre.left == null ? pre.right : pre.left;
                left = -1;
            }
        }
        return pre;
    }
}