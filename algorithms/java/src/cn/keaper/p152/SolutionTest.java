package cn.keaper.p152;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,3,-2,4},
            new int[]{-2,0,-1}

            );

    @Test
    public void maxProduct() {
        cases.forEach(c -> {
            System.out.println(solution.maxProduct(c));
        });
    }
}