package cn.keaper.p135;


/**
 * https://leetcode.com/problems/candy/
 */
public class Solution {


    /**
     * Time： O(N)
     * Space: O(N)
     * 第一种方法的优化，只要一个方向上的数组即可，另一个方向可以一边遍历一边求值
     *
     */
    public int candy(int[] ratings) {
        if(ratings.length == 0){
            return 0;
        }
        int[] left = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            left[i] = (i == 0 || ratings[i] <= ratings[i-1]) ? 1 : left[i-1]+1;
        }
        int sum = 0;
        int right = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            right = (i == ratings.length - 1 || ratings[i] <= ratings[i+1]) ? 1 : right + 1;
            sum += Math.max(left[i], right);
        }
        return sum;
    }


    /**
     * Time： O(N)
     * Space: O(N)
     *
     * 数组left用来存储每名学生只与左边邻居有关的所需糖果数。
     * 数组right用来保存只与右边邻居有关的所需糖果数。
     *
     * left数组计算方式为，如果当前学生比左边相邻学生的评分高，那么糖果数等于左边相邻学生的糖果数+1，否则只给一个
     * right数组类似
     *
     * 最后每个位置需要的糖果数为left和right中的最大值，这样可以同时满足两个条件。
     *
     */
    public int candy1(int[] ratings) {
        if(ratings.length == 0){
            return 0;
        }
        int[] left = new int[ratings.length], right = new int[ratings.length];
        left[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            left[i] = ratings[i] > ratings[i-1] ? left[i-1]+1 : 1;
        }
        right[ratings.length - 1] = 1;
        for (int i = ratings.length - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i+1] ? right[i+1] + 1 : 1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

}
