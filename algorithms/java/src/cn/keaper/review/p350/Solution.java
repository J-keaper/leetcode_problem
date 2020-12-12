package cn.keaper.review.p350;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            map1.merge(i,1, Integer::sum);
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int i : nums2) {
            if(map1.getOrDefault(i, 0) > 0){
                res[index++] = i;
                map1.merge(i, -1, Integer::sum);
            }
        }
        return index == res.length ? res : Arrays.copyOf(res, index);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
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
        return k == res.length ? res : Arrays.copyOf(res, k);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new Solution().intersect1(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println();
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(new Solution().intersect1(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }


}
