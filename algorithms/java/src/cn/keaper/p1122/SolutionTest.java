package cn.keaper.p1122;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<int[]> cases = Arrays.asList(
            new int[]{2,3,1,3,2,4,6,7,9,2,19},
            new int[]{2,1,4,3,9,6}

    );

    @Test
    public void relativeSortArray() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(Arrays.toString(solution.relativeSortArray(cases.get(i), cases.get(i + 1))));
            System.out.println(Arrays.toString(solution.relativeSortArray1(cases.get(i), cases.get(i + 1))));
            System.out.println(Arrays.toString(solution.relativeSortArray2(cases.get(i), cases.get(i + 1))));
        }
    }
}