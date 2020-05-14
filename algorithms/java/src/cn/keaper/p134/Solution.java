package cn.keaper.p134;


/**
 * https://leetcode.com/problems/gas-station/
 */
public class Solution {

    /**
     * 从第一站开始从左到右走
     * sum 记录到达每一站时的剩余油量
     * 如果油量小于0说明，从当前位置到不了下一位置，说明从第一站开始不符合条件
     * 继续从下一位置开始重新走，同时记录之前阶段缺少的油量
     * 循环上述步骤，如果到最后剩余油量大于等于之前阶段缺少的油量之和，那么就是有解的
     * 因为剩余油量可以补偿之前缺少的油量否则就是无解的
     *
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, debt = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            if(sum < 0){
                start = i + 1;
                debt -= sum;
                sum = 0;
            }
        }
        return sum >= debt ? start : -1;
    }

}
