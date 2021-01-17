package cn.keaper.p347;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();


    private List<int[]> cases = Arrays.asList(
            new int[]{1,1,1,2,2,3, 2},
            new int[]{1,1,1,2,2,2,3, 2},
            new int[]{1,1,1,2,2,3,3,3, 2},
            new int[]{3,0,1,0, 1},
            new int[]{4,1,-1,2,-1,2,3, 2},
            new int[]{1, 1}
    );

    @Test
    public void topKFrequent() {
        cases.forEach(c -> {
            System.out.println(Arrays.toString(solution.topKFrequent(Arrays.copyOf(c, c.length - 1), c[c.length - 1])));
        });
    }
}