package cn.keaper.p239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class Solution {

    /**
     * 暴力法
     * Time：O(N*k)
     * 超时
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            res[i - k + 1] = Integer.MIN_VALUE;
            for (int j = i - k + 1; j <= i; j++) {
                res[i - k + 1] = Math.max(res[i - k + 1], nums[j]);
            }
        }
        return res;
    }


    /**
     * 思想是维护一个能在O(1)时间内计算出当前窗口最大值的数据结构
     * 与单调栈类似，我们维护一个单调的双向队列，保持队列从队首到队尾严格递减，并且保持队列中不包含窗口外的元素
     * 每次将一个元素加入队列中都进行
     * 1. 首先将滑动窗口外的元素移除，为了达到这一目的，我们在队列中应该存储元素的下标
     * 2. 类似单调栈操作，依次从队尾弹出元素直到加入当前元素仍然满足单调递减，因为小于当前元素的值不可能是当前及之后窗口的最大值
     * <p>
     * 每次操作完，队首元素都是窗口内的最大值
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }


    /**
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
     * 将输入数组分割成有 k 个元素的块,若 n % k != 0，则最后一块的元素个数可能更少。
     * 开头元素为 i ，结尾元素为 j 的当前滑动窗口可能在一个块内，也可能在两个块中
     * 建立数组 left， 其中 left[j] 是从块的开始到下标 j 最大的元素，方向 左->右。
     * 建立数组 right，其中 right[j] 是从块的结尾到下标 j 最大的元素，方向 右->左。
     *
     * 两数组一起可以提供两个块内元素的全部信息。考虑从下标 i 到下标 j的滑动窗口。
     * 根据定义，right[i] 是左侧块内的最大元素， left[j] 是右侧块内的最大元素。因此滑动窗口中的最大元素为 max(right[i], left[j])。
     *
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] left = new int[nums.length], right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i % k == 0){
                left[i] = nums[i];
            }else{
                left[i] = Math.max(left[i - 1], nums[i]);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1 || i % k == k - 1){
                right[i] = nums[i];
            }else{
                right[i] = Math.max(right[i + 1], nums[i]);
            }
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <=nums.length - k; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }

}
