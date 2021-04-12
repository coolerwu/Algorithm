package vip.wulang.leetcode.structrue;

/**
 * @author CoolerWu
 * @version 1.0
 * @since 2021/4/10
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}