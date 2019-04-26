package cn.keaper.p119;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void getRow() {
        Solution solution = new Solution();
        for(int i = 0 ; i < 10 ; i ++){
            System.out.println(solution.getRow(i));
        }
    }

    @Test
    public void getRow1() {
        Solution solution = new Solution();
        for(int i = 0 ; i < 10 ; i ++){
            System.out.println(solution.getRow1(i));
        }
    }
}