package cn.keaper.review.p349;

import java.util.*;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        int[] res = new int[Math.min(set1.size(), set2.size())];
        int index = 0;
        for (Integer i1 : set1) {
            if(set2.contains(i1)){
                res[index++] = i1;
            }
        }
        return index == res.length ? res : Arrays.copyOf(res, index);
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
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
                if(k == 0 || res[k - 1] != nums1[i]){
                    res[k++] = nums1[i];
                }
                i++;
                j++;
            }
        }
        return k == res.length ? res : Arrays.copyOf(res, k);
    }


    public static void main(String[] args) {

         Solution solution = new Solution();
         List<int[]> cases = Arrays.asList(
                new int[]{1,2,2,1},
                new int[]{2,2},
                new int[]{4,9,5},
                new int[]{9,4,9,8,4}
        );

        for (int i = 0; i < cases.size(); i+=2) {
            System.out.println(Arrays.toString(solution.intersection(cases.get(i), cases.get(i + 1))));
            System.out.println(Arrays.toString(solution.intersection1(cases.get(i), cases.get(i + 1))));
            System.out.println();
        }

    }
}
