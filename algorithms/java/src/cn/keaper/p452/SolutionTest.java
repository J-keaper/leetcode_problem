package cn.keaper.p452;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{10,16},{2,8},{1,6},{7,12}},
            new int[][]{{1,2},{3,4},{5,6},{7,8}},
            new int[][]{{1,2},{2,3},{3,4},{4,5}},
            new int[][]{{1,2}},
            new int[][]{{2,3},{2,3}}
    );


    @Test
    public void findMinArrowShots() {
        cases.forEach(c -> System.out.println(solution.findMinArrowShots(c)));
    }
}