package cn.keaper.review.p232;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    private Deque<Integer> s1 = new LinkedList<>();
    private Deque<Integer> s2 = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s1.isEmpty()){
            s2.push(s1.poll());
        }
        s1.push(x);
        while (!s2.isEmpty()){
            s1.push(s2.poll());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.empty());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
