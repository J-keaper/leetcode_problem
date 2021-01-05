package cn.keaper.p435;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
        new int[][]{{1,2},{2,3},{3,4},{1,3}},
        new int[][]{{1,2},{1,2},{1,2}},
        new int[][]{{1,2},{2,3}}

    );


    @Test
    public void eraseOverlapIntervals() {
        cases.forEach(c -> System.out.println(solution.eraseOverlapIntervals(c)));
    }
}