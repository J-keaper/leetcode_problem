package cn.keaper.p78;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {


    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{},
            new int[]{1},
            new int[]{1,2},
            new int[]{1,2,3}
    );

    @Test
    public void subsets() {
        cases.forEach(c -> {
            List<List<Integer>> res = solution.subsets(c);
            for (List<Integer> s : res) {
                s.forEach(i -> System.out.print(i + " "));
                System.out.println();
            }
            System.out.println("----------");
        });
    }
}