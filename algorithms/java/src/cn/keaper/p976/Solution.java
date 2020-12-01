package cn.keaper.p976;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */
public class Solution {

    /**
     * 能够组成三角形的条件是 a+b > c
     * 我们将数组排序，从后往前枚举最长边c，只需要判断能否与前两个元素组成三角形即可（之前的元素更小，不可能满足）
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i--){
            if(A[i] < A[i - 1] + A[i - 2]){
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

}
