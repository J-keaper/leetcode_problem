package cn.keaper.p274;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,1},
            new int[]{3,0,6,1,5},
            new int[]{3,0,0,0,0},
            new int[]{3,1,0,0,0},
            new int[]{3,2,0,0,0},
            new int[]{3,2,1,0,0},
            new int[]{0,0,0,0,0},
            new int[]{1},
            new int[]{1,2}
    );

    @Test
    public void hIndex() {
        cases.forEach(c -> {
            System.out.println(solution.hIndex(c));
            System.out.println(solution.hIndex1(c));
            System.out.println();
        });
    }
}