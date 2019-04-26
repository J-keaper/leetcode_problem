package cn.keaper.p53;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxSubArray() {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{-2,-3,-5}));
        System.out.println(solution.maxSubArray(new int[]{0,-2,-3}));
        System.out.println(solution.maxSubArray(new int[]{1,2,3,4,-5,6}));
    }

    @Test
    public void maxSubArray2() {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray2(new int[]{-2,-3,-5}));
        System.out.println(solution.maxSubArray2(new int[]{0,-2,-3}));
        System.out.println(solution.maxSubArray2(new int[]{1,2,3,4,-5,6}));
    }
}