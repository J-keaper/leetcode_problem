package cn.keaper.p15;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{-1, 0, 1, 2, -1, -4},
            new int[]{-4, -1, -1, 0, 1, 2},
            new int[]{},
            new int[]{}
    );

    @Test
    public void threeSum() {
        cases.forEach(c -> {
            List<List<Integer>> res = solution.threeSum(c);
            for (List<Integer> r : res) {
                System.out.print("[");
                r.forEach(i -> System.out.print(i + ","));
                System.out.print("],");
            }
            System.out.println();
        });

    }
}