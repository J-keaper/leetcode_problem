package cn.keaper.p155;

import org.junit.Test;

public class MinStackTest {

    @Test
    public void test(){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

}