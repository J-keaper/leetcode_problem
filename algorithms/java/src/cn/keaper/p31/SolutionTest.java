package cn.keaper.p31;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();
    private List<int[]> cases = Arrays.asList(
            new int[]{6,5,4,3,2,1},
            new int[]{1,2,3,4,5,6},
            new int[]{3,4,5,6,1,2},
            new int[]{1},
            new int[]{1,2},
            new int[]{2,1}
    );

    @Test
    public void nextPermutation() {
        cases.forEach(c -> {
            solution.nextPermutation(c);
            System.out.println(Arrays.toString(c));
        });

        int[] nums = new int[]{1,2,3,4,5,6};
        int[] copy = new int[]{1,2,3,4,5,6};
        do {
            System.out.println(Arrays.toString(nums));
            solution.nextPermutation(nums);
        } while (!Arrays.equals(nums,copy));
    }
}