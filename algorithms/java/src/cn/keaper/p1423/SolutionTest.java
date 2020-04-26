package cn.keaper.p1423;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
//            new int[]{1,2,3,4,5,6,1,3},
//            new int[]{2,2,2,2},
//            new int[]{9,7,7,9,7,7,9,7},
//            new int[]{1,1000,1,1},
//            new int[]{1,79,80,1,1,1,200,1,3},
            new int[]{96,90,41,82,39,74,64,50,30,8}
    );

    @Test
    public void maxScore() {
        cases.forEach(c -> System.out.println(solution.maxScore(
                Arrays.copyOf(c, c.length - 1), c[c.length - 1])));

    }
}