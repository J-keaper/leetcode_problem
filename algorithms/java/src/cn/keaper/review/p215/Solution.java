package cn.keaper.review.p215;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int findKthLargest1(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if(heap.size() < k){
                heap.offer(num);
            }else if(heap.peek() < num){
                heap.offer(num);
                heap.poll();
            }
        }
        return heap.peek();
    }


    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    public int findKthLargest(int[] nums, int l, int r, int k) {
        if(l == r){
            return nums[l];
        }
        int m = partition(nums, l, r);
        if(m < k){
            return findKthLargest(nums, m + 1, r, k);
        }
        if(m > k){
            return findKthLargest(nums, l, m - 1, k);
        }
        return nums[m];
    }


    private int partition(int[] nums, int l, int r){
        int i = l, j = r, key = nums[l];
        while (i < j){
            while (i < j && nums[j] <= key) j--;
            if(i < j) nums[i] = nums[j];
            while (i < j && nums[i] >= key) i++;
            if(i < j) nums[j] = nums[i];
        }
        nums[i] = key;
        return i;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new Solution().findKthLargest1(new int[]{3,2,1,5,6,4}, 2));

        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(new Solution().findKthLargest1(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}