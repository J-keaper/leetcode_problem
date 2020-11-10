package cn.keaper.p973;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class Solution {

    public int[][] kClosest2(int[][] points, int K) {
        quickSelect(points,0, points.length - 1, K - 1);
        return Arrays.copyOf(points, K);
    }

    /**
     * 我们的目的是寻找最小的 k 个数。假设经过一次 partition 操作，枢纽元素位于下标 m，也就是说，左侧的数组有 m 个元素，是原数组中最小的 m 个数。那么：
     *
     * 若 k = m，我们就找到了最小的 k 个数，就是左侧的数组；
     * 若 k < m，则最小的 k 个数一定都在左侧数组中，我们只需要对左侧数组递归 partition 即可；
     * 若 k > m，则左侧数组中的 m 个数都属于最小的 k 个数，我们还需要在右侧数组中寻找最小的 k-m 个数，对右侧数组递归地 partition 即可。
     */
    void quickSelect(int[][] points, int l, int r, int k){
        int pos = partition(points, l , r);
        if(pos == k){
            return;
        }
        if(pos < k){
            quickSelect(points, pos + 1, r, k);
        }else{
            quickSelect(points, l, pos - 1, k);
        }
    }


    /**
     * 快速排序的核心
     * 将数组元素调换顺序使得 某个位置 pos 左边的元素都比 point[l] 小，右边的元素都比 point[l] 大
     */
    int partition(int[][] points, int l, int r){
        int i = l, j = r;
        int[] base = points[l];
        while (i < j){
            while (i < j && compare(base, points[j]) < 0) j--;
            if(i < j) points[i++] = points[j];
            while (i < j && compare(base, points[i]) > 0) i++;
            if(i < j) points[j--] = points[i];
        }
        points[i] = base;
        return i;
    }


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
