package vip.wulang.leetcode.jianOffer;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CoolerWu
 * @version 1.0
 * @since 2021/4/13
 */
public class Solution37 {
    public static void main(String[] args) {
        TreeNode deserialize = new Codec().deserialize("[1,null,2]");
        System.out.println(new Codec().serialize(deserialize));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return new ArrayList<>().toString();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelIterator = 0;
        int nullNextIterator = 0;
        int levelCount = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null").append(",");
            } else {
                sb.append(node.val).append(",");

                if (node.left != null) {
                    queue.add(node.left);
                } else {
                    queue.add(null);
                    nullNextIterator++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                } else {
                    queue.add(null);
                    nullNextIterator++;
                }
            }

            levelIterator++;
            if (levelIterator == levelCount) {
                levelCount = queue.size();
                levelIterator = 0;
                if (nullNextIterator == queue.size()) {
                    break;
                }
                nullNextIterator = 0;
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isBlank() || "[]".equals(data)) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int index = 1;
        int levelCount = 2;
        int cursor = 0;

        while (!queue.isEmpty() && index < split.length) {
            TreeNode parent;
            if (index % 2 == 0) {
                parent = queue.poll();
            } else {
                parent = queue.peek();
            }

            if ("null".equals(split[index])) {
                index++;
                continue;
            }

            TreeNode node = new TreeNode(Integer.parseInt(split[index]));
            if (index % 2 == 0) {
                parent.right = node;
            } else {
                parent.left = node;
            }
            index++;
            queue.add(node);
            cursor++;
            if (cursor == levelCount) {
                levelCount = cursor * 2;
                cursor = 0;
            }
        }

        return root;
    }
}