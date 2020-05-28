package cn.keaper.p547;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{
                    {1,1,0},
                    {1,1,0},
                    {0,0,1}},
            new int[][]{
                    {1,1,0},
                    {1,1,1},
                    {0,1,1}}
    );

    @Test
    public void findCircleNum() {
        cases.forEach(c -> System.out.println(solution.findCircleNum(c)));

    }
}