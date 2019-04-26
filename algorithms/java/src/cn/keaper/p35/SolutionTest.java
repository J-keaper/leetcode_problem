package cn.keaper.p35;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void searchInsert() {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6},7));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6},0));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6},1));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6},4));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6,7},4));
        System.out.println(solution.searchInsert(new int[]{1},4));
        System.out.println(solution.searchInsert(new int[]{},4));
    }

    @Test
    public void searchInsert2() {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert2(new int[]{1,3,5,6},5));
        System.out.println(solution.searchInsert2(new int[]{1,3,5,6},2));
        System.out.println(solution.searchInsert2(new int[]{1,3,5,6},7));
        System.out.println(solution.searchInsert2(new int[]{1,3,5,6},0));
        System.out.println(solution.searchInsert2(new int[]{1,3,5,6},1));
        System.out.println(solution.searchInsert2(new int[]{1,3,5,6},4));
        System.out.println(solution.searchInsert2(new int[]{1,3,5,6,7},4));
        System.out.println(solution.searchInsert2(new int[]{1},4));
        System.out.println(solution.searchInsert2(new int[]{},4));
    }
}