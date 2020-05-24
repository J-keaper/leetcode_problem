package cn.keaper.p215;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class Solution {


    /**
     * 使用PriorityQueue作为一个最小堆,
     * 维护一个大小为k的最小堆，依次添加元素，遍历完之后堆顶就是结果
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            heap.add(num);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.poll();
    }

    /**
     * 自己实现堆
     */
    public int findKthLargest1(int[] nums, int k) {
        int[] heap = new int[k];
        System.arraycopy(nums, 0, heap, 0, k);
        // 构造最小堆
        for(int i = (k - 1) >> 1; i >= 0; i--){
            shiftDown(heap, i);
        }

        for(int i = k; i < nums.length; i++){
            if(nums[i] > heap[0]){
                heap[0] = nums[i];
                shiftDown(heap, 0);
            }
        }
        return heap[0];
    }

    private void shiftDown(int[] heap, int index){
        int target = heap[index];
        int father = index, child;
        while ((child = father * 2 + 1) < heap.length){
            if(child + 1 < heap.length && heap[child + 1] < heap[child]){
                child++;
            }
            if(target < heap[child]) break;
            heap[father] = heap[child];
            father = child;
        }
        heap[father] = target;
    }


    /**
     * 快速选择算法,快排的思想
     * 首先将数组按照一个基准值分为小于他的部分和大于他的部分
     * 如果分割的位置等于K,则该位置上的数就是答案，否则根据长度判断应该在左区间还是右区间进行递归
     *
     */
    public int findKthLargest2(int[] nums, int k) {
        return findKthLargest2(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest2(int[] nums, int l, int r, int k) {
        if(l == r){
            return nums[l];
        }
        int index = partition(nums, l, r);
        if(index == k) return nums[index];
        if(index > k){
            return findKthLargest2(nums, l, index - 1, k);
        }else {
            return findKthLargest2(nums, index + 1, r, k);
        }
    }

    private int partition(int[] nums, int l, int r){
        int i = l, j = r, key = nums[l];
        while (i < j){
            while (i < j && nums[j] <= key) j--;
            if(i < j) nums[i++] = nums[j];
            while (i < j && nums[i] >= key) i++;
            if(i < j) nums[j--] = nums[i];
        }
        nums[i] = key;
        return i;
    }



}
