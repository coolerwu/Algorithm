package vip.wulang.leetcode.problem105;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.HashMap;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inMap, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int startPre, int endPre, HashMap<Integer, Integer> inMap, int startIn, int endIn) {
        if (startPre > endPre) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[startPre]);
        if (startPre != endPre) {
            Integer indexVal = inMap.get(node.val);
            int leftNodes = indexVal - startIn;
            int rightNodes = endIn - indexVal;

            node.left = buildTree(preorder, startPre + 1, startPre + leftNodes, inMap, startIn, indexVal - 1);
            node.right = buildTree(preorder, startPre + leftNodes + 1, startPre + leftNodes + rightNodes, inMap, indexVal + 1, endIn);
        }

        return node;
    }
}