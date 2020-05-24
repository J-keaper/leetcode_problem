package cn.keaper.p56;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{},
            new int[][]{{1,2}},
            new int[][]{{1,4},{2,3}},
            new int[][]{{1,4},{2,3},{3,10},{5,8},{6,9}},
            new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}},
            new int[][]{{1,3},{2,6},{8,10},{15,18}},
            new int[][]{{1,4},{4,5}}
    );

    @Test
    public void merge() {
        cases.forEach(c -> {
            int[][] res = solution.merge(c);
            for (int[] re : res) {
                System.out.println("[" + re[0] + "," + re[1] + "]");
            }
            System.out.println("============");
        });

    }
}