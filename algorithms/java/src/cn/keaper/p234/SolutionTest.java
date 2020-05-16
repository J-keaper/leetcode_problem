package cn.keaper.p234;

import cn.keaper.utils.list.integer.ListBuilder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<int[]> cases = Arrays.asList(
            new int[]{1,2,3,4,5,6,7,8},
            new int[]{1,2,3,4,5,6,7},
            new int[]{1,2,3,4,4,3,2,1},
            new int[]{1,2,3,4,3,3,2,1},
            new int[]{1,2,3,4,3,2,1},
            new int[]{1,2,3,4,4,2,1},
            new int[]{2,2,2,2,2,2,2,2,2},
            new int[]{1,2,3},
            new int[]{1,2,1},
            new int[]{1,2},
            new int[]{1,1},
            new int[]{1},
            new int[]{}
    );

    private Solution solution = new Solution();

    @Test
    public void isPalindrome() {
        cases.forEach(c -> System.out.println(Arrays.toString(c) + " -> " + solution.isPalindrome(ListBuilder.build(c))));
    }

    @Test
    public void isPalindrome2() {
        cases.forEach(c -> System.out.println(Arrays.toString(c) + " -> " + solution.isPalindrome2(ListBuilder.build(c))));
    }
}