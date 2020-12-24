package cn.keaper.p455;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3},
            new int[]{1,1},
            new int[]{1,2},
            new int[]{1,2,3},
            new int[]{10,9,8,7},
            new int[]{5,6,7,8}
    );


    @Test
    public void findContentChildren() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.findContentChildren(cases.get(i), cases.get(i+1)));
        }
    }
}