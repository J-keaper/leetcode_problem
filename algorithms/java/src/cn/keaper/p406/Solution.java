package cn.keaper.p406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class Solution {

    /**
     *
     *
     * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode-sol/
     *
     * 首先按照 [身高（p[0]）] 从高到低 排序，如果身高相同，按照 [之前大于等于其身高的人数(p[1])] 从小到大 排序
     * 然后依次遍历，将每个数都移动到 p[1] 所指的位置，因为我们是按照身高从大到小排序的，所以 p[1] 一定小于当前元素所在位置，所以一定是向前移动的
     *
     *
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1,p2) -> {
            if(p1[0] == p2[0]){
                return p1[1] - p2[1];
            }
            return p2[0] - p1[0];
        });
        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[][]{});
    }



}
