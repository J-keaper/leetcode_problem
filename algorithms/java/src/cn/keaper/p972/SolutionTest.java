package cn.keaper.p972;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,1},
            new int[]{1,2},
            new int[]{4,2,5,7},
            new int[]{1,2,3,4,5,6,5,6,4,3,1,2},
            new int[]{1,2,3,5,4,6,7,8,10,9,11,12}
    );

    @Test
    public void sortArrayByParityII() {
        cases.forEach(c -> System.out.println(Arrays.toString(solution.sortArrayByParityII(c))));
    }
}