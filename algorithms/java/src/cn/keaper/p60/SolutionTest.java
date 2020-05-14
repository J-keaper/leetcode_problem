package cn.keaper.p60;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{5,96},
            new int[]{3,3},
            new int[]{4,9},
            new int[]{5,34}
    );

    @Test
    public void getPermutation() {
        cases.forEach(c -> {
            String s = solution.getPermutation(c[0], c[1]);
            System.out.print(s + "\t");
            int k = solution.getPermutationSerial(c[0], s);
            System.out.println(k == c[1]);
        });
    }

}