package cn.keaper.p119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class Solution {

    /**
     * cost:0ms
     */
    public List<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex + 1];
        for(int c = 0 ; c <= rowIndex ; c ++){
            res[0] = res[c] = 1;
            int pre = res[0];
            for(int i = 1 ; i < c; i ++){
                int temp = res[i];
                res[i] += pre;
                pre = temp;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int j = 0; j <= rowIndex; j ++) {
            result.add(res[j]);
        }
        return result;
    }

    /**
     * cost:1ms
     * maybe box and unbox is cost much time
     */
    public List<Integer> getRow1(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        for(int c = 0 ; c <= rowIndex ; c ++){
            res[0] = res[c] = 1;
            int pre = res[0];
            for(int i = 1 ; i < c; i ++){
                int temp = res[i];
                res[i] += pre;
                pre = temp;
            }
        }
        return Arrays.asList(res);
    }
}
