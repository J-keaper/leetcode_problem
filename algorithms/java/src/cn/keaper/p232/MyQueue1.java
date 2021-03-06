package cn.keaper.p232;

import java.util.Stack;

public class MyQueue1 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int peek;

    /** Initialize your data structure here. */
    public MyQueue1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()){
            peek = x;
        }
        s1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.add(s1.pop());
            }
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        return !s2.isEmpty() ? s2.peek() : peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
