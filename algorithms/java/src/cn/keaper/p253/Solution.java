package cn.keaper.p253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class Solution {

    /**
     * 首先，将会议按照开始时间排序，排序之后依次开始会议
     * 使用一个最小堆保存正在进行的会议的最小结束时间
     * 如果准备开始一个会议时，该会议的开始时间大于等于堆顶值说明已经有会议结束了我们可以使用会议室
     * <p>
     * 最后堆的大小就是所需的会议室数量
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.poll();
            }
            heap.offer(intervals[i][1]);
        }
        return heap.size();
    }

    /**
     * 实际上对于每个准备开始的会议，我们只需要知道是否有会议结束即可，不需要关心结束的会议是哪个时候开始的
     * 所以我们分别对开始时间和结束时间排序
     * 然后根据开始时间依次开始会议，使用一个指针指向最快的结束时间(类似于堆的思想)
     * 如果发现没有已经结束的会议室那么需要增加一个，否则则可以复用
     */
    public int minMeetingRooms1(int[][] intervals) {
        int[] start = new int[intervals.length], end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s = 0, e = 0, rooms = 0;
        while (s < intervals.length){
            if (start[s] < end[e]){
                rooms++;
            }else{
                e++;
            }
            s++;
        }
        return rooms;
    }
}
