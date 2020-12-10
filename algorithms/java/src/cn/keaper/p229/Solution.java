package cn.keaper.p229;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/submissions/
 */
public class Solution {

    /**
     * Boyer-Moore 投票算法 的进阶版
     * 维护两个数和各自的数量，如果等于加一，不等减一
     * 最后看两个数是否符合条件即可
     * 与 p169 不同的是，169题保证了结果一定存在，而此题没有
     */
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int num1 = 0, num2 = 1;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if(num == num1) count1++;
            if(num == num2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length / 3){
            res.add(num1);
        }
        if(count2 > nums.length / 3){
            res.add(num2);
        }
        return res;
    }
}
