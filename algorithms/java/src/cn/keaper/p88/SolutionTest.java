package cn.keaper.p88;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void merge() {
        Solution solution = new Solution();
        int[] a = new int[]{1,2};
        int[] b = new int[]{};
        solution.merge(a,a.length-b.length,b,b.length);
        System.out.println(Arrays.toString(a));
    }
}