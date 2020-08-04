package vip.wulang.leetcode.jianOffer;

import vip.wulang.leetcode.structrue.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> recordIn = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            recordIn.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1, recordIn);
    }

    private TreeNode buildTree(int[] preorder, int startPre, int endPre, int startIn, int endIn, Map<Integer, Integer> recordIn) {
        if (startPre > endPre) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);
        if (startPre != endPre) {
            int index = recordIn.get(root.val);
            int leftNodes = index - startIn;
            int rightNodes = endIn - index;

            root.left = buildTree(preorder, startPre + 1, startPre + leftNodes, startIn, index - 1, recordIn);
            root.right = buildTree(preorder, startPre + leftNodes + 1, startPre + leftNodes + rightNodes, index + 1, endIn, recordIn);
        }
        return root;
    }


    public static void main(String[] args) {
//        new Solution07().buildTree(new int[]{7, -10, -4, 3, -1, 2, -8, 11}, new int[]{-4, -10, 3, -1, 7, 11, -8, 2});
        new Solution07().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
