package cn.keaper.p346;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * 自己实现环形队列
 */
public class MovingAverage1 {

    private int size, sum, head, count;
    private int[] queue;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage1(int size) {
        this.sum = this.head = this.count = 0;
        this.size = size;
        queue = new int[size];
    }

    public double next(int val) {
        if (count >= size) {
            sum -= queue[head];
            count--;
        }
        sum += (queue[head] = val);
        count++;
        head = (head + 1) % size;
        return (double) sum / Math.min(count, size);
    }
}
