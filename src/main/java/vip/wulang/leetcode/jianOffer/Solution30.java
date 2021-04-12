package vip.wulang.leetcode.jianOffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author CoolerWu
 * @version 1.0
 * @since 2021/4/10
 */
public class Solution30 {
}

class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty()) {
            minStack.push(x);
            return;
        }

        Integer min = minStack.peek();
        if (min != null) {
            if (min > x) {
                minStack.push(x);
            } else {
                minStack.push(min);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
