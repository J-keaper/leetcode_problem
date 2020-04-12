package cn.keaper.p365;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private int [] cases = new int[]{
            3,5,4,
            2,6,5

    };

    @Test
    public void canMeasureWater() {
        for (int i = 0; i < cases.length; i+=3) {
            System.out.println(solution.canMeasureWater(cases[i],cases[i+1],cases[i+2]));
        }
    }
}