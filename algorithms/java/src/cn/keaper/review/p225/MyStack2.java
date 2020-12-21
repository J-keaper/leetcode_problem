package cn.keaper.review.p225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {

    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack2() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        while (size-- > 1){
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        MyStack2 obj = new MyStack2();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.empty());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
