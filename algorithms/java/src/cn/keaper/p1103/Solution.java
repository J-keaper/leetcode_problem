package cn.keaper.p1103;

/**
 * https://leetcode.com/problems/distribute-candies-to-people/
 */
public class Solution {


    /**
     * 模拟，循环遍历分糖果
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            int count = Math.min(candies, i + 1);
            ans [i % num_people] += count;
            candies -= count;
            i++;
        }
        return ans;
    }
}
