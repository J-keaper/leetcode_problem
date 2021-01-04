package cn.keaper.p830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 */
public class Solution {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i - 1)){
                if(i - start > 2){
                    res.add(Arrays.asList(start, i - 1));
                }
                start = i;
            }
        }
        if(s.length() - start > 2){
            res.add(Arrays.asList(start, s.length() - 1));
        }
        return res;
    }
}
