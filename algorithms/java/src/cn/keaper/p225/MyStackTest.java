package cn.keaper.p225;

import org.junit.Test;

public class MyStackTest {


    @Test
    public void test() {
//        MyStack obj = new MyStack();
//        MyStack1 obj = new MyStack1();
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