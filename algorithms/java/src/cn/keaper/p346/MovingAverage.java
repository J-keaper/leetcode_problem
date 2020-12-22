package cn.keaper.p346;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * 使用队列来维护元素，并且维护所有元素的和，免去重复计算
 */
public class MovingAverage {

    private int size;
    private int sum;
    private Queue<Integer> q;


    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.sum = 0;
        this.size = size;
        q = new LinkedList<>();
    }

    public double next(int val) {
        if (!q.isEmpty() && q.size() >= size) {
            sum -= q.poll();
        }
        q.offer(val);
        sum += val;
        return (double) sum / Math.min(size, q.size());
    }
}
