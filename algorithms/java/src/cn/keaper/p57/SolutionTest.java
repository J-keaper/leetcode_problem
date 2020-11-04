package cn.keaper.p57;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[][]> cases = Arrays.asList(
            new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16},{4,8}},
            new int[][]{{1,3},{6,9},{2,5}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {2,3}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {2,5}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {2,7}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {2,10}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {2,12}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {2,15}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {5,7}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {5,10}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {5,12}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {5,15}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {5,17}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {5,20}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {10,12}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {10,15}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {10,17}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {10,20}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {10,22}},
            new int[][]{{5,10},{15,20},{25,30},{35,40}, {10,25}}
            );

    @Test
    public void insert() {
        cases.forEach(c -> {
            int[][] res = solution.insert(Arrays.copyOf(c, c.length - 1),c[c.length-1]);
            int[][] res1 = solution.insert1(Arrays.copyOf(c, c.length - 1),c[c.length-1]);
            System.out.println(Arrays.deepToString(res));
            System.out.println(Arrays.deepToString(res1));
            System.out.println();

        });

    }
}