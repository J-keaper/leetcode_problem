package cn.keaper.p219;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    private List<Case> cases = Arrays.asList(
            new Case(new int[]{1,2,3,1},3),
            new Case(new int[]{1,0,1,1},1),
            new Case(new int[]{1,2,3,1,2,3},2),
            new Case(new int[]{1,2,3,1,1},2),
            new Case(new int[]{1,2,3,1,2,1},2),
            new Case(new int[]{1,2,3,1,2,1},0),
            new Case(new int[]{2147483647,-2147483648,2147483647,-2147483648},2)
    );

    private Solution solution = new Solution();

    @Test
    public void containsNearbyDuplicate() {
        cases.forEach(c -> {
            System.out.println(solution.containsNearbyDuplicate(c.nums,c.k));
            System.out.println("==========");
        });
    }

    @Test
    public void containsNearbyDuplicate3() {
        cases.forEach(c -> {
            System.out.println(solution.containsNearbyDuplicate3(c.nums,c.k));
            System.out.println("==========");
        });
    }


    private class Case{
        int[] nums;
        int k;
        Case(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
        }
    }
}