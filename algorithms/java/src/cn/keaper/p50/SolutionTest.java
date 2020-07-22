package cn.keaper.p50;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();


    @Test
    public void myPow() {
        System.out.println(solution.myPow(2.0, 10));
        System.out.println(solution.myPow(2.1, 3));
        System.out.println(solution.myPow(2.0, -2));
        System.out.println(solution.myPow(2.0, 0));
        System.out.println(solution.myPow(-99.99, Integer.MAX_VALUE));
        System.out.println(solution.myPow(99.99, Integer.MIN_VALUE));
        System.out.println(solution.myPow(99.99, Integer.MAX_VALUE));
        System.out.println(solution.myPow(-99.99, Integer.MIN_VALUE));
    }

}