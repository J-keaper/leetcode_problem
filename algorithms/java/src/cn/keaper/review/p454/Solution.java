package cn.keaper.review.p454;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> AB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                AB.merge(a + b, 1, Integer::sum);
            }
        }
        int res = 0;
        for (int c : C) {
            for (int d : D) {
                res += AB.getOrDefault(-c-d, 0);
            }
        }
        return res;
    }

}
