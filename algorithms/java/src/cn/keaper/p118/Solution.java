package cn.keaper.p118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for(int c = 0 ; c < numRows ; c ++){
            Integer[] current = new Integer[c + 1];
            current[0] = current[c] = 1;
            for(int i = 1 ; i < c; i ++){
                current[i] = result.get(c - 1).get(i - 1) + result.get(c - 1).get(i);
            }
            result.add(Arrays.asList(current));
        }
        return result;
    }
}
