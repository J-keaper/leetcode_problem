package cn.keaper.p406;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}},
            new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}}
    );


    @Test
    public void reconstructQueue() {
        cases.forEach(c -> System.out.println(Arrays.deepToString(solution.reconstructQueue(c))));
    }
}