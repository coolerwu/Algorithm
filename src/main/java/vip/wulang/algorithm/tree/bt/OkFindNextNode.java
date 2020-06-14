package vip.wulang.algorithm.tree.bt;

import vip.wulang.algorithm.tree.bt.structrue.BinaryTreeNode;

public class OkFindNextNode {
    /**
     * 找到该结点的直接后继。
     * 注意：构造的时候，parent结点一定会赋值。
     */
    public static BinaryTreeNode getNextNode(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return getNextNodeWhenRightNode(node.right);
        } else {
            // 如果右子树为空，则找左边最后一个结点。
            // 即，当前结点为父亲的左结点，则父亲是后继结点。
            // 否则，循环找到结点为父亲的左结点为止。
            BinaryTreeNode p = node;
            BinaryTreeNode pp = p.parent;
            while (pp != null && pp.left != p) {
                p = pp;
                pp = p.parent;
            }
            return pp;
        }
    }

    private static BinaryTreeNode getNextNodeWhenRightNode(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
