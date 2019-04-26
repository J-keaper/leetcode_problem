package cn.keaper.p69;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void mySqrt() {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(Integer.MAX_VALUE));
        for(int i = 0 ; i <= 100 ; i ++){
            System.out.println(i + " -> " + solution.mySqrt(i));
        }
    }
}