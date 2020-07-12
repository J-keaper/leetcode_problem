package cn.keaper.p22;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Solution {

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs("", n, n);
        return res;
    }

    private void dfs(String part, int left, int right){
        if(left == 0 && right == 0){
            res.add(part);
            return;
        }
        if(left > 0 && left - 1 <= right){
            dfs(part + "(", left - 1, right);
        }
        if(right > 0 && left <= right - 1){
            dfs(part + ")", left, right - 1);
        }
    }
}
