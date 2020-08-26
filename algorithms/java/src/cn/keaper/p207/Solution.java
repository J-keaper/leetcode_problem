package cn.keaper.p207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class Solution {


    /**
     *
     * @see cn.keaper.p210.Solution
     *
     * 将每个课程看作一个节点，有先修课程关系的两门课之间有一条单向边，表示先修关系
     * 那么问题为判断这个图是否存在一个拓扑排序
     *
     * 根据 节点之间的的边 构建一个用领接表存储的图，并记录每个节点的入度
     * 使用一个队列来进行广度优先搜索，开始时，所有入度为 0 的节点都被放入队列中，
     * 它们就是可以作为拓扑排序最前面的节点，并且它们之间的相对顺序是无关紧要的。
     *
     * 在广度优先搜索的每一步中，我们取出队首的节点 u：
     * 1. 我们将 u 放入答案中；
     * 2. 我们将 u 的所有相邻节点的入度减少 1。如果某个相邻节点 v 的入度变为 0，那么我们就将 v 放入队列中。
     *
     * 如果答案中包含了这 n 个节点，那么我们就找到了一种拓扑排序，否则说明图中存在环，也就不存在拓扑排序了。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建临接表及入度
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            int top = queue.poll();
            count++;
            for (Integer target : edges.get(top)) {
                inDegree[target]--;
                if(inDegree[target] == 0){
                    queue.add(target);
                }
            }
        }
        return count == numCourses;
    }
}
