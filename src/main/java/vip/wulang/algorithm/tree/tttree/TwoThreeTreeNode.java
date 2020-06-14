package vip.wulang.algorithm.tree.tttree;

import java.util.List;

/**
 * 2-3树的数据结构。
 */
public class TwoThreeTreeNode {
    public List<Integer> valL;
    public List<TwoThreeTreeNode> children;

    public TwoThreeTreeNode(List<Integer> valL, List<TwoThreeTreeNode> children) {
        this.valL = valL;
        this.children = children;
    }
}
