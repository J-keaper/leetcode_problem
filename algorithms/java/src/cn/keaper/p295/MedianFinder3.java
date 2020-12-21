package cn.keaper.p295;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * 使用两个堆，一个大根堆，一个小根堆，大根堆存放较小的一半元素，小根堆存放较大的一半元素，维持两个堆的大小相同，那么这两个堆的根节点就是中位数。
 * 当 N 为奇数时，中位数就是大根堆的根节点，当 N 为偶数时，中位数就是两个堆的根节点之和除以 2。
 * addNum()时间复杂度是 O(LogN), findMedian()的时间复杂度是 O(1)。
 */
public class MedianFinder3 {

    private Queue<Integer> big = new PriorityQueue<>(Comparator.comparingInt(i -> i));
    private Queue<Integer> small = new PriorityQueue<>(Comparator.comparingInt(i -> -i));

    /** initialize your data structure here. */
    public MedianFinder3() {

    }

    /**
     * O(LogN)
     *
     * big比small可以允许多当一个元素
     *
     * 1. 向big中增加一个元素，增加的方法是先加到small中，然后将small中的最大元素加入big
     * 2. 如果big、small中元素数量之差大于1，那么需要从big中向small中转移数据
     */
    public void addNum(int num) {
        small.offer(num);
        big.offer(small.poll());
        if(big.size() > small.size() + 1){
            small.offer(big.poll());
        }
    }

    /**
     * O(1)
     */
    public double findMedian() {
        if(big.size() == small.size()){
            return (big.peek() + small.peek()) / 2.0;
        }else{
            return big.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder3 medianFinder = new MedianFinder3();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());

    }
}
