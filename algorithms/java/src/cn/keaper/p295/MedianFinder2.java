package cn.keaper.p295;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * 使用插入排序是的List始终有序
 * 获取中位数就可以做到O(1)
 */
public class MedianFinder2 {

    private List<Integer> nums = new ArrayList<>();

    /** initialize your data structure here. */
    public MedianFinder2() {

    }

    /**
     * O(LogN) + O(N)
     */
    public void addNum(int num) {
        int index = Collections.binarySearch(nums, num);
        if(index >= 0){
            nums.add(index, num);
        }else{
            nums.add(- index - 1, num);
        }
    }

    /**
     * O(1)
     */
    public double findMedian() {
        return (nums.size() & 1) == 1 ? nums.get(nums.size() / 2) : (nums.get(nums.size() / 2 - 1) + nums.get(nums.size() / 2)) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());


        medianFinder = new MedianFinder();
        medianFinder.addNum(0);
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
    }
}
