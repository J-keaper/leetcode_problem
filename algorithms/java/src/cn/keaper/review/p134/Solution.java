package cn.keaper.review.p134;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, sum = 0, debt = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if(sum < 0){
                start = i + 1;
                debt += -sum;
                sum = 0;
            }
        }
        return sum >= debt ? start : -1;
    }

}
