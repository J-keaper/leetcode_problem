package cn.keaper.p659;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,3,4,5},
            new int[]{1,2,3,3,4,4,5,5},
            new int[]{1,2,3,4,4,5}
    );

    @Test
    public void isPossible() {
        cases.forEach(c -> {
            System.out.println(solution.isPossible(c));
            System.out.println(solution.isPossible2(c));
            System.out.println();
        });
    }
}