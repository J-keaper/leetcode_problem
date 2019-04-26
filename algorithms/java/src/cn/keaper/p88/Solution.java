package cn.keaper.p88;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class Solution {
    /**
     * fill max(nums1,nums2) to nums1[] one by one from end to start
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1,j = n - 1, k = (m + n -1);
        while (i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while (i >= 0){
            nums1[k--] = nums1[i--];
        }
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}
