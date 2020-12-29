package cn.keaper.p1046;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,7,4,1,8,1},
            new int[]{7,1,8,1},
            new int[]{2,7,3,8,2},
            new int[]{2,7,7,2,4},
            new int[]{2,7,7,2,4,3,2,4,5,65,3,34,2,32,3,32,454,65,7,67,6,34},
            new int[]{5,14}
    );

    @Test
    public void lastStoneWeight() {
        cases.forEach(c -> {
            System.out.println(solution.lastStoneWeight(c));
            System.out.println(solution.lastStoneWeight1(c));
            System.out.println();
        });
    }
}