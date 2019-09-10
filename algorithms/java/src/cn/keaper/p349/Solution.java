package cn.keaper.p349;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class Solution {

    /**
     * Time complexity: O(N + M)
     * Space complexity: O(N + M)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] res = new int[set2.size()];
        int r = 0;
        for (Integer integer : set2) {
            res[r++] = integer;
        }
        return res;
    }

}
