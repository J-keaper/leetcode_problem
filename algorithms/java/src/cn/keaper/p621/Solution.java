package cn.keaper.p621;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
     * <p>
     * 那么我们假设有宽度为[n+1],长度为[最多的单种任务数(maxCount)]的矩阵，表示我们从左向右，从上往下执行任务
     * 我们需要将任务安排进这个矩阵，只要同种类型任务排在同一列即可满足条件
     * 我们把数量最多的任务安排在最左侧，这样最后一行就可以不必计算等待时间
     * 假设任务数等与maxCount的任务种类数量为maxTask
     * <p>
     * 可见如果任务数量 小于等于 maxTask + (n+1) * (maxTask-1) 的时候，那么最多只需要这么时间
     * 否则相当于冷却时间全部被任务填满，不需要等待，任务执行最短时间即为任务数量
     * <p>
     * +---+---+---+---+
     * | A | C | E | D |
     * +---------------+
     * | A | C | B | D |
     * +---------------+
     * | A | C | B | D |                                                                                                                                                                                                                                                                                      "E","B","H","H","A","J","C","C","D","C","B","C","H","H","I","H","D","C","B","D","C","H","A","F","A","J","D","F","E","H","I","D","A","E","B","H","J","F","D","C","J","J","I","A","I","J","H","A","I","I","G","C","C","H","D","B","B","B","H","I","D","B","C","H","I","I","G","E","D","D","A","E","D","H","C","J","H","C","E","I","F","A","I","E","G","A","E","F","I","B","J","B","J","B","G","A","D","C","B","I","A","C","J","J","J","B","E","E","E","B","E","B","H","B","J","H","F","G","B","B","I","C","D","I","D","D","A","I","D","H","A","J","D","J","D","I","G","F","F","B","G","A","F","I","I","H","C","B","H","H","E","F","A","H","G","F","D","G","F","A","C","F","D","F","C","J","A","D","H","G","D","D","G","C","G","C","I","B","G","E","J","C","G","
     * +---------------+
     * | A | C | B | E |
     * +---------------+
     * | A | C |   |   |
     * +---+---+---+---+
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxCount = Integer.MIN_VALUE;
        for (int i : count) {
            maxCount = Math.max(maxCount, i);
        }
        int maxTask = 0;
        for (int i : count) {
            if (i == maxCount) maxTask++;
        }

        return Math.max(tasks.length, maxTask + ((n + 1) * (maxCount - 1)));
    }
}
