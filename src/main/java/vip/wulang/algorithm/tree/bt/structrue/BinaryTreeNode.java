package vip.wulang.algorithm.tree.bt.structrue;

/**
 * 二叉树的结点。
 */
public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode parent;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }
}
