package cn.keaper.p215;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{4,2,3,5,7,6,9, 5},
            new int[]{1,2,4,5,3,2,3,5,6, 4},
            new int[]{1,2,4,6, 2}
    );

    @Test
    public void findKthLargest() {
        cases.forEach(c -> System.out.println(solution.findKthLargest(
                Arrays.copyOf(c, c.length - 1), c[c.length-1]
        )));

    }
    @Test
    public void findKthLargest1() {
        cases.forEach(c -> System.out.println(solution.findKthLargest1(
                Arrays.copyOf(c, c.length - 1), c[c.length-1]
        )));

    }

    @Test
    public void findKthLargest2() {
        cases.forEach(c -> System.out.println(solution.findKthLargest2(
                Arrays.copyOf(c, c.length - 1), c[c.length-1]
        )));
    }
}