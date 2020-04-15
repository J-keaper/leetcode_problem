package cn.keaper.p836;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{0,0,2,2},
            new int[]{1,1,3,3},
            new int[]{0,0,1,1},
            new int[]{1,0,2,1}
    );

    @Test
    public void isRectangleOverlap() {
        for (int i = 0; i < cases.size(); i += 2) {
            System.out.println(solution.isRectangleOverlap(cases.get(i),cases.get(i+1)));
        }
    }

    @Test
    public void isRectangleOverlap1() {
        for (int i = 0; i < cases.size(); i += 2) {
            System.out.println(solution.isRectangleOverlap(cases.get(i),cases.get(i+1)));
        }
    }
}