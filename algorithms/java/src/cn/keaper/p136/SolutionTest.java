package cn.keaper.p136;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
            new int[]{2,2,1},
            new int[]{2,3,2},
            new int[]{2,3,4,5,4,5,3},
            new int[]{1,1,1,2,2,2,2,1,1},
            new int[]{4,1,2,1,2},
            new int[]{1}
    );
    private Solution solution = new Solution();


    @Test
    public void singleNumber() {
        cases.forEach(c -> System.out.println(solution.singleNumber(c)));

    }
}