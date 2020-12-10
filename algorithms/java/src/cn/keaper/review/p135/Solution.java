package cn.keaper.review.p135;

public class Solution {


    public int candy(int[] ratings) {
        int[] left = new int[ratings.length], right = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            left[i] = i == 0 ? 1 : (ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1);
        }

        for (int i = ratings.length - 1; i >= 0; i--) {
            right[i] = i == ratings.length - 1 ? 1 : (ratings[i] > ratings[i+1] ? right[i+1] + 1 : 1);
        }

        int res = 0;
        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1,0,2}));
        System.out.println(new Solution().candy(new int[]{1,2,2}));
    }
}
