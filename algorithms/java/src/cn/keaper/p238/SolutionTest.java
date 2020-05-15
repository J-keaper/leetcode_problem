package cn.keaper.p238;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,3},
            new int[]{2,0,1,3,0},
            new int[]{2,0,1,3},
            new int[]{1,2,3,4}
    );


    @Test
    public void productExceptSelf() {
        cases.forEach(c -> {
            System.out.println(Arrays.toString(solution.productExceptSelf(c)));
            System.out.println(Arrays.toString(solution.productExceptSelf1(c)));
        });
    }
}