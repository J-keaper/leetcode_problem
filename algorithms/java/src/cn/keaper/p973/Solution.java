package cn.keaper.p973;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class Solution {

    /**
     * 使用 PriorityQueue 维护一个大小为K的大顶堆
     * 依次向 PriorityQueue 中加入点，直到队列大小为K
     * 对于剩下的元素，如果待加入元素比堆顶元素更接近原点，那么删除堆顶元素加入该元素
     *
     * 元素处理完之后队列内元素即为结果
     */
    public int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(p -> -(p[0] * p[0] + p[1] * p[1])));
        for (int[] point : points) {
            if(queue.size() < K){
                queue.offer(point);
            }else if(!queue.isEmpty() && queue.comparator().compare(point, queue.peek()) > 0){
                queue.poll();
                queue.offer(point);
            }
        }

        int[][] res = new int[K][2];
        int i = 0;
        for (int[] ints : queue) {
            res[i++] = ints;
        }
        return res;
    }

    /**
     * 堆排序
     * 维护一个小根堆，每次取堆顶元素之后将最后一个元素移到堆顶并调整
     */
    public int[][] kClosest(int[][] points, int K) {

        int[][] res = new int[K][2];
        // 构造最小堆
        for (int i = points.length / 2; i >= 0; i--) {
            shiftDown(points, points.length, i);
        }

        // 依次找到最小的K个元素
        for (int i = 0; i < K; i++) {
            res[i] = points[0];
            points[0] = points[points.length - i - 1];
            shiftDown(points, points.length - i - 1, 0);
        }

        return res;
    }

    /**
     * 向下调整
     */
    void shiftDown(int[][] points, int size, int index){
        int[] target = points[index];
        int father = index, child;
        while ((child = father * 2 + 1) < size){
            if(child + 1 < size && compare(points[child], points[child + 1]) > 0) child ++;
            if(compare(target, points[child]) < 0) break;
            points[father] = points[child];
            father = child;
        }
        points[father] = target;
    }


    /**
     * 比较函数
     */
    int compare(int[] pointA, int[] pointB){
        int disA = pointA[0] * pointA[0] + pointA[1] * pointA[1];
        int disB = pointB[0] * pointB[0] + pointB[1] * pointB[1];
        return Integer.compare(disA, disB);
    }

}
