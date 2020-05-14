package cn.keaper.p134;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,4,5},
            new int[]{3,4,5,1,2},
            new int[]{2,3,4},
            new int[]{3,4,3}
            );

    @Test
    public void canCompleteCircuit() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.canCompleteCircuit(cases.get(i),cases.get(i+1)));
        }
    }
}