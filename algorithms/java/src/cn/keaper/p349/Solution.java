package cn.keaper.p349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class Solution {

    /**
     * Time complexity: O(N + M)
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


    /**
     * Time complexity: O(N*LogN + M*LogM)
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Integer.min(nums1.length,nums2.length)];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                if(k == 0 || res[k - 1] != nums1[i]){
                    res[k++] = nums1[i];
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOf(res,k);
    }



}
