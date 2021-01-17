package cn.keaper.p347;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class Solution {

    /**
     * 使用Map计算每个元素的数量
     * 然后依次遍历Map，维护一个大小为K的堆，堆顶元素为出现频率第K大的元素
     * 最后堆中元素即为结果
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        map.forEach((num, count) -> {
            if(heap.size() < k){
                heap.offer(num);
            }else if(map.get(heap.peek()) < count){
                heap.poll();
                heap.offer(num);
            }
        });
        int[] res = new int[k];
        int i = 0;
        for (Integer integer : heap) {
            res[i++] = integer;
        }
        return res;
    }
}
