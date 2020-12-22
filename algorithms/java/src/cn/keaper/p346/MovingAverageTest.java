package cn.keaper.p346;

import org.junit.Test;

public class MovingAverageTest {


    @Test
    public void MovingAverage() {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
        System.out.println(m.next(3));
    }


    @Test
    public void MovingAverage1() {
        MovingAverage1 m = new MovingAverage1(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
        System.out.println(m.next(3));
    }
}