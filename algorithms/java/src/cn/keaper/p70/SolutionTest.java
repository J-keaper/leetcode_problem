package cn.keaper.p70;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void climbStairs() {
        Solution solution = new Solution();
        for (int i = 1 ; i < 45 ; i ++){
            System.out.println(solution.climbStairs(i));
        }
    }
}