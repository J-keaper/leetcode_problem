package cn.keaper.review.p128;

import java.util.HashSet;

public class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : nums) {
            if(set.contains(num)){
                int len = 1;
                set.remove(num);
                for (int i = num + 1; set.contains(i); i++,len++) {
                    set.remove(i);
                }
                for (int i = num - 1; set.contains(i); i--,len++) {
                    set.remove(i);
                }
                maxLength = Math.max(maxLength, len);
            }
        }
        return maxLength;
    }

}