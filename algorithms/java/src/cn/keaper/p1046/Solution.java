package cn.keaper.p1046;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * https://leetcode.com/problems/last-stone-weight/
 */
public class Solution {


    /**
     * 大顶堆
     */
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() >= 2){
            int y = queue.poll(), x = queue.poll();
            if(y > x){
                queue.offer(y - x);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }


    /**
     * 从小到大排序
     * 每次只处理最后两个数，然后再次排序
     */
    public int lastStoneWeight1(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length;
        while (len > 1 && stones[len - 2] != 0){
            stones[len - 1] -= stones[len - 2];
            stones[len - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[len - 1];
    }
}
