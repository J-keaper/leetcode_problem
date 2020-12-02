package cn.keaper.p321;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/create-maximum-number/
 */
public class Solution {

    /**
     * 假设nums1长度为 l1，nums2长度为 l2
     * 最终长度为 k，假设从nums1中获得的数字个数为 x，从nums2中获得的数字个数为 y
     * 那么 0 <= x < l1, 0 <= y < l2 且 x+y == k
     *
     * 我们枚举所有的(x,y)
     * 对于每组 (x,y) ，找出num1中长度为 x 的最大子序列，nums中长度为 y 的最大子序列，然后将二者合并得到一个最大值
     * 求出所有的 (x,y) 中对应的最大数字的最大值
     *
     * 如何求出一个序列中的长度为x的最大子序列呢，与 P402 类似，可以使用单调栈实现
     *
     * @see cn.keaper.p402.Solution
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int start = Math.max(0, k - nums2.length), end = Math.min(k, nums1.length);
        for (int i = start; i <= end; i++) {
            int[] subSeq1 = maxSubSeq(nums1, i);
            int[] subSeq2 = maxSubSeq(nums2, k - i);
            int[] value = merge(subSeq1, subSeq2);
            if(compare(res,0, value, 0) < 0){
                res = value;
            }
        }
        return res;

    }


    /**
     * 计算nums数组中长度为k的子序列的最大值
     * 维护一个单调递减的单调栈，依次将元素加入栈中
     * 如果当前元素比栈顶元素大，那么将当前元素加入栈中能够使结果更大，所以依次将栈顶小于当前元素的值弹出，将当前元素入栈
     *
     *
     * @see cn.keaper.p402.Solution
     */
    int[] maxSubSeq(int[] nums, int k){
        if(k == 0){
            return new int[]{};
        }
        int[] stack = new int[k];
        int top = 0, drop = nums.length - k;
        for (int num : nums) {
            while (drop > 0 && top > 0 && stack[top - 1] < num) {
                top--;
                drop--;
            }
            if(top < k){  // 如果栈未满，入栈
                stack[top++] = num;
            }else{  // 如果栈已满
                drop--;
            }
        }
        return stack;
    }


    /**
     * 计算两个序列合并后的最大值，类似归并排序
     */
    int[] merge(int[] nums1, int[] nums2){
        if(nums1.length == 0){
            return nums2;
        }
        if(nums2.length == 0){
            return nums1;
        }
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length){
            res[k++] = compare(nums1, i, nums2, j) < 0 ? nums2[j++] : nums1[i++];
        }
        while (i < nums1.length){
            res[k++] = nums1[i++];
        }
        while (j < nums2.length){
            res[k++] = nums2[j++];
        }
        return res;
    }

    /**
     * 比较两个序列的大小
     */
    int compare(int[] nums1,int i1, int[] nums2, int i2){
        while (i1 < nums1.length && i2 < nums2.length){
            if(nums1[i1] != nums2[i2]){
                return nums1[i1] - nums2[i2];
            }
            i1++;
            i2++;
        }
        return (nums1.length - i1) - (nums2.length - i2);
    }

}
