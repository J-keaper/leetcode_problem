package cn.keaper.p220;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{-1,-1, 1, -1},
            new int[]{ 1,2},
            new int[]{1, 1,2},
            new int[]{1,2, 1,2},
            new int[]{1,3, 1,1},
            new int[]{1,2,3,1, 3,0},
            new int[]{1,0,1,1, 1,2},
            new int[]{1,5,9,1,5,9, 2,3},
            new int[]{-1,2147483647, 1,2147483647}
    );


    @Test
    public void containsNearbyAlmostDuplicate() {
        cases.forEach(c -> {
            System.out.println(solution.containsNearbyAlmostDuplicate(
                    Arrays.copyOf(c, c.length - 2),c[c.length-2], c[c.length-1]));
            System.out.println(solution.containsNearbyAlmostDuplicate1(
                    Arrays.copyOf(c, c.length - 2),c[c.length-2], c[c.length-1]));
        });

    }
}