package vip.wulang.algorithm.tree.bt;

import vip.wulang.algorithm.tree.bt.structrue.BinaryTreeNode;

public class PrintBinaryTree {
    /**
     * 二叉搜索树的打印。
     *
     * @param len 一个结点数值固定多少长度
     */
    public static void printBy(BinaryTreeNode node, int len) {
        System.out.println("Binary Tree:");
        printBy(node, 0, len);
        System.out.println();
    }

    private static void printBy(BinaryTreeNode node, int height, int len) {
        if (node == null) {
            return;
        }

        printBy(node.right, height + 1, len);

        String val = node.val + "";
        int l = (len - val.length()) / 2;
        int r = len - l - val.length();
        System.out.println(getSpace(len * height) + getSpace(l) + val + getSpace(r));

        printBy(node.left, height + 1, len);
    }

    private static String getSpace(int num) {
        return " ".repeat(Math.max(0, num));
    }
}
