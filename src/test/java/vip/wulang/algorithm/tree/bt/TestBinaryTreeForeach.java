package vip.wulang.algorithm.tree.bt;

import org.junit.Before;
import org.junit.Test;

public class TestBinaryTreeForeach {
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
    public void postAmazing() {
        BinaryTreeForeach.postAmazing(tree.getHead());
    }

    @Test
    public void layerForeach() {
        BinaryTreeForeach.layerForeach(tree.getHead());
    }

    @Test
    public void mid() {
        BinaryTreeForeach.mid(tree.getHead());
    }

    @Test
    public void midStack() {
        BinaryTreeForeach.midStack(tree.getHead());
    }

    @Test
    public void midStack2() {
        BinaryTreeForeach.midStack2(tree.getHead());
    }

    @Test
    public void maxWidth() {
        BinaryTreeForeach.maxWidth(tree.getHead());
    }

    @Test
    public void maxWidth2() {
        BinaryTreeForeach.maxWidth2(tree.getHead());
    }
}
