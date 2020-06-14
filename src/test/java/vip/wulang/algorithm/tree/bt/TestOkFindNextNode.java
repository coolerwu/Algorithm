package vip.wulang.algorithm.tree.bt;

import org.junit.Before;
import org.junit.Test;

public class TestOkFindNextNode {

    private BinarySearchTree tree;

    @Before
    public void init() {
        tree = new BinarySearchTree();
        tree.insert(6);

        // left
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);

        // right
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);
    }

    @Test
    public void getNextNode() {
        System.out.println(OkFindNextNode.getNextNode(tree.getHead().left).val);
    }
}
