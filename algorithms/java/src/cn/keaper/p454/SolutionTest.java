package cn.keaper.p454;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{1,2},{-2,-1},{-1,2},{0,2}},
            new int[][]{{1,2,0},{-2,-1,0},{-1,2,1},{0,2,-1,2}}
    );

    @Test
    public void fourSumCount() {
        cases.forEach(c -> {
            System.out.println(solution.fourSumCount(c[0],c[1],c[2],c[3]));
            System.out.println(solution.fourSumCount1(c[0],c[1],c[2],c[3]));
            System.out.println();
        });
    }
}