package cn.keaper.p172;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void trailingZeroes() {
        System.out.println(solution.trailingZeroes(0));
        System.out.println(solution.trailingZeroes(1));
        System.out.println(solution.trailingZeroes(2));
        System.out.println(solution.trailingZeroes(30));
        System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(5*5));
        System.out.println(solution.trailingZeroes(5*5*5));
        System.out.println(solution.trailingZeroes(5*5*5*5));
        System.out.println(solution.trailingZeroes(5*5*5*5*5));
        System.out.println(solution.trailingZeroes(5*5*5*5*5*5));
        System.out.println(solution.trailingZeroes(5*5*5*5*5*5*5));
        System.out.println(solution.trailingZeroes(5*5*5*5*5*5*5*5));
        System.out.println(solution.trailingZeroes(2321321));
        System.out.println(solution.trailingZeroes(2147463647));
    }
}