package cn.keaper.p1013;

import java.util.*;

/**
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class Solution {

    /**
     * 下面方法的优化版，不需要占用额外空间
     *
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int value : A) {
            sum += value;
        }
        if(sum % 3 != 0){
            return false;
        }
        int part = sum / 3;

        int i = 0, s = 0;
        for (; i < A.length; i++){
            s += A[i];
            if(s == part){
                break;
            }
        }
        if(s != part){
            return false;
        }
        for (i ++; i < A.length - 1; i++){
            s += A[i];
            if(s == part * 2){
                return true;
            }
        }
        return false;
    }



    /**
     *
     * 假设数组大小为C，所有元素之和为S，前缀和数组sum
     * 可以等分成三等份相当于存在两个位置i，j
     * 满足 i < j < C && S/3 == sum[i] && S * 2/3 == sum[j]
     *
     * 维护每个前缀和的下标位置列表，判断是否存在一个 i，j 满足上述条件
     *
     */
    public boolean canThreePartsEqualSum1(int[] A) {
        if(A.length < 3){
            return false;
        }
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            A[i] = i == 0 ? A[i] : A[i]+ A[i-1];
            pos.computeIfAbsent(A[i], k -> new ArrayList<>());
            pos.get(A[i]).add(i);
        }
        int all = A[A.length-1];
        if(all % 3 != 0){
            return false;
        }
        int part = all / 3;
        List<Integer> posFirst = pos.get(part);
        List<Integer> posSecond = pos.get(part * 2);
        if(posFirst == null || posFirst.isEmpty() || posSecond == null || posSecond.isEmpty()){
            return false;
        }
        int minFirstPos = A.length, minSecondPos = A.length;
        for (Integer i : posFirst) {
            minFirstPos = Math.min(minFirstPos, i);
        }
        for (Integer i : posSecond) {
            if(i > minFirstPos){
                minSecondPos = Math.min(minSecondPos, i);
            }
        }
        return minFirstPos < minSecondPos && minSecondPos < A.length - 1;
    }

}
