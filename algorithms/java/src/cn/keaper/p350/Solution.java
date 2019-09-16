package cn.keaper.p350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class Solution {

    /**
     * Time complexity: average O(N + M) ,worst O(N*LogN + M*LogM)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        int [] res = new int[Integer.min(nums1.length,nums2.length)];
        int k = 0;
        for (int num : nums1) {
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }
        for (int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0){
                res[k++] = num;
                map.put(num,map.get(num) - 1);
            }
        }
        return Arrays.copyOf(res,k);
    }



    /**
     * Time complexity: O(N*LogN + M*LogM)
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
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
                res[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(res,k);
    }

}
