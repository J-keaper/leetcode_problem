package cn.keaper.p75;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,0,2,1,1,0},
            new int[]{2,0,1}
    );

    @Test
    public void sortColors() {
        cases.forEach(c -> {
            solution.sortColors(c);
            System.out.println(Arrays.toString(c));
        });

    }
}