package cn.keaper.p1013;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    List<int[]> cases = Arrays.asList(
            new int[]{1,-1,1,-1},
            new int[]{0,0,0,0},
            new int[]{1,2,3,4,-5,10},
            new int[]{1,2,3,3,-12,1,2,3,1,2,3},
            new int[]{0,2,1,-6,6,-7,9,1,2,0,1},
            new int[]{0,2,1,-6,6,7,9,-1,2,0,1},
            new int[]{3,3,6,5,-2,2,5,1,-9,4}
    );

    @Test
    public void canThreePartsEqualSum() {
        cases.forEach(c -> System.out.println(solution.canThreePartsEqualSum(c)));
        System.out.println();
        cases.forEach(c -> System.out.println(solution.canThreePartsEqualSum1(c)));
    }
}