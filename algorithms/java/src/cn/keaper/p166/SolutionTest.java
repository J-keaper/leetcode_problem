package cn.keaper.p166;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution = new Solution();

    private List<Integer> cases = Arrays.asList(
            1,2,
            2,1,
            2,3,
            5,7,
            -5,7,
            -5,-7,
            5,-7,
            22,7,
            25,6,
            25,17,
            0,4,
            25,8,
            -1, Integer.MIN_VALUE,
            1, Integer.MIN_VALUE,
            1, Integer.MAX_VALUE  //
    );

    @Test
    public void fractionToDecimal() {
        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(solution.fractionToDecimal(cases.get(i),cases.get(i+1)));
        }
    }

}