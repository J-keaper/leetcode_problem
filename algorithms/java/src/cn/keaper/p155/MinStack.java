package cn.keaper.p155;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        min.push(min.isEmpty() ? x : Integer.min(min.peek(),x));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}