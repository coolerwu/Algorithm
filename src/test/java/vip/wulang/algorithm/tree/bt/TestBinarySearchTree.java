package vip.wulang.algorithm.tree.bt;

import org.junit.Test;

public class TestBinarySearchTree {
    @Test
    public void badInsert() {
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
}
