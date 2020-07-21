package cn.keaper.p47;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[] {1,1,2},
            new int[] {1,2,2},
            new int[] {1,1,2,3},
            new int[] {1,2,2,3,3},
            new int[] {1,2,3,4,4},
            new int[] {1,2,3,4,5},
            new int[] {1,1,2,2,4,4,5}
    );

    @Test
    public void permuteUnique() {
        cases.forEach(c -> {
            List<List<Integer>> res = solution.permuteUnique(c);
            res.forEach(arr -> {
                arr.forEach(i -> System.out.print(i + " "));
                System.out.println();
            });
            System.out.println("-------");
        });
    }
}