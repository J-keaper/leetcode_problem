package cn.keaper.p232;

import org.junit.Test;

public class MyQueueTest {


    @Test
    public void test(){
        MyQueue1 obj = new MyQueue1();
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