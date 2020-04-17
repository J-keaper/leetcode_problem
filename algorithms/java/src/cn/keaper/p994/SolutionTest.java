package cn.keaper.p994;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{2,1,1},{1,1,0},{0,1,1}},
            new int[][]{{2,1,1},{1,1,0},{0,0,0}},
            new int[][]{{2,1,1},{0,1,1},{1,0,1}},
            new int[][]{{0,2}}
    );
    @Test
    public void orangesRotting() {
        cases.forEach(c -> System.out.println(solution.orangesRotting(c)));

    }

    @Test
    public void orangesRotting1() {
        cases.forEach(c -> System.out.println(solution.orangesRotting1(c)));

    }
}