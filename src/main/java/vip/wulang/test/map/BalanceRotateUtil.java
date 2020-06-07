package vip.wulang.test.map;

import vip.wulang.algorithm.tree.bt.structrue.BinaryTreeNode;

public class BalanceRotateUtil {
    /**
     * 左旋转。
     *
     * @param concernedNode 关注结点
     */
    public static void leftRotate(BinaryTreeNode concernedNode) {
        BinaryTreeNode concernedRightNode = concernedNode.right;
        BinaryTreeNode left = concernedRightNode.left;
        concernedRightNode.parent = concernedNode.parent;
        concernedNode.parent = concernedRightNode;
        concernedRightNode.left = concernedNode;
        concernedNode.right = left;
        left.parent = concernedNode;
    }
}
