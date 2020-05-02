package cn.keaper.p80;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,1,1,2,2,3},
            new int[]{0,0,1,1,1,1,2,3,3}
    );

    @Test
    public void removeDuplicates() {
        cases.forEach(c -> {
            int newCount = solution.removeDuplicates(c);
            System.out.println(Arrays.toString(Arrays.copyOf(c, newCount)));
        });

    }
}