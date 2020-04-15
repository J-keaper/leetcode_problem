package cn.keaper.p892;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{2}},
            new int[][]{{1,2},{3,4}},
            new int[][]{{1,0},{0,2}},
            new int[][]{{1,1,1},{1,0,1},{1,1,1}},
            new int[][]{{2,2,2},{2,1,2},{2,2,2}}
    );

    @Test
    public void surfaceArea() {
        cases.forEach(c -> {
            System.out.println(solution.surfaceArea(c));
        });

    }

    @Test
    public void surfaceArea1() {
        cases.forEach(c -> {
            System.out.println(solution.surfaceArea1(c));
        });

    }

}