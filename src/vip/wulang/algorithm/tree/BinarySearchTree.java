package vip.wulang.algorithm.tree;

/**
 * 二叉查找树。
 */
public class BinarySearchTree {
    private BinaryTreeNode head;

    public void insert(int val) {
        //空结点
        if (head == null) {
            head = new BinaryTreeNode(val);
            return;
        }

        BinaryTreeNode p = head;
        while (true) {
            if (val > p.val) {
                if (p.right == null) {
                    p.right = new BinaryTreeNode(val);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new BinaryTreeNode(val);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int val) {
        if (head == null) {
            return;
        }

        BinaryTreeNode p = head;
        BinaryTreeNode pp;
        while (p.val != val) {
            pp = p;
            if (p.val > val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p.left != null && p.right != null) {
            BinaryTreeNode minNode = p.right;
            BinaryTreeNode minNodeP = p;
            while (minNode.left != null) {
                minNodeP = minNode;
                minNode = minNode.left;
            }


        }
    }
}
