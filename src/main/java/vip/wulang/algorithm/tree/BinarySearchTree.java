package vip.wulang.algorithm.tree;

/**
 * 二叉查找树。
 */
public class BinarySearchTree {
    private BinaryTreeNode head;

    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();

        // 有序的插入，直接让二叉树的时间复杂度变为最差。
        searchTree.insert(1);
        searchTree.insert(2);
        searchTree.insert(3);
        searchTree.insert(4);
        searchTree.insert(5);
        searchTree.insert(6);
        searchTree.search(6);

        searchTree.delete(6);
        searchTree.delete(2);
        searchTree.delete(3);
        searchTree.delete(4);
        searchTree.delete(5);
        searchTree.search(1);
        searchTree.delete(1);

        searchTree.insert(1);
        searchTree.insert(2);
        searchTree.insert(3);
        searchTree.insert(4);
        searchTree.insert(5);
        searchTree.insert(6);
        System.out.println(searchTree);
    }

    public BinaryTreeNode search(int val) {
        if (head == null) {
            return null;
        }

        int cycleCount = 1;
        BinaryTreeNode p = head;
        while (val != p.val) {
            if (val > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
            if (p == null) {
                return null;
            }
            cycleCount++;
        }
        System.out.println("find cost " + cycleCount + " time");
        return p;
    }

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
                    p.right.parent = p;
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new BinaryTreeNode(val);
                    p.left.parent = p;
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
        BinaryTreeNode pp = null;
        while (p.val != val) {
            pp = p;
            if (val > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
            if (p == null) {
                return;
            }
        }

        // 如果没有结点
        if (p.left == null && p.right == null) {
            if (pp == null) {
                head = null;
                return;
            }
            if (pp.left == p) {
                pp.left = null;
            } else {
                pp.right = null;
            }
            p.parent = null;
            return;
        }

        // 如果只有一个子结点
        if (p.left == null || p.right == null) {
            if (p.left != null) {
                if (pp == null) {
                    head = p.left;
                    p.left = null;
                    return;
                }
                if (pp.left == p) {
                    pp.left = p.left;
                } else {
                    pp.right = p.left;
                }
                p.left.parent = pp;
                p.left = null;
            } else {
                if (pp == null) {
                    head = p.right;
                    p.right = null;
                    return;
                }
                if (pp.left == p) {
                    pp.left = p.right;
                } else {
                    pp.right = p.right;
                }
                p.right.parent = pp;
                p.right = null;
            }
            p.parent = null;
            return;
        }

        // 如果有两个子结点，找到该结点的直接后继结点
        BinaryTreeNode minNode = p.right;
        BinaryTreeNode minNodeP = p;
        while (minNode.left != null) {
            minNodeP = minNode;
            minNode = minNode.left;
        }
        // 替换值，等于删除
        p.val = minNode.val;

        minNodeP.left = minNode.right;
        minNode.right.parent = minNodeP;
        minNode.parent = null;
        minNode.right = null;
    }
}
