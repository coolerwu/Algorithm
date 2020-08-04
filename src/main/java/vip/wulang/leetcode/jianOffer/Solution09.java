package vip.wulang.leetcode.jianOffer;

import java.util.Stack;

public class Solution09 {

}


class CQueue {
    private final Stack<Integer> one;
    private final Stack<Integer> two;

    public CQueue() {
        one = new Stack<>();
        two = new Stack<>();
    }

    public void appendTail(int value) {
        one.push(value);
    }

    public int deleteHead() {
        if (two.isEmpty()) {
            while (!one.isEmpty()) {
                two.push(one.pop());
            }
        }

        return two.isEmpty() ? -1 : two.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */