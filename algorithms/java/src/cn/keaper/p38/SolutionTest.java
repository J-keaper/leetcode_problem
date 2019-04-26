package cn.keaper.p38;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void countAndSay() {
        Solution solution = new Solution();
        for(int i = 1 ; i <= 30 ; i ++){
            System.out.println(solution.countAndSay(i));
        }
    }

}