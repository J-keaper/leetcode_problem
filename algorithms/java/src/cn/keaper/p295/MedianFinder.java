package cn.keaper.p295;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * 使用ArrayList存储元素
 * 求中位数的时候排序计算中位数
 */
public class MedianFinder {

    private List<Integer> nums = new ArrayList<>();

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    /**
     * Time：O(1)
     */
    public void addNum(int num) {
        nums.add(num);
    }

    /**
     * Time：O(N*LogN)
     */
    public double findMedian() {
        Collections.sort(nums);
        return (nums.size() & 1) == 1 ? nums.get(nums.size() / 2) : (nums.get(nums.size() / 2 - 1) + nums.get(nums.size() / 2)) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
