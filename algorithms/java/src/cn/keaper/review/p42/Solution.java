package cn.keaper.review.p42;

public class Solution {

    public int trap(int[] height) {
        int[] left = new int[height.length], right = new int[height.length];
        // 求每个数左边的最大值
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        // 求每个数右边的最大值
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int h = Math.min(left[i], right[i]); // 如果两边最大值都比高度高，那么可以储水
            if(h > height[i]){
                res += h - height[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

}