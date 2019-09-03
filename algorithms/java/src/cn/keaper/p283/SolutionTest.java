package cn.keaper.p283;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
            new int[]{0,1,0,3,12},
            new int[]{0,1},
            new int[]{2,3,4,0,20,30,40},
            new int[]{2,3,4,0,0,0},
            new int[]{0,0,0,2,3,4}
    );

    private Solution solution = new Solution();

    @Test
    public void moveZeroes() {
        cases.forEach(c -> {
            System.out.println(Arrays.toString(c));
            solution.moveZeroes(c);
            System.out.println(Arrays.toString(c));
        });
    }
}